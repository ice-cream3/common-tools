package util;

import java.util.Collection;
import java.util.Iterator;

public abstract class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static final String EMPTY_STRING = "";

    public static final String NULL = "null";

    public static final String SEP = " ";

    public static final String LINE_SEP = System.getProperty("line.separator");

    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * 获取分隔符分隔的第一个字符串
     *
     * @param str
     * @param regex
     * @return
     */
    public static String getFirst(String str, String regex) {
        String[] array = split(str, regex);
        if (array.length <= 1) {
            return str;
        }
        return array[0];
    }

    /**
     * 获取分隔符分隔的最后一个字符串
     *
     * @param str
     * @param regex
     * @return
     */
    public static String getLast(String str, String regex) {
        String[] array = split(str, regex);
        if (array.length <= 1) {
            return str;
        }
        return array[array.length - 1];
    }

    public static String upperFirst(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String concat(Object... obj) {
        StringBuilder sb = new StringBuilder();
        for (Object each : obj) {
            sb.append(each);
        }
        return sb.toString();
    }

    public static String concatBySepAndColl(String sep, Collection<?> collection) {
        Iterator<?> iter = collection.iterator();
        int size = collection.size();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            Object item = iter.next();
            sb.append(item);
            if (i + 1 < size) {
                sb.append(sep);
            }
            i++;
        }
        return sb.toString();
    }

    public static String chop(String str, int lastLen) {
        return str.substring(0, str.length() - lastLen);
    }


    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     * <p>
     * 由于Java是基于Unicode编码的，因此，一个汉字的长度为1，而不是2。但有时需要以字节单位获得字符串的长度。例如，“123abc长城”按字节长度计算是10，而按Unicode计算长度是8。为了获得10，需要从头扫描根据字符的Ascii来获得具体的长度。
     * 如果是标准的字符，Ascii的范围是0至255，如果是汉字或其他全角字符，Ascii会大于255。
     *
     * @param s 指定的字符串
     * @return 字符串的长度
     */
    public static int length(String s) {
        if (isEmpty(s)) {
            return 0;
        }

        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(length("泰国龙眼500g/hz7250"));
    }
}
