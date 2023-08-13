package dlopezgarsco.api.notification.service;

import dlopezgarsco.api.notification.NotificationDAO;
import dlopezgarsco.api.notification.NotificationLog;
import dlopezgarsco.api.user.User;
import dlopezgarsco.api.user.UserDAO;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private final NotificationDAO notificationDAO;
    private final UserDAO userDAO;

    public NotificationServiceImpl(NotificationDAO notificationDAO, UserDAO userDAO) {
        this.notificationDAO = notificationDAO;
        this.userDAO = userDAO;
    }

    @Override
    public List<NotificationLog> getNotificationsLogged() {
        return notificationDAO.selectAll();
    }

    @Override
    public List<User> createNotification() {
        List<User> users = userDAO.getUsersWithCategoriesAndChannels();
        return null;
        // crear notificación general
        // juntar todos los usuarios suscriptos a la categoría
        // pasarle la notif a cada canal, generar log
    }
}
