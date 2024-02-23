package Project.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import Project.Bookstore.domain.Category;
import Project.Bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CategoryController {

@Autowired
private CategoryRepository categoryRep;

@RequestMapping(value = "/categorylist", method=RequestMethod.GET)
public String categoryList(Model model) {
    model.addAttribute("categories", categoryRep.findAll());
    return "categorylist";
}

@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
public String addCategory(Model model) {
    model.addAttribute("category", new Category());
    return "addcategory";
}
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCat(Category category){
        categoryRep.save(category);
        return "redirect:/categorylist";
    } 

}
