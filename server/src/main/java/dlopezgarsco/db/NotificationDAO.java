package dlopezgarsco.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface NotificationDAO {
    @SqlQuery("SELECT * FROM notifications")
    @RegisterBeanMapper(Notification.class)
    List<Notification> fetch();

    @SqlQuery("SELECT * FROM notifications WHERE notification_id = ?")
    @RegisterBeanMapper(Notification.class)
    Notification fetch(Integer notificationId);

    @SqlUpdate("INSERT INTO notifications (message, category_id) VALUES (:message, :categoryId)")
    @RegisterBeanMapper(Notification.class)
    @GetGeneratedKeys("notification_id")
    Integer insert(@BindBean Notification notification);

    @SqlQuery("SELECT * FROM notifications_log")
    @RegisterBeanMapper(NotificationLog.class)
    List<NotificationLog> fetchLog();

    @SqlUpdate("INSERT INTO notifications_log (notification_id, user_id, channel_id, timestamp, success) " +
                "VALUES (:notificationId, :userId, :channelId, now(), :success)")
    @RegisterBeanMapper(NotificationLog.class)
    @GetGeneratedKeys("notification_log_id")
    Integer insertLog(@BindBean NotificationLog notificationLog);
}
