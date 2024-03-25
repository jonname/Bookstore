package Project.Bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import Project.Bookstore.web.BookController;
import Project.Bookstore.web.BookRestController;
import Project.Bookstore.web.CategoryController;


@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	private CategoryController categoryController;
	private BookRestController bookRestControl;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(bookRestControl).isNotNull();
		} 

}
