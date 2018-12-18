package newpractice;

class Printer<T extends Cloneable> {}

class N implements Cloneable{}

class Test12 {
    public static void main(String[] args) {
        Printer<N> printer = new Printer<>();
        System.out.println(printer);
    }
}