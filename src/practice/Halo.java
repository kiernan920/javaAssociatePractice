package practice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Halo {

    public static void main(String[] main){
        Locale us = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
        LocalDate.of(2014, Calendar.JUNE, 21);
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k))
                .forEach(System.out::println);
        Properties props = new Properties();
        rb.keySet().stream()
                .forEach(k -> props.put(k , rb.getString(k)));
        Map<String,String> strings = new HashMap<>();
        strings.put("J", "K");


    }

    private static Integer max(IntStream ints) {
        OptionalInt optional = ints.max();
        return optional.orElseThrow( () -> new RuntimeException());
    }

}
