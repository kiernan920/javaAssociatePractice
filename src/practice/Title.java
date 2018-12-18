package practice;

import kt.Attendance;

import java.util.function.Predicate;

import static practice.Title.MR;

public enum Title
{
    MR("Mr. "), MRS("Mrs. "), MS("Ms. ");
    private String title;
    private Title(String s){
        title = s;
    }
    protected String getTitle(){
        return title;
    }

    public String format(String first, String last){
        return title+" "+first+" "+last;
    }
}

class TestClass{
    void someMethod() {
        Attendance attendance = new Attendance();
        Predication p = new Predication();
        Title tile = Title.MR;
        Title title = Title.valueOf("MR");
        System.out.println(title.ordinal());
        System.out.println(MR.format("Rob", "Miller"));
    }

    public static void main(String[] args) {
        new TestClass().someMethod();
    }
}
