package Project.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
public String categoryid;
public String name;

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

}