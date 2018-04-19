package com.github.jettyrun.common.utils.date;

import java.util.Date;


import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by jetty on 18/2/9.
 */
public class DateFormatUtils {


    private DateFormatUtils() {}

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return DateTime.now().toDate();
    }

    /**
     * 格式化日期为string
     *
     * @param date 日期
     * @param pattern 格式 见该类的常量
     * @return
     */
    public static String formatDate2Str(Date date, DatePattern pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern.getName());
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);

    }


    /**
     * 解析String为Date
     *
     * @param dateStr string
     * @param pattern 格式 见该类的常量
     * @return
     */
    public static Date formatStr2Date(String dateStr, DatePattern pattern) {
        org.joda.time.format.DateTimeFormatter format = DateTimeFormat.forPattern(pattern.getName());
        DateTime dateTime = DateTime.parse(dateStr, format);
        return dateTime.toDate();
    }

    /**
     * 获取相差时间
     *
     * @param date1
     * @param date2
     * @return 返回
     */
    public static Long diffDate(Date date1, Date date2,DateType type) {

        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);

        switch (type) {
            case YEAR:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000 * 60 * 60 * 24 * 365);
            case MONTH:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000 * 60 * 60 * 24 * 30);
            case DAY:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000 * 60 * 60 * 24);
            case HOUR:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000 * 60 * 60);
            case MINUTES:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000 * 60);
            case SECOND:
                return (dateTime1.getMillis() - dateTime2.getMillis()) / (1000);
            default:
                throw new RuntimeException(" dateType cannot be null");
        }
    }


    /**
     * 获取系统默认时区
     *
     * @return
     */
    public static String getDefaultTimeZone() {
        return DateTimeZone.getDefault().getID();
    }




    /**
     * 日期添加
     * @param date
     * @param dateType
     * @param number
     * @return
     */
    public static Date plusTime(Date date,DateType dateType,int number){
        DateTime dateTime=new DateTime(date);
        switch (dateType){
            case YEAR:
                return dateTime.plusYears(number).toDate();
            case MONTH:
                return dateTime.plusMonths(number).toDate();
            case DAY:
                return dateTime.plusDays(number).toDate();
            case HOUR:
                return dateTime.plusHours(number).toDate();
            case MINUTES:
                return dateTime.plusMinutes(number).toDate();
            case SECOND:
                return dateTime.plusSeconds(number).toDate();
            default:
                throw new RuntimeException("the param DateType cannot be null");
        }
    }




    public enum DatePattern{

        /** yyyyMMddHHmmssSSS */
        YYYYMMDDHHMMSSSSS("yyyyMMddHHmmssSSS"),
        /** yyyyMMddHHmmssS */
        YYYYMMDDHHMMSSS( "yyyyMMddHHmmssS"),
        /** yyyyMMddHHmmss */
        YYYYMMDDHHMMSS ( "yyyyMMddHHmmss"),
        /** yyyy-MM-dd HH:mm:ss */
        YYYY_MM_DD_HH_MM_SS_EN_FORMAT("yyyy-MM-dd HH:mm:ss"),
        /** yyyy年MM月dd日 HH:mm:ss */
        YYYY_MM_DD_HH_MM_SS_CH_FORMAT("yyyy年MM月dd日 HH:mm:ss"),
        /** yyyy/MM/dd hh:MM:ss */
        TIME_FOR_MAT("yyyy/MM/dd hh:MM:ss"),
        /** yyyy-MM-dd */
        YYYY_MM_DD("yyyy-MM-dd"),
        /** yyyy年MM月dd日 */
        YYYY_MM_DD_CH("yyyy年MM月dd日"),
        /** yyyyMMdd */
        YYYYMMDD("yyyyMMdd"),
        /** yyyy/MM/dd */
        YYYYMMDD_SLASH_FORMAT("yyyy/MM/dd"),
        /** yyyy-MM-dd HH:mm */
        YYYY_MM_DD_HH("yyyy-MM-dd HH:mm"),
        /** HHmmss */
        TIME_FORMATE("HHmmss"),
        ;



        private String name;


        DatePattern(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public enum DateType{
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTES,
        SECOND;

    }



}
