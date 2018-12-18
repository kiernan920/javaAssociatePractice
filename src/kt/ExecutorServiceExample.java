package kt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    static  int count;

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            execute();
            count++;
            System.out.println("count: " + count);
        }
    }

    public static void execute(){
        Object o1 = new Object();
        Object o2 = new Object();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<?> f1 = service.submit(() -> {
            synchronized (o1) {
                synchronized (o2) { System.out.println("Tortoise"); } // t1
            }
        });
        Future<?> f2 = service.submit(() -> {
            synchronized (o2) {
                synchronized (o1) { System.out.println("Hare"); } // t2
            }
        });
        try {
            f1.get();
            f2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}
