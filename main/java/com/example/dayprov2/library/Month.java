package com.example.dayprov2.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guure on 2017/4/25.
 * all months' names and a list contains them
 */

public class Month {

    public static final String JAN = "January";
    public static final String FEB = "February";
    public static final String MAR = "March";
    public static final String APR = "April";
    public static final String MAY = "May";
    public static final String JUN = "June";
    public static final String JUL = "July";
    public static final String AUG = "August";
    public static final String SEP = "September";
    public static final String OCT = "October";
    public static final String NOV = "November";
    public static final String DEC = "December";

    private static List<String> monthList;

    public static final List<String> getMonthList() {
        monthList = new ArrayList<>();
        monthList.add(Month.JAN);
        monthList.add(Month.FEB);
        monthList.add(Month.MAR);
        monthList.add(Month.APR);
        monthList.add(Month.MAY);
        monthList.add(Month.JUN);
        monthList.add(Month.JUL);
        monthList.add(Month.AUG);
        monthList.add(Month.SEP);
        monthList.add(Month.OCT);
        monthList.add(Month.NOV);
        monthList.add(Month.DEC);
        return monthList;
    }

}
