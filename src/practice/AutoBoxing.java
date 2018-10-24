package practice;

public class AutoBoxing {

    private AutoBoxing(String hello){

    }

    public AutoBoxing(){

    }

    public AutoBoxing(int hekko){
        this();
    }

    public static long square(int x) {
        long y = x * (byte) x;
        x = -1;
        return y;
    }

    public static void main(String[] args) {
        int value = 9;
        long result = square(value);
        System.out.println(value);
        new AutoBoxing("String");
    }
}
