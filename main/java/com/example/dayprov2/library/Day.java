package com.example.dayprov2.library;

import java.util.Calendar;

/**
 * Created by Guure on 2017/4/27.
 * to tell you what day is a day
 * 1 means Monday, 7 means Sunday
 */

public class Day {

    public static int whatDay(Calendar calendar) {
        //一周第一天是否为星期天
        boolean isFirstSunday = (calendar.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        return weekDay;
    }

}
