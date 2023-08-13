package dlopezgarsco.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface NotificationDAO {
    @SqlQuery("SELECT * FROM notifications")
    @RegisterBeanMapper(Notification.class)
    List<Notification> fetch();

    @SqlUpdate("INSERT INTO notifications (message, category_id) VALUES (?, ?)")
    @RegisterBeanMapper(Notification.class)
    Boolean insert(String message, Integer categoryId);

    @SqlQuery("SELECT * FROM notifications_log")
    @RegisterBeanMapper(NotificationLog.class)
    List<NotificationLog> fetchLog();
}
