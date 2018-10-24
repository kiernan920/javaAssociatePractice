package practice;

public class Operator {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(++count);
        System.out.println(factorial(3));
    }

    public static int factorial(int n){
        if(n<=1) return 1;
        else return n * factorial(n-1);
    }
}