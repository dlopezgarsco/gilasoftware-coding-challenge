package dlopezgarsco.api.notification;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDateTime;

public class NotificationLog {
    private final Integer id;
    private final Integer userId;
    private final Integer channelId;
    private final LocalDateTime date;
    private final Boolean success;
    final Integer notificationId;

    private NotificationLog(
            @ColumnName("id") Integer id,
            @ColumnName("notification_id") Integer notificationId,
            @ColumnName("user_id") Integer userId,
            @ColumnName("channel_id") Integer channelId,
            @ColumnName("success") Boolean success,
            @ColumnName("date") LocalDateTime date) {
        this.id = id;
        this.userId = userId;
        this.channelId = channelId;
        this.notificationId = notificationId;
        this.success = success;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public Boolean getSuccess() {
        return success;
    }
}
