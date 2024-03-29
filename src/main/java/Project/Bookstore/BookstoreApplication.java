package Project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.BookRepository;
import Project.Bookstore.domain.CategoryRepository;
import Project.Bookstore.domain.User;
import Project.Bookstore.domain.UserRepository;
import Project.Bookstore.domain.Category;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
@Bean
public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRep, UserRepository urepository) {
	return (args) -> {

		Category c1 = new Category("1", "Scifi");
		Category c2 = new Category("2", "Horror");
		Category c3 = new Category("3", "Mystery");

		categoryRep.save(c1);
		categoryRep.save(c2);
		categoryRep.save(c3);

		Book b1 = new Book("Eka kirja", "Eka kirjailija", 2024, "123456", 19.90, c1);
		Book b2 = new Book("Toka kirja", "Toka kirjailija", 2020, "124554", 15.90, c2);
		Book b3 = new Book("Kolmas kirja", "Kolmas kirjailija", 2013, "123236", 10.00, c3);

		repository.save(b1);
		repository.save(b2);
		repository.save(b3);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User user1 = new User("user", passwordEncoder.encode("password"), "USER");
		User user2 = new User("admin", passwordEncoder.encode("adminpassword"), "ADMIN");
		urepository.save(user1);
		urepository.save(user2);

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
