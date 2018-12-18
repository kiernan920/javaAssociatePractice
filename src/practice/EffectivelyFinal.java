package practice;

public class EffectivelyFinal {
    public void isItFinal() {
        final int one = 20;
        int two = one;
        two++;
        final int three;
        if ( one == 4) three = 3;
        else three = 4;
        int four = 4;
        class Inner { }
        four = 5;
        }
}
