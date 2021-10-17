package pl.coderslab;

import java.util.List;

public interface BookService {
    List<Book>getBooks();
    Book addBook(Book book);
    Book getBook (Long id);
    void deleteBook (Long id);
    void update (Book book);

}
