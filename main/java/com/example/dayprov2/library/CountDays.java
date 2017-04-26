package com.example.dayprov2.library;

import java.util.Calendar;

/**
 * Created by Guure on 2017/4/26.
 * input a specific month(no need to add 1) in a year
 * output its number of days
 */

public class CountDays {
    // 计算每个月的天数
    public static int count(int year, int month) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        // 因为下面两行计算的是上个月的天数，所以这里month加1
        cal.set(Calendar.MONTH, month + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        return cal.get(Calendar.DATE);
    }
}
