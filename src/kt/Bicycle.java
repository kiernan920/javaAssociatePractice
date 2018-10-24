package kt;

import java.math.BigInteger;

class Bicycle {
    String color = "red";
    private void printColor(String color) {
        color = "purple";
        System.out.print(color);
        Bicycle b = new Bicycle();
        BigInteger bc = BigInteger.valueOf(1);
    }
    public static void main(String[] rider) {
        new Bicycle().printColor("blue");
    }
}
/*
        A. red
        B. purple
        C. blue
        D. It does not compile.
*/
