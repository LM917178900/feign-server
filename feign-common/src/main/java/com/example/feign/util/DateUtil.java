/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.feign.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author geekidea
 * @date 2018-11-08
 */
public class DateUtil {

    public static final String formatStr_yyyyMMddHHmmssS_ = "yyyyMMddHHmmss";
    public static final String formatStr_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String formatStr_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String formatStr_yyyyMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String formatStr_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static final String formatStr_yyyyMMddHH = "yyyy-MM-dd HH";
    public static final String formatStr_yyyyMMdd = "yyyy-MM-dd";
    public static final String formatStr_yyyy = "yyyy";
    public static final String formatStr_yyyy_MM = "yyyy-MM";
    public static final String formatStr_yyyy_MM_dd = "yyyyMMdd";
    public static final String formatStr_yyyyMMddDelimiter = "-";
    public static final String formatStr_MMddyyyyHHmmss = "MM/dd/yyyy HH:mm:ss";
    public static final String formatStr_MMddyyyy = "MM/dd/yyyy";
    public static final String MMdd = "MM/dd";


    public static String getYYYYMMDDHHMMSS(Date date) {
        return getDateStr(date, formatStr_yyyyMMddHHmmss);
    }

    public static String getDateStr(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }


    /**
     * calender to sql.date
     *
     * @param startCalender cleander
     * @return sql.date
     * @author: leiming5
     */
    public static java.sql.Date toSqlDate(Calendar startCalender) {

        Date date = startCalender.getTime();

        return new java.sql.Date(date.getTime());
    }

    /**
     * util.date to sql.date
     *
     * @param date util.date
     * @return sq.date
     * @author: leiming5
     */
    public static java.sql.Date toSqlDate(Date date) {

        return new java.sql.Date(date.getTime());
    }


    /**
     * Date???????????????????????????String??????
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String dateToString(Date source, String pattern) {
        if (Objects.isNull(source)) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(source);
    }

    /**
     * ???????????????String??????Date????????????
     *
     * @param source
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String source, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(source);
    }

    /**
     * ?????????n????????????
     */
    public static String getBeforeMonthTime(int amonut, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -amonut);
        Date date = calendar.getTime();
        return dateToString(date, pattern);
    }

    /**
     * ?????????n????????????????????????yyyy-MM
     */
    public static String getBeforeMonthTime(int amonut) {
        return getBeforeMonthTime(amonut, formatStr_yyyy_MM);
    }

    /**
     * ???date ???????????? ???
     *
     * @param date ???
     * @param i    ????????????
     * @return ??????????????????
     * @author leiming5
     */
    public static Date offsetWeek(Date date, int i) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, i);

        return calendar.getTime();
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param originDate ?????????
     * @param baiscDate  ??????
     * @return ?????????
     * @author leiming5
     */
    public static Integer getDayDiff(String originDate, String baiscDate) {
        long between_days = 0L;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(originDate));
            long time1 = cal.getTimeInMillis();

            cal.setTime(sdf.parse(baiscDate));
            long time2 = cal.getTimeInMillis();

            between_days = (time2 - time1) / (1000 * 3600 * 24);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getSortFiscalYear(String fiscalYear) {
        String result = fiscalYear;
        if (StringUtils.isNotEmpty(fiscalYear)) {
            result = "FY" + fiscalYear.substring(fiscalYear.length() - 2);
        }
        return result;
    }
}
