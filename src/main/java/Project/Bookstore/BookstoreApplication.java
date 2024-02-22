package Project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
@Bean
public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book b1 = new Book("Eka kirja", "Eka kirjailija", 2024, "123456", 19.90);
		Book b2 = new Book("Toka kirja", "Toka kirjailija", 2020, "124554", 15.90);
		Book b3 = new Book("Kolmas kirja", "Kolmas kirjailija", 2013, "123236", 10.00);

		repository.save(b1);
		repository.save(b2);
		repository.save(b3);

		Log.info("all books");
		for (Book book : repository.findAll()) {
			Log.info(book.toString());
		}
	};
	}
}
