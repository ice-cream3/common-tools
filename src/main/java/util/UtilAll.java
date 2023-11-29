package util;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @ClassName: UtilAll
 * @Description:
 * @Author: ice
 * @Date: 2023/11/29 16:12
 *
 * <dependency>
 *             <groupId>commons-validator</groupId>
 *             <artifactId>commons-validator</artifactId>
 *             <version>1.7</version>
 *         </dependency>
 */
public class UtilAll {

    private static final Logger log = LoggerFactory.getLogger("RocketmqCommon");
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd#HH:mm:ss:SSS";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    static final String HOST_NAME = ManagementFactory.getRuntimeMXBean().getName();

    public UtilAll() {
    }

    public static int getPid() {
        try {
            return Integer.parseInt(HOST_NAME.substring(0, HOST_NAME.indexOf(64)));
        } catch (Exception var1) {
            return -1;
        }
    }

    public static void sleep(long sleepMs) {
        if (sleepMs >= 0L) {
            try {
                Thread.sleep(sleepMs);
            } catch (Throwable var3) {
            }

        }
    }

    public static String currentStackTrace() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement[] var2 = stackTrace;
        int var3 = stackTrace.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement ste = var2[var4];
            sb.append("\n\t");
            sb.append(ste.toString());
        }

        return sb.toString();
    }

    public static String offset2FileName(long offset) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(20);
        nf.setMaximumFractionDigits(0);
        nf.setGroupingUsed(false);
        return nf.format(offset);
    }

    public static long computeElapsedTimeMilliseconds(long beginTime) {
        return System.currentTimeMillis() - beginTime;
    }

    public static boolean isItTimeToDo(String when) {
        String[] whiles = when.split(";");
        if (whiles.length > 0) {
            Calendar now = Calendar.getInstance();
            String[] var3 = whiles;
            int var4 = whiles.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String w = var3[var5];
                int nowHour = Integer.parseInt(w);
                if (nowHour == now.get(11)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String timeMillisToHumanString() {
        return timeMillisToHumanString(System.currentTimeMillis());
    }

    public static String timeMillisToHumanString(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d%02d%02d%02d%02d%02d%03d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13), cal.get(14));
    }

    public static long computeNextMorningTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computeNextMinutesTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 0);
        cal.add(12, 1);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computeNextHourTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 1);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computeNextHalfHourTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 1);
        cal.set(12, 30);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static String timeMillisToHumanString2(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d-%02d-%02d %02d:%02d:%02d,%03d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13), cal.get(14));
    }

    public static String timeMillisToHumanString3(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d%02d%02d%02d%02d%02d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13));
    }

    public static boolean isPathExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static double getDiskPartitionSpaceUsedPercent(String path) {
        if (null != path && !path.isEmpty()) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    log.error("Error when measuring disk space usage, file doesn't exist on this path: {}", path);
                    return -1.0;
                } else {
                    long totalSpace = file.getTotalSpace();
                    if (totalSpace > 0L) {
                        long usedSpace = totalSpace - file.getFreeSpace();
                        long usableSpace = file.getUsableSpace();
                        long entireSpace = usedSpace + usableSpace;
                        long roundNum = 0L;
                        if (usedSpace * 100L % entireSpace != 0L) {
                            roundNum = 1L;
                        }

                        long result = usedSpace * 100L / entireSpace + roundNum;
                        return (double)result / 100.0;
                    } else {
                        return -1.0;
                    }
                }
            } catch (Exception var14) {
                log.error("Error when measuring disk space usage, got exception: :", var14);
                return -1.0;
            }
        } else {
            log.error("Error when measuring disk space usage, path is null or empty, path : {}", path);
            return -1.0;
        }
    }

    public static int crc32(byte[] array) {
        return array != null ? crc32(array, 0, array.length) : 0;
    }

    public static int crc32(byte[] array, int offset, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(array, offset, length);
        return (int)(crc32.getValue() & 2147483647L);
    }

    public static String bytes2string(byte[] src) {
        char[] hexChars = new char[src.length * 2];

        for(int j = 0; j < src.length; ++j) {
            int v = src[j] & 255;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 15];
        }

        return new String(hexChars);
    }

    public static void writeInt(char[] buffer, int pos, int value) {
        char[] hexArray = HEX_ARRAY;

        for(int moveBits = 28; moveBits >= 0; moveBits -= 4) {
            buffer[pos++] = hexArray[value >>> moveBits & 15];
        }

    }

    public static void writeShort(char[] buffer, int pos, int value) {
        char[] hexArray = HEX_ARRAY;

        for(int moveBits = 12; moveBits >= 0; moveBits -= 4) {
            buffer[pos++] = hexArray[value >>> moveBits & 15];
        }

    }

    public static byte[] string2bytes(String hexString) {
        if (hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static byte[] uncompress(byte[] src) throws IOException {
        byte[] uncompressData = new byte[src.length];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);

        try {
            while(true) {
                int len = inflaterInputStream.read(uncompressData, 0, uncompressData.length);
                if (len <= 0) {
                    byteArrayOutputStream.flush();
                    byte[] result = byteArrayOutputStream.toByteArray();
                    return result;
                }

                byteArrayOutputStream.write(uncompressData, 0, len);
            }
        } catch (IOException var20) {
            throw var20;
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException var19) {
                log.error("Failed to close the stream", var19);
            }

            try {
                inflaterInputStream.close();
            } catch (IOException var18) {
                log.error("Failed to close the stream", var18);
            }

            try {
                byteArrayOutputStream.close();
            } catch (IOException var17) {
                log.error("Failed to close the stream", var17);
            }

        }
    }

    public static byte[] compress(byte[] src, int level) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);
        Deflater defeater = new Deflater(level);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, defeater);

        byte[] result;
        try {
            deflaterOutputStream.write(src);
            deflaterOutputStream.finish();
            deflaterOutputStream.close();
            result = byteArrayOutputStream.toByteArray();
        } catch (IOException var14) {
            defeater.end();
            throw var14;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException var13) {
            }

            defeater.end();
        }

        return result;
    }

    public static int asInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception var3) {
            return defaultValue;
        }
    }

    public static long asLong(String str, long defaultValue) {
        try {
            return Long.parseLong(str);
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            return df.parse(date);
        } catch (ParseException var4) {
            return null;
        }
    }

    public static String responseCode2String(int code) {
        return Integer.toString(code);
    }

    public static String frontStringAtLeast(String str, int size) {
        return str != null && str.length() > size ? str.substring(0, size) : str;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static String jstack() {
        return jstack(Thread.getAllStackTraces());
    }

    public static String jstack(Map<Thread, StackTraceElement[]> map) {
        StringBuilder result = new StringBuilder();

        try {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> ite = map.entrySet().iterator();

            while(true) {
                Map.Entry entry;
                StackTraceElement[] elements;
                Thread thread;
                do {
                    do {
                        if (!ite.hasNext()) {
                            return result.toString();
                        }

                        entry = (Map.Entry)ite.next();
                        elements = (StackTraceElement[])entry.getValue();
                        thread = (Thread)entry.getKey();
                    } while(elements == null);
                } while(elements.length <= 0);

                String threadName = ((Thread)entry.getKey()).getName();
                result.append(String.format("%-40sTID: %d STATE: %s%n", threadName, thread.getId(), thread.getState()));
                StackTraceElement[] var7 = elements;
                int var8 = elements.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    StackTraceElement el = var7[var9];
                    result.append(String.format("%-40s%s%n", threadName, el.toString()));
                }

                result.append("\n");
            }
        } catch (Throwable var11) {
            result.append(exceptionSimpleDesc(var11));
            return result.toString();
        }
    }

    public static String exceptionSimpleDesc(final Throwable e) {
        StringBuilder sb = new StringBuilder();
        if (e != null) {
            sb.append(e.toString());

            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StackTraceElement element = stackTrace[0];
                sb.append(", ");
                sb.append(element.toString());
            }
        }

        return sb.toString();
    }

    public static boolean isInternalIP(byte[] ip) {
        if (ip.length != 4) {
            throw new RuntimeException("illegal ipv4 bytes");
        } else if (ip[0] == 10) {
            return true;
        } else {
            if (ip[0] == -84) {
                if (ip[1] >= 16 && ip[1] <= 31) {
                    return true;
                }
            } else if (ip[0] == -64 && ip[1] == -88) {
                return true;
            }

            return false;
        }
    }

    public static boolean isInternalV6IP(InetAddress inetAddr) {
        return inetAddr.isAnyLocalAddress() || inetAddr.isLinkLocalAddress() || inetAddr.isLoopbackAddress() || inetAddr.isSiteLocalAddress();
    }

    private static boolean ipCheck(byte[] ip) {
        if (ip.length != 4) {
            throw new RuntimeException("illegal ipv4 bytes");
        } else {
            InetAddressValidator validator = InetAddressValidator.getInstance();
            return validator.isValidInet4Address(ipToIPv4Str(ip));
        }
    }

    private static boolean ipV6Check(byte[] ip) {
        if (ip.length != 16) {
            throw new RuntimeException("illegal ipv6 bytes");
        } else {
            InetAddressValidator validator = InetAddressValidator.getInstance();
            return validator.isValidInet6Address(ipToIPv6Str(ip));
        }
    }

    public static String ipToIPv4Str(byte[] ip) {
        return ip.length != 4 ? null : (ip[0] & 255) + "." + (ip[1] & 255) + "." + (ip[2] & 255) + "." + (ip[3] & 255);
    }

    public static String ipToIPv6Str(byte[] ip) {
        if (ip.length != 16) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < ip.length; ++i) {
                String hex = Integer.toHexString(ip[i] & 255);
                if (hex.length() < 2) {
                    sb.append(0);
                }

                sb.append(hex);
                if (i % 2 == 1 && i < ip.length - 1) {
                    sb.append(":");
                }
            }

            return sb.toString();
        }
    }

    public static byte[] getIP() {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            byte[] internalIP = null;

            label62:
            while(allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface)allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();

                while(true) {
                    while(true) {
                        if (!addresses.hasMoreElements()) {
                            continue label62;
                        }

                        ip = (InetAddress)addresses.nextElement();
                        byte[] ipByte;
                        if (ip != null && ip instanceof Inet4Address) {
                            ipByte = ip.getAddress();
                            if (ipByte.length == 4 && ipCheck(ipByte)) {
                                if (!isInternalIP(ipByte)) {
                                    return ipByte;
                                }

                                if (internalIP == null) {
                                    internalIP = ipByte;
                                }
                            }
                        } else if (ip != null && ip instanceof Inet6Address) {
                            ipByte = ip.getAddress();
                            if (ipByte.length == 16 && ipV6Check(ipByte) && !isInternalV6IP(ip)) {
                                return ipByte;
                            }
                        }
                    }
                }
            }

            if (internalIP != null) {
                return internalIP;
            } else {
                throw new RuntimeException("Can not get local ip");
            }
        } catch (Exception var6) {
            throw new RuntimeException("Can not get local ip", var6);
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                File[] var2 = files;
                int var3 = files.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    File file1 = var2[var4];
                    deleteFile(file1);
                }

                file.delete();
            }

        }
    }

    public static String join(List<String> list, String splitter) {
        if (list == null) {
            return null;
        } else {
            StringBuilder str = new StringBuilder();

            for(int i = 0; i < list.size(); ++i) {
                str.append((String)list.get(i));
                if (i == list.size() - 1) {
                    break;
                }

                str.append(splitter);
            }

            return str.toString();
        }
    }

    public static List<String> split(String str, String splitter) {
        if (str == null) {
            return null;
        } else {
            String[] addrArray = str.split(splitter);
            return Arrays.asList(addrArray);
        }
    }
}
