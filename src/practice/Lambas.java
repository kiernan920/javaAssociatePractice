package practice;

import com.sun.xml.internal.bind.util.Which;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Lambas {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3);
        Function<Integer, Integer> func = a->a*a; //1
        long count = ls.stream().map(func).peek(System.out::print).count(); //2
        System.out.println(count);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
        List<Integer> ls1 = Arrays.asList(3,4,6,9,2,5,7);
        System.out.println(ls1.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); //1
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(ls1.stream().max(Integer::max).get()); //2
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(ls1.stream().max(Integer::compare).get()); //3
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(); //4
        Optional<Integer> optionalInteger = null;//ls1.stream().max((a, b)->a>b?a:b);

            Integer i = optionalInteger.get();
            System.out.println(i);

    }
}
