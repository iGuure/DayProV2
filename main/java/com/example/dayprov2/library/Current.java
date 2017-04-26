package com.example.dayprov2.library;

import java.util.Calendar;

/**
 * Created by Guure on 2017/4/25.
 * get current year, month or date quickly
 */

public class Current {

    private static Calendar calendar = Calendar.getInstance();

    public static final int year = calendar.get(Calendar.YEAR);
    public static final int month = calendar.get(Calendar.MONTH);
    public static final int date = calendar.get(Calendar.DATE);

}
