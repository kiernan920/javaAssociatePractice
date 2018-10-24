package practice;

public abstract class Bird {

    private void fly() { System.out.println("practice.Bird is flying"); }

    public static void main(String[] args) {
        Bird bird = new Pelican();
        bird.fly();
    }
}
class Pelican extends Bird {

    protected void fly() { System.out.println("practice.Pelican is flying"); }
}