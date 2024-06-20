package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.DAO.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private CategoryDao categoryDao;

    @Autowired
    CategoriesController(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

    @RequestMapping(path="/categories", method=RequestMethod.GET)
    public List<Category> getCategories() {

        List<Category> categories = categoryDao.getAll();

        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id){

        Category category = categoryDao.getById(id);
        return category;
    }

    @RequestMapping(path="/categories",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        Category newCategory = categoryDao.insertCategory(category);

        return newCategory;
    }

    @RequestMapping(path="/categories/{id}",method = RequestMethod.PUT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category){
        categoryDao.updateCategory(id,category);
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id){
        categoryDao.deleteCategory(id);
    }
}
