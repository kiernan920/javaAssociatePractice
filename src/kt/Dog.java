package kt;

//    What is the output of the following program?

public class Dog {

        public String name;

        public void parseName() {
            System.out.print("1");
            try {
                System.out.print("2");
                int x = Integer.parseInt(name);
                System.out.print("3");
            } catch (NumberFormatException e) {
                System.out.print("4");
            }
        }

        public static void main(String[] args) {
            Dog leroy = new Dog();
            leroy.name = "Leroy";
            leroy.parseName();
            System.out.print("5");
        }
}
//    A. 12
//    B. 1234
//    C. 1235
//    D. 124
//    E. 1245
//    F. The code does not compile.
//    G. An uncaught exception is thrown.


































//E