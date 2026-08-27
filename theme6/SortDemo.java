import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book implements Comparable<Book> {
    String title;
    int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public int compareTo(Book o) {
        return this.year - o.year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}

public class SortDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java", 2022));
        books.add(new Book("Algorithms", 2018));
        books.add(new Book("Clean Code", 2008));

        Collections.sort(books);
        System.out.println("По году: " + books);

        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.title.compareTo(b2.title);
            }
        });
        System.out.println("По названию: " + books);
    }
}