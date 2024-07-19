/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 2:16 AM
 */
package com.ceyentra.sm.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class CustomDateUtil {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //use only if want to compare two dates..ignoring the time
    public int formatAndCompareDates(Date start, Date end) {
        LocalDate startLocalDate = LocalDate.parse(simpleDateFormat.format(start));
        LocalDate endLocalDate = LocalDate.parse(simpleDateFormat.format(end));
        return startLocalDate.compareTo(endLocalDate);
    }

    public long calculateDifferentIneMinutes(Date start, Date end) {
        long timeDifferenceMillis = start.getTime() - end.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(timeDifferenceMillis);
    }
}
