package com.bjpowernode.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest03 {
    public static void main(String[] args) {

        // 这个时间是什么时间？
        // 1970-01-01 00:00:00 001
        Date time = new Date(1); // 注意：参数是一个毫秒

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(time);
        // 北京是东8区。差8个小时。
        System.out.println(strTime); // 1970-01-01 08:00:00 001

        // 获取昨天的此时的时间。
        Date time2 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        String strTime2 = sdf.format(time2);
        System.out.println(strTime2); //2020-03-04 11:44:14 829

        // 获取“去年的今天”的时间
        // 自己玩。
    }
}
