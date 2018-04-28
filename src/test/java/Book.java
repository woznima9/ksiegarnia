import lombok.Getter;
import lombok.Setter;

public class Book {

    @Getter
    @Setter
    private String titleBook;

    @Getter
    @Setter
    private int indexBook;

    @Getter
    @Setter
    private int yearPublicationBook;


    public Book(String titleBook, int indexBook, int yearPublicationBook) {
        this.titleBook = titleBook;
        this.indexBook = indexBook;
        this.yearPublicationBook = yearPublicationBook;
    }

    @Override
    public String toString() {
        return  "\"" + titleBook + "\"" +
                ", index: " + indexBook +
                ", year: " + yearPublicationBook;
    }
}
