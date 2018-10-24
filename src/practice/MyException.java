package practice;

import java.sql.SQLException;

public class MyException extends Exception{

        public MyException() {
            super();
        }
        public MyException(Exception e) {
            super(e);
        }
        public MyException(String message) {
            super(message);
        }

    public static void main(String[] args) throws Exception {
        //throw new MyException(new SQLException());

        try {
            throw new MyException("PUNK");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
