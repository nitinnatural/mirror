package com.androidyug.mirror.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nicheminds on 6/24/2016.
 */






public class ZodiacFactory {

    public static final int ARIES = 1;
    public static final int TAURUS = 2;
    public static final int GEMINI = 3;
    public static final int CANCER = 4;
    public static final int LEO = 5;
    public static final int VIRGO = 6;
    public static final int LIBRA = 7;
    public static final int SCORPIO = 8;
    public static final int SAGITTARIUS = 9;
    public static final int CAPRICORN = 10;
    public static final int AQUARIUS = 11;
    public static final int PISCES = 12;


    public static int whichZodiac(int day, int month){
//        final Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
        // int year = c.get(Calendar.YEAR);
//        int month=3;
//        int day =25;
        switch(month){
            case 1:
                if(day<=20){
                    return CAPRICORN;
                }
                else{
                    return AQUARIUS;
                }
            case 2:
                if(day<=19){
                    return AQUARIUS;
                }
                else{
                    return PISCES;
                }
            case 3:
                if(day<=20){
                    return PISCES;
                }
                else{
                    return ARIES;
                }
            case 4:
                if(day<=20){
                    return ARIES;
                }
                else{
                    return TAURUS;
                }
            case 5:
                if(day<=21){
                    return TAURUS;
                }
                else{
                    return GEMINI;
                }
            case 6:
                if(day<=21){
                    return GEMINI;
                }
                else{
                    return CANCER;
                }
            case 7:
                if(day<=23){
                    return CANCER;
                }
                else{
                    return LEO;
                }
            case 8:
                if(day<=23){
                    return LEO;
                }
                else{
                    return VIRGO;
                }
            case 9:
                if(day<=23){
                    return VIRGO;
                }
                else{
                    return LIBRA;
                }
            case 10:
                if(day<=23){
                    return LIBRA;
                }
                else{
                    return SCORPIO;
                }
            case 11:
                if(day<=22){
                    return SCORPIO;
                }
                else{
                    return SAGITTARIUS;
                }
            case 12:
                if(day<=22){
                    return SAGITTARIUS;
                }
                else {
                    return CAPRICORN;
                }
        }
        return -1;
    }
}
