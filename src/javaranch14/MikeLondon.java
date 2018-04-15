/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class MikeLondon {
        
    public static void main(String... args) {
        LocalDate start = LocalDate.of(2018, Month.APRIL, 15);
        LocalDate end = LocalDate.of(2018, Month.JUNE, 4);
        new MikeLondon().go(start, end);
    }
    
    private void go(LocalDate startdate, LocalDate enddate) {
        List<LocalDate> days = new ArrayList<>();
        for (LocalDate d = startdate; !d.isAfter(enddate); d = d.plusDays(1)) days.add(d);
        
        EnumSet<DayOfWeek> daysOfInterest = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY);
        
        List<LocalDate> sundays = days.stream()
            .filter(d -> d.getDayOfWeek() == DayOfWeek.SUNDAY)
            .collect(toList())
        ;
        LocalDate firstSunday = sundays.get(0);
        if (!firstSunday.isEqual(startdate)) sundays.add(0, firstSunday.minusDays(7));
        
        TreeMap<LocalDate, Integer> weekNumbers = new TreeMap<>();
        IntStream.range(0, sundays.size()).forEach(i -> weekNumbers.put(sundays.get(i), i));
        
        Predicate<LocalDate> isCorrectWeekday = d -> daysOfInterest.contains(d.getDayOfWeek());
        Predicate<LocalDate> isCorrectWeek = d -> weekNumbers.floorEntry(d).getValue() % 2 == 0;
        
        List<LocalDate> result = days.stream().filter(isCorrectWeekday.and(isCorrectWeek)).collect(toList());
        System.out.println(result);
    }
}
