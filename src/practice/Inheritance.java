package practice;

public class Inheritance {

    protected String get() {
        return "Paremt";
    }

    private String getNumberOfHumps() {
        return "Undefined";
    }
}

class Child extends Inheritance {

    public String get() {
        return "practice.Child";
    }

    private String getNumberOfHumps() {
        return "Undefined";
    }
}

class Main{
    public static void main(String args[]){
        Inheritance inheritance = new Child();
        System.out.println(inheritance.get());
    }
}