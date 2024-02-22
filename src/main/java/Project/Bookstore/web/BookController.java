package Project.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.BookRepository;


@Controller
public class BookController {

	@Autowired
private BookRepository bookRep;

		@RequestMapping("/booklist")
	public String bookList(Model model) {
	model.addAttribute("books", bookRep.findAll()); 
		return "booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRep.deleteById(bookId);
		return "redirect:/booklist";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		bookRep.findAll();
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRep.save(book);
        return "redirect:/booklist";
    } 
	
}