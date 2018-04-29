package pl.mwmwz;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static pl.mwmwz.KsiegarniaApp.createBooksFromFile;


public class BooksFunctionsTest {
    private BooksFunctions booksFunctions = new BooksFunctions();

    private List<Book> books = new ArrayList<>();

//    @Before
//    public void init() {
//        books.add(new Book("Clean Code", "0132350882", 2008));
//        books.add(new Book("Effective Java", "0134685997", 2018));
//        books.add(new Book("Test Driven Development", "0321146530", 2003));
//        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
//        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
//    }
@Before
public void init(){
    books = createBooksFromFile();
}


    @Test
    public void znajdzKsiazkeOpodanymIsbnTest() {
        Book book = booksFunctions.podajIsbn(books, "0132350882");
        assertEquals("0132350882", book.getIndexBook());
    }

    @Test
    public void posortujKsiazkiOdNajmlodszejTest() {
        List <Book> sortedBooks = booksFunctions.posortujRosnacoIsbn(books);
        //System.out.println(sortedBooks);
        assertEquals("0321127420", sortedBooks.get(0).getIndexBook());
        assertEquals("0134685997", sortedBooks.get(4).getIndexBook());
    }

    @Test
    public void zwracajDwieOstatnieKsiazkiTest() {
        List<Book> dwieOstatnie=booksFunctions.zwracajDwieOstatnieKsiazki(books);
        assertEquals("0321127420",dwieOstatnie.get(0).getIndexBook() );
        assertEquals("0596007124",dwieOstatnie.get(1).getIndexBook() );
    }
    @Test
    public void posortujKsiazkiOdNajstarszejTest() {
        List <Book> sortedBooks = booksFunctions.posortujMalejacoIsbn(books);
        //System.out.println(sortedBooks);
        assertEquals("0134685997", sortedBooks.get(0).getIndexBook());
        assertEquals("0321127420", sortedBooks.get(4).getIndexBook());
    }


    @Test
    public void najwczesniejWydana() {
        Book najwczesniejsza= booksFunctions.najwczesniejWydana(books);
        assertEquals(2002, najwczesniejsza.getYearPublicationBook());

    }


    @Test
    public void sumujLataWydania() {
        int sumaWydania;
        sumaWydania=booksFunctions.sumujLataWydania(books);
        assertEquals(10035, sumaWydania);


//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.stream().filter(integer -> integer > 3).mapToInt(value -> value).sum();
    }

}
