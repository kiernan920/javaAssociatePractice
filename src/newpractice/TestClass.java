package newpractice;
import java.util.concurrent.*;

class Caller implements Callable<Void> {
    String str;

    public Caller(String s) {
        this.str = s;
    }

    public Void call() throws Exception {
        System.out.println(str.toUpperCase());
        return null;
    }
}
