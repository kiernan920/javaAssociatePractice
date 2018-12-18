package kt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;
import java.util.concurrent.*;
import java.util.stream.*;
public class ExecutorServiceExample2 {


        public static void main(String[] args) {
            ExecutorService service = Executors.newScheduledThreadPool(10);
            DoubleStream.of(3.14159,2.71828) // b1
                    .forEach(c -> service.submit( // b2
                            () -> System.out.println(10*c))); // b3
            service.execute(() -> System.out.println("Printed")); // b4
        }
}
//    A.	 It compiles and outputs the two numbers, followed by Printed.
//    B.	 The code will not compile because of line b1.
//    C.	 The code will not compile because of line b2.
//    D.	 The code will not compile because of line b3.
//    E.	 The code will not compile because of line b4.
//    F.	 It compiles but the output cannot be determined ahead of time.
//    G.	 It compiles but throws an exception at runtime.
//    H.	 It compiles but waits forever at runtime.

