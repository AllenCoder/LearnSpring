package com.rxjava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Allen on 2017/10/16.
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar today = new GregorianCalendar();
//        today.setTimeInMillis(System.currentTimeMillis());
//        today.add(Calendar.DATE, - 6);
//        for (int i = 0; i < 7; i++) {
//            System.out.println("str = " + longToStr(today.getTimeInMillis(),"yyyy-MM-dd"));
//            today.add(Calendar.DATE,+1);
//        }

//        today.setTimeInMillis(1507601394940L);
        today.setTimeInMillis(1485910800 * 1000L);

        int timeDistance = getTimeDistance(today.getTime(), Calendar.getInstance().getTime());
        System.out.println("timeDistance = " + timeDistance);
//        Calendar newDay = new GregorianCalendar();
//        newDay.setTimeInMillis(System.currentTimeMillis());
//        newDay.add(Calendar.DATE, -timeDistance);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <timeDistance+2; i++) {

            System.out.println("longToStr(today.getTime(),\"yyyy-MM-dd\") = " + longToStr(today.getTimeInMillis(), "yyyy-MM-dd"));
            if (builder.length()>0){
                builder.delete(0,builder.length());
            }
            if (today.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                builder.append(longToStr(today.getTimeInMillis(), "yyyy-MM-dd")).append(" ");
                today.add(Calendar.DATE, 1);
            }


            while (today.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                i++;
                builder.append(longToStr(today.getTimeInMillis(), "yyyy-MM-dd")).append(" ");
                today.add(Calendar.DATE, 1);
            }

            System.out.println(builder.toString());
        }

    }

    public static String longToStr(long time, String format) {
        SimpleDateFormat dataFormat = new SimpleDateFormat(
                format);
        Date date = new Date();
        date.setTime(time);
        return dataFormat.format(date);
    }

    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));//先算出两时间的毫秒数之差大于一天的天数

        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
            return betweenDays + 1; //相等说明确实跨天了
        else
            return betweenDays + 0; //不相等说明确实未跨天
    }
}
