package dlopezgarsco.api.user;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    @SqlQuery("SELECT * FROM \"users\"")
    @RegisterConstructorMapper(User.class)
    List<User> selectAll();


}
