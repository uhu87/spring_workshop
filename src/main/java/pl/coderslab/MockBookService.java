package pl.coderslab;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService{

    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    public Book getBook (Long id){
        for(Book b : list){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }


    public void addBook (Book book){
        //Book book = new Book(id, isbn, title, author, publisher, type);
        list.add(book);

    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public List<Book> getBooks() {
        return this.list;
    }
}
