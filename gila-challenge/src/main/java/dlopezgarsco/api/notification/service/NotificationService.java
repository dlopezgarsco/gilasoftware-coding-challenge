package dlopezgarsco.api.notification.service;

import dlopezgarsco.api.notification.NotificationLog;
import dlopezgarsco.api.user.User;

import java.util.List;

public interface NotificationService {

    List<NotificationLog> getNotificationsLogged();

    List<User> createNotification();
}
