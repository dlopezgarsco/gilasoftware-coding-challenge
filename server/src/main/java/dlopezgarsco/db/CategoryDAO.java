package dlopezgarsco.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface CategoryDAO {
    @SqlQuery("SELECT * FROM categories")
    @RegisterBeanMapper(Category.class)
    List<Category> selectAll();
}
