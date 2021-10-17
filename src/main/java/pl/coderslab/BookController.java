package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private MockBookService mockBookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

   @PostMapping("/post")

   public String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type)
   //public String addBook(@RequestBody Book book)
   {
      // Book book1 = new Book(0L,book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getType());
       Book book1 = new Book(0L,isbn,title,author,publisher,type);
       bookService.addBook(book1);
       return "redirect:/books";
   }


    @RequestMapping("/helloBook")
    @ResponseBody
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");

    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {

        if(bookService.getBooks().contains(getBookById(id))){
            bookService.deleteBook(id);
            return "redirect:/books";
        } else {
            return "redirect:/books/noSuchElement";
        }

    }

    @GetMapping("/update")
    public String updateBook() {
        return "updateBook";
    }


    @PostMapping("/put")

    public String updateBook(@RequestParam Long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type)
    {

        if(bookService.getBooks().contains(getBookById(id))){
            int indexOfBook = bookService.getBooks().indexOf(bookService.getBook(id));
            Book bookToUpdate = bookService.getBooks().get(indexOfBook);
            bookToUpdate.setType(type);
            bookToUpdate.setTitle(title);
            bookToUpdate.setIsbn(isbn);
            bookToUpdate.setPublisher(publisher);
            bookToUpdate.setAuthor(author);
            return "redirect:/books";
        } else {
            return "redirect:/books/noSuchElement";
        }
    }

    @GetMapping("/noSuchElement")
    @ResponseBody
    public String noSuchElement() {
        return "Nie ma takiej ksiazki";
    }


}
