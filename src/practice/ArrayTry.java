package practice;


    class BubbleException extends Exception {}
    class Fish {
        Fish getFish() throws BubbleException {



            throw new RuntimeException("fish!");
        }
    }
    final class Clownfish extends Fish {
        public final Clownfish getFish() {
            throw new RuntimeException("clown!");
        }
        public static void main(String[] bubbles) {
            final Fish f = new Clownfish();
            System.out.println("swim!");
        }
    }

class Shoelaces {
    public static void main(String[] args) {
        String tie = null;
    }
}


class Highway {
//    public int drive(long car) { return 2; }
    public int drive(float car) { return 3; }

    public static void main(String[] gears) {
        long value = 50l;
        System.out.print(new Highway().drive(value));
    }
}

