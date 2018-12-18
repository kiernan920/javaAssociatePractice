package practice;

import com.sun.xml.internal.bind.util.Which;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predication {
}

class Book implements Predicate<Book> {
    private int id;
    private String title;
    private String genre;
    private String author;

    public Book(String title, String genre, String author){
        this.title = title; this.genre = genre; this.author = author;
    }

    Book(){
    }

    //accessors for instance fields not shown here


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean test(Book book) {
        return book.getGenre().equals("fiction");
    }

    public boolean isFiction(Book b){
        return b.getGenre().equals("fiction");
    }

    public static class BookFilter {
        public boolean isFiction(Book b){
            return b.getGenre().equals("fiction");
        }

        public static void main(String[] args) {
            List<Book> books = Arrays.asList(new Book("30 Days", "fiction", "K Larsen"),
                    new Book("Fast Food Nation", "non-fiction", "Eric Schlosser"),
                    new Book("Wired", "fiction", "D Richards"));
            books.stream()
                    .filter(new Book()) //LINE 10
                    .forEach((Book b) -> System.out.print(b.getTitle()+", "));
        }


    }
}

class Names{
    private List<String> list;
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public static void printNames(String nmaes){
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Bob Hope",
                "Bob Dole",
                "Bob Brown"
        );

        Names n = new Names();
        n.setList(list.stream().collect(Collectors.toList()));
        n.getList().forEach(Names::printNames);
    }

}


interface T1{
    int VALUE = 1;
    void m1();
}
interface T2{
    int VALUE = 2;
    void m1();
}



class MyThread extends Thread
{
    final int i = 0;
    public void run()
    {
        while(true)
        {
            if( 0/2 == 0 ) System.out.println("Hello World");
            int ii = 1/0;
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}


class Some{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Hello1",1);
        map.put("Hello2", null);
        int i = map.computeIfAbsent("Hello1", a -> a.hashCode() + 2);
        System.out.println(i);
        System.out.println(i);
        System.out.println(map);
    }




    interface I1
    {
        void m1() throws java.io.IOException;
    }
    interface I2
    {
        void m1() throws java.io.FileNotFoundException;
    }

    class G implements I1, I2{


        @Override
        public void m1(){
            if(true){

            }else
                m1();
        }
    }

}
class C {

    protected class K {
    }
}

class MyRunnable implements Runnable
{
    String name;

    MyRunnable(String name)
    {

        new Thread(this, name).start();
        this.name = name + 1234567;

    }
    public void run()
    {
        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
    }
}
class TestClass1
{
    public static void main(String[] args)
    {
        Thread.currentThread().setName("MainThread");
        MyRunnable mr = new MyRunnable("MyRunnable");
        mr.run();
    }
}
