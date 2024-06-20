package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Model.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAll();
    public Category getById(int id);
}
