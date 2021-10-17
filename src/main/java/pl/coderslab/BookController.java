package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/books")
public class BookController {

   // private BookService bookService;
    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return mockBookService.getList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id) {
        return mockBookService.getBook(id);
    }

    @GetMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

   @PostMapping("/post")

    public String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {

        Book book = new Book(getLastId(),isbn, title, author, publisher, type);
       mockBookService.addBook(book);
       return "redirect:/books";
   }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");

    }


    public Long getLastId(){

        int listSize = mockBookService.getList().size();
        Long lastID = mockBookService.getList().get(listSize-1).getId();

        return lastID+1;
    }


}
