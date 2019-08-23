package com.slb.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tester {

    public static void main(String[] args) {

        final long now = System.currentTimeMillis();

        List<Date> dates;
        Random r = new Random();
        dates = IntStream.range(0, 10).mapToObj(i -> new Date(now - r.nextInt(999900000) - 100000000)).collect(Collectors.toList());

        dates.forEach(System.out::println);
        Date closest = Collections.min(dates, (d1, d2) -> {
            long diff1 = Math.abs(d1.getTime() - now);
            long diff2 = Math.abs(d2.getTime() - now);
            return Long.compare(diff1, diff2);
        });
        System.out.println("closest " +closest);


    }
}
