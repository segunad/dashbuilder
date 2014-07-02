/**
 * Copyright (C) 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.dataset.group;

import java.util.HashMap;
import java.util.Map;

import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Type of data intervals
 */
@Portable
public enum DateIntervalType {
    MILLISECOND,
    HUNDRETH,
    TENTH,
    SECOND,
    MINUTE,
    HOUR,
    DAY,
    DAY_OF_WEEK,
    WEEK,
    MONTH,
    QUARTER,
    YEAR,
    DECADE,
    CENTURY,
    MILLENIUM;

    private static final Map<DateIntervalType,Long> DURATION_IN_MILLIS = new HashMap<DateIntervalType, Long>();
    static {
        long milli = 1;
        DURATION_IN_MILLIS.put(MILLISECOND, milli);

        long hundreth = 10;
        DURATION_IN_MILLIS.put(HUNDRETH, hundreth);

        long tenth = 100;
        DURATION_IN_MILLIS.put(TENTH, tenth);

        long second = 1000;
        DURATION_IN_MILLIS.put(SECOND, second);

        long minute = second*60;
        DURATION_IN_MILLIS.put(MINUTE, minute);

        long hour = minute*60;
        DURATION_IN_MILLIS.put(HOUR, hour);

        long day = hour*24;
        DURATION_IN_MILLIS.put(DAY, day);
        DURATION_IN_MILLIS.put(DAY_OF_WEEK, day);

        long week = day*7;
        DURATION_IN_MILLIS.put(WEEK, week);

        long month = day*31;
        DURATION_IN_MILLIS.put(MONTH, month);

        long quarter = month*4;
        DURATION_IN_MILLIS.put(QUARTER, quarter);

        long year = month*12;
        DURATION_IN_MILLIS.put(YEAR, year);

        long decade = year*10;
        DURATION_IN_MILLIS.put(DECADE, decade);

        long century = year*100;
        DURATION_IN_MILLIS.put(CENTURY, century);

        long millenium = year*1000;
        DURATION_IN_MILLIS.put(MILLENIUM, millenium);
    }

    public static DateIntervalType getByName(String interval) {
        if (interval == null || interval.length() == 0) return null;
        return valueOf(interval.toUpperCase());
    }

    public static int compare(DateIntervalType interval1, DateIntervalType interval2) {
        long d1 = getDurationInMillis(interval1);
        long d2 = getDurationInMillis(interval2);
        return Long.valueOf(d1).compareTo(d2);
    }

    public static long getDurationInMillis(DateIntervalType type) {
        if (!DURATION_IN_MILLIS.containsKey(type)) return 0;
        return DURATION_IN_MILLIS.get(type);
    }
}