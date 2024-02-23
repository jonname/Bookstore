package Project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.BookRepository;
import Project.Bookstore.domain.CategoryRepository;
import Project.Bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
@Bean
public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRep) {
	return (args) -> {
		Book b1 = new Book("Eka kirja", "Eka kirjailija", 2024, "123456", 19.90);
		Book b2 = new Book("Toka kirja", "Toka kirjailija", 2020, "124554", 15.90);
		Book b3 = new Book("Kolmas kirja", "Kolmas kirjailija", 2013, "123236", 10.00);

		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
				Category c1 = new Category("1", "Scifi");
				Category c2 = new Category("2", "Horror");
				Category c3 = new Category("3", "Mystery");
		
				categoryRep.save(c1);
				categoryRep.save(c2);
				categoryRep.save(c3);

		Log.info("all books");
		for (Book book : repository.findAll()) {
			Log.info(book.toString());
		}

			Log.info("Categories:");
            for (Category category : categoryRep.findAll()) {
                Log.info(category.toString());
		}
	};
};

}
