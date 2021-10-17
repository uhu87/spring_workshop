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

    @Override
    public Book getBook (Long id){
        for(Book b : list){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        for(Book b : list){
            if (b.getId().equals(id)){
                list.remove(b);
            }
        }
    }

    @Override
    public void update(Book book) {

        list.indexOf(book);
    }

    @Override
    public Book addBook (Book book){
        book.setId(getLastId());
        list.add(book);
        return book;
    }

 /*   public List<Book> getList() {
        return list;
    }*/

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public List<Book> getBooks() {
        return this.list;
    }


    public Long getLastId(){

        int listSize = list.size();
        Long lastID = list.get(listSize-1).getId();

        return lastID+1;
    }
}
