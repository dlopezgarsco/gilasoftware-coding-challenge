package dlopezgarsco.api.notification;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.NotificationLog;

import java.util.List;

public interface NotificationService {

    Notification fetch(Integer notificationId);
    List<Notification> fetch();
    Integer create(Notification notification);
    List<NotificationLog> fetchLog();

}
