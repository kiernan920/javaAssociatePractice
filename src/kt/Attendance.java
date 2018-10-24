package kt;

//    In the following application, the value of list has been omitted. Assuming the code
//    compiles without issue, which one of the following is not a possible output of
//    executing this class?

    public class Attendance {
        private Boolean[] list = new Boolean[0];// value omitted
        public int printTodaysCount() {
            int count=0;
            for(int i=0; i<10; i++) {
                if(list[i]) ++count;
            }
            return count;
        }
        public static void main(String[] roster) {
            new Attendance().printTodaysCount();
        }
    }
//    A. A stack trace for NullPointerException is printed.
//    B. A stack trace for ArrayIndexOutOfBoundsException is printed.
//    C. A stack trace for ClassCastException is printed.
//    D. None of the above













//(Boolean[]) new Object();