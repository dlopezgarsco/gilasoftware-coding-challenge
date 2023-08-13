package dlopezgarsco.api.notification;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Notification {
    private Integer notificationId;
    private String message;
    private Integer categoryId;

    public Integer getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
