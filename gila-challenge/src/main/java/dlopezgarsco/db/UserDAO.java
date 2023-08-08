package dlopezgarsco.db;

import dlopezgarsco.core.models.User;
import dlopezgarsco.mappers.UserMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface UserDAO {
    @SqlQuery("SELECT * FROM \"users\"")
    @RegisterRowMapper(UserMapper.class)
    List<User> selectAll();
}
