package Project.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.BookRepository;





@CrossOrigin
@Controller
public class BookRestController {
	
	
	@Autowired
	private BookRepository repository; 

	
  

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest
    (@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return repository.save(book);

    }
}
