package Project.Bookstore;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Project.Bookstore.domain.Category;
import Project.Bookstore.domain.CategoryRepository;


@DataJpaTest
public class CategoryRepositoryTest {
@Autowired
private CategoryRepository repository;

@Test
public void findByNameShouldReturnCategory() {
    List<Category> category =  repository.findByCategory("Horror");
}

}
