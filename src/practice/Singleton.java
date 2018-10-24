package practice;

interface John{
    default int methodName(){
        return 1;
    }
}

public class Singleton  implements John{

    public int methodName(){
        return 2;
    }

    public static class Hello{

        public static void main(final String args[]){
           John john = (John) new Singleton();
            System.out.println(john.methodName());
        }
    }

}




