package dlopezgarsco.api.user;

import dlopezgarsco.api.category.Category;
import dlopezgarsco.api.channel.Channel;
import org.jdbi.v3.core.result.LinkedHashMapRowReducer;
import org.jdbi.v3.core.result.RowView;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowReducer;

import java.util.List;
import java.util.Map;

@RegisterBeanMapper(value = User.class, prefix = "u")
@RegisterBeanMapper(value = Category.class, prefix = "c")
@RegisterBeanMapper(value = Channel.class, prefix = "ch")
public interface UserDAO {

    @SqlQuery("SELECT u.user_id u_user_id, u.name u_name, u.email u_email, u.phone_number u_phone_number, " +
            "c.category_id c_category_id, c.name c_name, " +
            "ch.channel_id ch_channel_id, ch.name ch_name " +
            "FROM users u " +
            "NATURAL JOIN users_categories " +
            "NATURAL JOIN users_channels " +
            "JOIN categories c " +
            "ON users_categories.category_id = c.category_id " +
            "JOIN channels ch " +
            "ON users_channels.channel_id = ch.channel_id")
    @UseRowReducer(UserCategoryChannelReducer.class)
    List<User> getUsersWithCategoriesAndChannels();

    class UserCategoryChannelReducer implements LinkedHashMapRowReducer<Integer, User> {
        @Override
        public void accumulate(Map<Integer, User> map, RowView rv) {
            User u = map.computeIfAbsent(rv.getColumn("u_user_id", Integer.class),
                    id -> rv.getRow(User.class));

            if (rv.getColumn("c_category_id", Integer.class) != null) {
                u.getCategories().add(rv.getRow(Category.class));
            }
            if (rv.getColumn("ch_channel_id", Integer.class) != null) {
                u.getChannels().add(rv.getRow(Channel.class));
            }
        }
    }
}
