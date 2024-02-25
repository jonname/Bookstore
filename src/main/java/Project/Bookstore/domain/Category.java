package Project.Bookstore.domain;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String categoryid;
private String name;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
private List<Book> books;

public Category() {
    
}

public Category(String categoryid, String name) {
    this.categoryid = categoryid;
    this.name = name;
}
public String getCategoryid() {
    return categoryid;
}
public void setCategoryid(String categoryid) {
    this.categoryid = categoryid;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public List<Book> getBooks() {
    return books;
}
public void setBooks(List<Book> books) {
    this.books = books;
}

@Override
public String toString() {
    return "Category [categoryid=" + categoryid + ", name=" + name + "]";
}
}