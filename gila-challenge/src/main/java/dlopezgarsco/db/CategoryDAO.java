package dlopezgarsco.db;

import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface CategoryDAO {

    @SqlQuery("SELECT * FROM \"categories\"")
    @RegisterConstructorMapper(Category.class)
    List<Category> selectAll();

}
