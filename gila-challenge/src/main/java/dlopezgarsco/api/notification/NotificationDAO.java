package dlopezgarsco.api.notification;

import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface NotificationDAO {
    @SqlQuery("SELECT * FROM \"notifications\"")
    @RegisterConstructorMapper(Notification.class)
    List<NotificationLog> selectAll();

}
