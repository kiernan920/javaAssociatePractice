package practice;

public enum PracticeEnum {

        ONCE (true), TWICE(true), THRICE(false);
        private PracticeEnum(boolean b) {
            System. out .println("constructing");
        }
        public static void main(String[] args) {
// prints constructing
            PracticeEnum firstCall = PracticeEnum. ONCE ;
// doesn't print anything
            PracticeEnum secondCall = PracticeEnum. ONCE ;
        }
}

