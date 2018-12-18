package practice;

import java.io.Serializable;

public class Serialablity implements Serializable {


}

class Serial extends Serialablity{

    public static void main(String[] args) {

        if(new Serial() instanceof Serializable){
            System.out.println("F");
        }
    }
}