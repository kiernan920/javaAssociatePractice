package kt.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
public interface MyPredicate {
    boolean test(int number);

    static String sayHello(){
        return "Hello";
    }

    default String sayDefault(){
        return "Default";
    }
}

class UsePredicates{
    public static void main(String[] args) {
        MyPredicate myPredicate = a -> a < 2;
        System.out.println("1" + myPredicate.test(4));
        System.out.println("2" + myPredicate.test(1));
        System.out.println("3" + myPredicate.sayDefault());
        System.out.println("4" + MyPredicate.sayHello());
        useAPIPredicate(a -> a.startsWith("S"));
    }

    static void useAPIPredicate(Predicate<String> predicate){
        System.out.println("5" + predicate.test("String"));
        System.out.println("6" + predicate.test("tring"));
        System.out.println("7" + predicate.negate().test("String"));
        System.out.println("8" + predicate.and(a -> a.endsWith("f")).test("String"));
        System.out.println("9" + predicate.or(a -> a.endsWith("f")).test("String"));
    }
}

@FunctionalInterface
interface Hello{
    String sayHello();
}

class AnonymousMethods{

    public static void main(String[] args) {
        doSomething(new Hello() {
            @Override
            public String sayHello() {
                return "Hello";
            }
        });
        doSomething(() -> "Lambda_Hello");
    }

    static void doSomething(Hello hello){
        System.out.println(hello.sayHello());
    }
}

class MethodReferences{

    public static void main(String[] args) {
//        Static methods
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

//        Instance methods on a particular instance
        String str = "effectivelyFinal";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);
        //str = "notEffectivelyFinalAnymore";

//        Instance methods on an instance to be determined at runtime
        Predicate<String> methodRef = String::isEmpty;
        Predicate<String> lambda = s -> s.isEmpty();

//        Constructors
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();
    }
}