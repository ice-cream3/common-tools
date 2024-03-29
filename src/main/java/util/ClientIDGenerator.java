package util;

import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ClientIDGenerator
 * @Description: 参考rocketMQ(MessageClientIDSetter)生成id类
 * @Author: ice
 * @Date: 2023/11/29 16:11
 */
public class ClientIDGenerator {
    private static final String TOPIC_KEY_SPLITTER = "#";
    private static final int LEN;
    private static final char[] FIX_STRING;
    private static final AtomicInteger COUNTER;
    private static long startTime;
    private static long nextStartTime;

    public ClientIDGenerator() {
    }

    private static synchronized void setStartTime(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        startTime = cal.getTimeInMillis();
        cal.add(2, 1);
        nextStartTime = cal.getTimeInMillis();
    }

    public static Date getNearlyTimeFromID(String msgID) {
        ByteBuffer buf = ByteBuffer.allocate(8);
        byte[] bytes = UtilAll.string2bytes(msgID);
        int ipLength = bytes.length == 28 ? 16 : 4;
        buf.put((byte)0);
        buf.put((byte)0);
        buf.put((byte)0);
        buf.put((byte)0);
        buf.put(bytes, ipLength + 2 + 4, 4);
        buf.position(0);
        long spanMS = buf.getLong();
        Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();
        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        long monStartTime = cal.getTimeInMillis();
        if (monStartTime + spanMS >= now) {
            cal.add(2, -1);
            monStartTime = cal.getTimeInMillis();
        }

        cal.setTimeInMillis(monStartTime + spanMS);
        return cal.getTime();
    }

    public static String getIPStrFromID(String msgID) {
        byte[] ipBytes = getIPFromID(msgID);
        return ipBytes.length == 16 ? UtilAll.ipToIPv6Str(ipBytes) : UtilAll.ipToIPv4Str(ipBytes);
    }

    public static byte[] getIPFromID(String msgID) {
        byte[] bytes = UtilAll.string2bytes(msgID);
        int ipLength = bytes.length == 28 ? 16 : 4;
        byte[] result = new byte[ipLength];
        System.arraycopy(bytes, 0, result, 0, ipLength);
        return result;
    }

    public static int getPidFromID(String msgID) {
        byte[] bytes = UtilAll.string2bytes(msgID);
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        int value = wrap.getShort(bytes.length - 2 - 4 - 4 - 2);
        return value & '\uffff';
    }

    public static String createUniqID() {
        char[] sb = new char[LEN * 2];
        System.arraycopy(FIX_STRING, 0, sb, 0, FIX_STRING.length);
        long current = System.currentTimeMillis();
        if (current >= nextStartTime) {
            setStartTime(current);
        }

        int diff = (int)(current - startTime);
        if (diff < 0 && diff > -1000000) {
            diff = 0;
        }

        int pos = FIX_STRING.length;
        UtilAll.writeInt(sb, pos, diff);
        pos += 8;
        UtilAll.writeShort(sb, pos, COUNTER.getAndIncrement());
        return new String(sb);
    }

    /*public static void setUniqID(Message msg) {
        if (msg.getProperty("UNIQ_KEY") == null) {
            msg.putProperty("UNIQ_KEY", createUniqID());
        }

    }

    public static String getUniqID(Message msg) {
        return msg.getProperty("UNIQ_KEY");
    }*/

    public static byte[] createFakeIP() {
        ByteBuffer bb = ByteBuffer.allocate(8);
        bb.putLong(System.currentTimeMillis());
        bb.position(4);
        byte[] fakeIP = new byte[4];
        bb.get(fakeIP);
        return fakeIP;
    }

    static {
        byte[] ip;
        try {
            ip = UtilAll.getIP();
        } catch (Exception var2) {
            ip = createFakeIP();
        }

        LEN = ip.length + 2 + 4 + 4 + 2;
        ByteBuffer tempBuffer = ByteBuffer.allocate(ip.length + 2 + 4);
        tempBuffer.put(ip);
        tempBuffer.putShort((short)UtilAll.getPid());
        tempBuffer.putInt(ClientIDGenerator.class.getClassLoader().hashCode());
        FIX_STRING = UtilAll.bytes2string(tempBuffer.array()).toCharArray();
        setStartTime(System.currentTimeMillis());
        COUNTER = new AtomicInteger(0);
    }
}
