package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Model.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAll();
    public Category getById(int id);
    public Category insertCategory(Category category);
    public void updateCategory(int id, Category category);
    public void deleteCategory(int id);
}
