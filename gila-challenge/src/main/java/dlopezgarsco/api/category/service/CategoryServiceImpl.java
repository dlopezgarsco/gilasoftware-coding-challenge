package dlopezgarsco.api.category.service;

import dlopezgarsco.api.category.Category;
import dlopezgarsco.api.category.CategoryDAO;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.selectAll();
    }
}
