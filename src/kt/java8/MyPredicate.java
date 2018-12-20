package kt.java8;

import javax.xml.transform.sax.SAXSource;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

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

///

class lambdaSyntax {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        Predicate<String> predicate = a -> a.isEmpty();
        al.removeIf(predicate);

        al.removeIf((String a) -> a.isEmpty());

        al.removeIf((a) -> a.isEmpty());

        al.removeIf(a -> {
            return a.isEmpty();
        });

        al.removeIf(a -> {
            System.out.println("TRUE");
            return a.isEmpty();
        });
    }
}

///

@FunctionalInterface
interface Hello{
    String sayHello();
}

class AnonymousMethods{


    public static void main(String[] args) {
        String effectivelyFinal = "Hello";
        doSomething(new Hello() {
            @Override
            public String sayHello() {
                return effectivelyFinal;
            }
        });
        doSomething(() -> "Lambda_Hello");
        //effectivelyFinal = "Not effectivelyFinal";
    }

    static void doSomething(Hello hello){
        System.out.println(hello.sayHello());
    }
}

///BUILT IN FUNCTIONAL INTERFACES
//        Supplier<T> 0 T get
//        Consumer<T> 1 (T) void accept
//        BiConsumer<T, U> 2 (T, U) void accept
//        Predicate<T> 1 (T) boolean test
//        BiPredicate<T, U> 2 (T, U) boolean test
//        Function<T, R> 1 (T) R apply
//        BiFunction<T, U, R> 2 (T, U) R apply
//        UnaryOperator<T> 1 (T) T apply
//        BinaryOperator<T> 2 (T, T) T apply

class lambdaSupportInList {

    public static void main(String[] args) {
        Consumer<String> consumer = singleParameter -> System.out.println(singleParameter);
        List<String> al = new ArrayList<>(Arrays.asList("A", "B", "C"));
        al.forEach(consumer);
        Comparator<String> comparator = (a, b) -> b.compareTo(a);
        al.sort(comparator);
        System.out.println("SORTED");
        al.forEach(consumer);
        System.out.println("REPLACE ALL");
        UnaryOperator<String> unaryOperator = a -> a.toLowerCase();
        al.replaceAll(unaryOperator);
        al.forEach(consumer);
    }
}

class Maps{
    public static void main(String[] args) {
        Map<String, String> mappy = new HashMap<>();
        mappy.put("keyA", "valueA");
        mappy.put("keyB", null);
        mappy.putIfAbsent("keyA", "someOtherValue");
        mappy.putIfAbsent("keyB", "someOtherValue");
        System.out.println(mappy);
    }
}

class Maps2{
    public static void main(String[] args) {
        BiFunction<String, String, String> mapper = (existingValue, possibleNewValue)
        -> existingValue.length() > possibleNewValue.length() + 1 ? existingValue: possibleNewValue + 2;
        Map<String, String> nodeToNeType = new HashMap<>();
        nodeToNeType.put("Node1", "RadioNode");
        nodeToNeType.put("Node2", "ERBS");
        String valueUsedForNode1 = nodeToNeType.merge("Node1", "Radio", mapper);
        String valueUsedForNode2 = nodeToNeType.merge("Node2", "LongERBS", mapper);
        System.out.println(valueUsedForNode1);
        System.out.println(valueUsedForNode2);
        System.out.println(nodeToNeType);
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

///

class Streams{

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Boris", "Elvis", "Dave"));
        Stream<String> stream = list.stream();
        stream.filter(a -> a.startsWith("E")).forEach(System.out::println);
        //stream.forEach(a -> System.out.println("RUNTIME EX STREAM USED UP!"));
        System.out.println();
        list.forEach(System.out::println);
        System.out.println();
        list.stream().sorted((a,b) -> a.compareTo(b)).forEach(a -> System.out.println(a));
        System.out.println();
        list.stream().forEachOrdered(System.out::println);
    }
}

class MoreStreams{

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Boris", "Elvis", "Dave"));
        list.stream().map(a -> a.length())
                     .peek( a ->  System.out.println("peek" + a))
                     .filter(a -> a > 4)
                     .forEach(System.out::println);
    }
}

class OtherWaysToGenerateStreams{
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);
        //Infinite Streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        oddNumbers.filter(a -> a > 10).limit(100).forEach(System.out::println);
    }
}

