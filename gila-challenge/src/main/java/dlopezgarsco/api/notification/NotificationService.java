package dlopezgarsco.api.notification;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.NotificationLog;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotifications();
    Boolean createNotification(Notification notification);
    List<NotificationLog> getNotificationsLogged();

}
