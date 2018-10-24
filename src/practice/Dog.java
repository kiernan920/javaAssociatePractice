package practice;

interface Friend {
     String getName(); // h1
}
class Cat implements Friend {
    public String getName() { // h2
        return "Kitty";
    }
}
public class Dog implements Friend {
    public String getName() throws RuntimeException { // h3
        return "Doggy";
    }
    static final public void main(String[] adoption) {
        Friend friend = new Dog(); // h4
        System.out.print(((Dog)null).getName()); // h6
    }
    private static class Jello{

    }
}