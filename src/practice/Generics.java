package practice;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Generics {

    //	Generic	singleton	factory	pattern





    //	Generic	method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);result.addAll(s2);
        return	result;
    }

    //	Simple	program	to	exercise	generic	method
    public static void main(String[] args)	{
        Set<String>	guys = new HashSet<>();
        Set<String>	stooges = new HashSet<>();
        Set<String>	aflCio = union(guys,stooges);
        System.out.println(aflCio);


        String[]	strings	=	{	"jute",	"hemp",	"nylon"	};
        UnaryOperator<String>	sameString	=	UnaryOperator.identity();
        for	(String	s	:	strings)
            System.out.println(sameString.apply(s));
        Number[]	numbers	=	{	1,	2.0,	3L	};
        UnaryOperator<Number>	sameNumber	=	UnaryOperator.identity();
        for	(Number	n	:	numbers)
            System.out.println(sameNumber.apply(n));
    }
}
