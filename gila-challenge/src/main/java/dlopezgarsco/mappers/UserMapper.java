package dlopezgarsco.mappers;

import dlopezgarsco.core.models.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone_number"));
    }
}
