package dlopezgarsco.api.category;

import dlopezgarsco.db.Category;
import dlopezgarsco.db.CategoryDAO;

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
