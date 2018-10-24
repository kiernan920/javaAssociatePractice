package kt;

//What is the output of the following application?

public class Coat {
    public Long zipper() throws Exception {
        try {
            String checkZipper = (String)new Object();
        } catch (Exception e) {
            //throw RuntimeException("Broken!");
        }
        return null;
    }
    public static void main(String... warmth) {
        try {
            new Coat().zipper();
            System.out.print("Finished!");
        } catch (Throwable t) {}
        Integer numPounds = 1_5000;
    }
}

//        A. Finished!
//        B. Finished! , followed by a stack trace
//        C. The application does not produce any output at runtime.
//        D. The code does not compile.