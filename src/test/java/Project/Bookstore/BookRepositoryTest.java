package Project.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Project.Bookstore.domain.Book;
import Project.Bookstore.domain.Category;
import Project.Bookstore.domain.CategoryRepository;
import Project.Bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {
@Autowired
private BookRepository repository;

@Autowired
private CategoryRepository cRepository;

@Test
public void findByTitleShouldReturnBook() {
    List<Book> books =  repository.findByTitle("Eka kirja");
    assertThat(books).hasSize(1);
    assertThat(books.get(0).getAuthor()).isEqualTo("Eka kirjailija");
}

@Test
public void createNewBook() {
    List<Category> categories = cRepository.findByName("Horror");
    Book book = new Book("Hyvä kirja", "Hyvä kirjailija", 2024, 1234, 100, cRepository.findByName("Horror").get(0));
    repository.save(book);
assertThat(book.getId()).isNotNull();
}

@Test
public void deleteBook() {
    Book book = repository.findById(Long.valueOf(1)).get();
    repository.delete(book);
    Optional<Book> deleteBook = repository.findById(Long.valueOf(0));
    assertThat(deleteBook).isEmpty();

}

}
