package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    @RequestMapping(path="/categories", method=RequestMethod.GET)
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(3, "Confections"));
        categories.add(new Category(4, "Dairy Products"));
        categories.add(new Category(5, "Grains/Cereals"));
        categories.add(new Category(6, "Meat/Poultry"));
        categories.add(new Category(7, "Produce"));
        categories.add(new Category(8, "Seafood"));

        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id){
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(3, "Confections"));
        categories.add(new Category(4, "Dairy Products"));
        categories.add(new Category(5, "Grains/Cereals"));
        categories.add(new Category(6, "Meat/Poultry"));
        categories.add(new Category(7, "Produce"));
        categories.add(new Category(8, "Seafood"));

        return categories.get(id-1);
    }
}
