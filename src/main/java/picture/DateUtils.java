package picture;

import util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final long MAX_TIME = 9999999999L;

    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String TIMESTAMP_SECOND = "TIMESTAMP_SECOND";

    public static final String MS = "yyyyMMddHHmmssSSS";
    public static final String SECOND = "yyyyMMddHHmmss";
    public static final String MINUTE = "yyyyMMddHHmm";
    public static final String HOUR = "yyyyMMddHH";
    public static final String DAY = "yyyyMMdd";
    public static final String MONTH = "yyyyMM";
    public static final String YEAR = "yyyy";

    public static final String FMT_MS = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String FMT_SECOND = "yyyy-MM-dd HH:mm:ss"; // 默认值
    public static final String FMT_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String FMT_HOUR = "yyyy-MM-dd HH";
    public static final String FMT_DAY = "yyyy-MM-dd";
    public static final String FMT_MONTH = "yyyy-MM";

    public static final String SLASH_FMT_MS = "yyyy/MM/dd HH:mm:ss,SSS";
    public static final String SLASH_FMT_SECOND = "yyyy/MM/dd HH:mm:ss";
    public static final String SLASH_FMT_MINUTE = "yyyy/MM/dd HH:mm";
    public static final String SLASH_FMT_HOUR = "yyyy/MM/dd HH";
    public static final String SLASH_FMT_DAY = "yyyy/MM/dd";
    public static final String SLASH_FMT_MONTH = "yyyy/MM";

    public static final String SLASH_SINGLE_HOUR = "HH:mm";

    public static final Date ZERO = new Date(0L);

    public static boolean isEmpty(Date date) {
        if (date == null) {
            return true;
        }
        if (date.getTime() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isSameDay(Date date, Date compableDate) {
        if (date == null || compableDate == null) {
            return false;
        }

        return StringUtils.equals(format(date, DAY), format(compableDate, DAY));
    }

    public static boolean isSameWeek(Date date, Date compableDate) {
        if (date == null || compableDate == null) {
            return false;
        }

        // 先把Date类型的对象转换Calendar类型的对象
        Calendar dateCal = Calendar.getInstance();
        dateCal.setFirstDayOfWeek(Calendar.MONDAY);
        Calendar compableCal = Calendar.getInstance();
        compableCal.setFirstDayOfWeek(Calendar.MONDAY);

        dateCal.setTime(date);
        compableCal.setTime(compableDate);

        // 比较当前日期在年份中的周数是否相同
        if (compableCal.get(Calendar.WEEK_OF_YEAR) == dateCal.get(Calendar.WEEK_OF_YEAR)) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getDateWithSameWeek(Date date, int dayOfWeek) {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setFirstDayOfWeek(Calendar.MONDAY);
        dateCal.setTime(date);
        // 取得当前是周几
        int currDayOfWeek = dateCal.get(Calendar.DAY_OF_WEEK);
        if (currDayOfWeek == dayOfWeek) {
            // 如果相等则返回自己
            return date;
        }

        if (Calendar.SUNDAY == currDayOfWeek) {
            // 当前是周日
            currDayOfWeek += 7;
        }

        if (Calendar.SUNDAY == dayOfWeek) {
            // 周日作为最后一天
            dayOfWeek += 7;
        }
        int offset = dayOfWeek - currDayOfWeek;
        return addDays(date, offset);
    }

    public static int getOffsetMoneths(Date start, Date end) {
        int startYear = DateUtils.toCalendar(start).get(Calendar.YEAR);
        int startMonth = DateUtils.toCalendar(start).get(Calendar.MONTH) + 1;
        int endYear = DateUtils.toCalendar(end).get(Calendar.YEAR);
        int endMonth = DateUtils.toCalendar(end).get(Calendar.MONTH) + 1;
        return (endYear * 12 + endMonth) - (startYear * 12 + startMonth);
    }

    public static int getOffsetDays(Date start, Date end) {
        long t = end.getTime() - start.getTime();
        t = t / (3600 * 24 * 1000);
        return (int) t;
    }

    public static int getOffsetSeconds(Date start, Date end) {
        long second = end.getTime() - start.getTime();
        second = second / 1000L;
        return (int) second;
    }

    public static Date now() {
        return new Date();
    }

    public static Date parseToDate(String str) {
        return parseToDate(str, FMT_SECOND);
    }

    public static Date parseToDate(String str, String patterns) {
        try {
            if (TIMESTAMP.equals(patterns)) {
                // 时间戳(毫秒)
                return new Date(Long.parseLong(str));
            } else if (TIMESTAMP_SECOND.equals(patterns)) {
                // 时间戳(秒)
                return new Date(Long.parseLong(str) * 1000L);
            }

            return DateUtils.parseDate(str, patterns);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String convertFormat(String day, String pattern,
                                       String toPattern) {
        if (StringUtils.isEmpty(day)) {
            return day;
        }
        day = StringUtils.trim(day);

        Date date;
        try {
            date = parseDate(day, pattern);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        return format(date, toPattern);
    }

    public static long getCurSecond() {
        return System.currentTimeMillis() / 1000L;
    }

    public static long getSecond(Date date) {
        return date.getTime() / 1000L;
    }

    /**
     * 获得月字符
     *
     * @param date
     * @return
     */
    public static String getMonthStr(Date date) {
        int month = DateUtils.toCalendar(date).get(Calendar.MONTH) + 1;
        return StringUtils.leftPad(String.valueOf(month), 2, "0");
    }

    /**
     * 获得多少毫秒以前的时间
     *
     * @param ms
     * @return
     */
    public static long getBeforeTime(long ms) {
        long beforeTime = System.currentTimeMillis() - ms;
        return beforeTime;
    }

    public static String format(String format) {
        return format(new Date(), format);
    }

    public static String format(Date date) {
        return format(date, FMT_SECOND);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Long parseSec(String str, String pattern)
            throws ParseException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return parseMs(str, pattern) / 1000L;
    }

    public static Long parseMs(String str, String pattern)
            throws ParseException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        Date date = parseDate(str, pattern);
        return date.getTime();
    }

    /**
     * @param time    秒绝对时间
     * @param pattern
     * @return
     */
    public static String formatBySec(Long time, String pattern) {
        if (time == null) {
            return null;
        }
        return format(time * 1000L, pattern);
    }

    /**
     * @param time    毫秒绝对时间
     * @param pattern
     * @return
     */
    public static String format(Long time, String pattern) {
        if (time == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(time));
    }

    /**
     * 将数据库中的createtime和updatetime转换成指定格式的字符串
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String convertLinuxTimeToString(Long time, String pattern) {
        Date date = new Date(time * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 用于比较当前时间是否在传入的开始和结束时间范围内
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return boolean
     */
    public static boolean compareTimeRange(Date beginDate, Date endDate) {
        Date date = new Date();
        if (date.getTime() >= beginDate.getTime() && date.getTime() <= endDate.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 转换日期
     *
     * @param timestamp 2017-08-22 21:02:57
     * @return
     */
    public static Date convertToDate(String timestamp) {
        if (StringUtils.isBlank(timestamp)) {
            return null;
        }
        try {
            return parseDate(timestamp, FMT_SECOND, FMT_DAY);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 校验开始与结束时间
     *
     * @param begin 开始时间
     * @param end   结束时间
     * @return
     */
    public static boolean compareDate(Date begin, Date end) {
        if (begin != null && end != null) {
            if (!compareTimeRange(begin, end)) {
                return false;
            }
        } else {
            Date date = new Date();
            if (begin != null && (date.getTime() < begin.getTime())) {
                return false;
            }
            if (end != null && (date.getTime() > end.getTime())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断传入两个日期大小
     * date1 > date2 return true
     * date1 < date2 return false
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compareDateTime(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date1 == null && date2 != null) {
            return false;
        }
        if (date1 != null && date2 == null) {
            return true;
        }
        return date1.getTime() - date2.getTime() > 0 ? true : false;

    }

    public static Date getStartTimeOfDay(Date date) {
        String ms = format(date, MS);
        // 00:00:00,000
        ms = ms.substring(0, 8) + "000000000";
        return parseToDate(ms, MS);
    }

    public static Date getEndTimeOfDay(Date date) {
        String ms = format(date, MS);
        // 23:59:59,999
        ms = ms.substring(0, 8) + "235959999";
        return parseToDate(ms, MS);
    }

    public static Date getFirstDayOfMonth(Date date) {
        Date firstDay = setDays(date, 1);

        return firstDay;
    }

    public static Date getLastDayOfMonth(Date date) {
        Date firstDayOfNextMonth = setDays(addMonths(date, 1), 1);

        return addDays(firstDayOfNextMonth, -1);
    }

    /**
     * 送货时间格式化
     *
     * @param date
     * @return
     */
    public static String getDateToDeliveryDay(Date date) {

        if (date == null) {
            return null;
        }

        int i = getOffsetDays(getStartTimeOfDay(new Date()), date);
        switch (i) {
            case 0: {
                return "今日达";
            }
            case 1: {
                return "次日达";
            }
            case 2: {
                return "隔日达";
            }
            default: {
                return StringUtils.join(DateUtils.format(date, "MM月dd日"), "送达");
            }
        }
    }

    public static void main(String[] args) {
        System.out
                .println(convertFormat("2015-05-18", "yyyy-MM-dd", "yyyyMMdd"));
        System.out.println(convertFormat("15:01", "HH:mm", "HHmm"));

        System.out.println(getOffsetMoneths(addYears(new Date(), -1), new Date()));

        Date now = new Date();

        System.out.println(getFirstDayOfMonth(getStartTimeOfDay(now)));
        System.out.println(getLastDayOfMonth(getEndTimeOfDay(now)));

        System.out.println(isSameWeek(parseToDate("20170101", DAY), parseToDate("20170107", DAY)));

        System.out.println(isSameDay(parseToDate("20170107", DAY), parseToDate("20170107", DAY)));

        System.out.println(getDateWithSameWeek(DateUtils.now(), Calendar.MONDAY));

        String endTime = DateUtils.format(DateUtils.now(), "MM月dd日HH点");
        if(endTime.startsWith("0")){
            endTime = endTime.substring(1);
        }
        System.out.println(endTime);
    }


}
