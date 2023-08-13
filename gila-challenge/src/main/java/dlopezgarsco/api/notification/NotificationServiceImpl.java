package dlopezgarsco.api.notification;

import dlopezgarsco.db.*;

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
        return notificationDAO.fetchLog();
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationDAO.fetch();
    }

    @Override
    public Boolean createNotification(Notification notification) {
        List<User> users = userDAO.getUsersWithCategoriesAndChannelsByCategory(notification.getCategoryId());
        notificationDAO.insert(notification.getMessage(), notification.getCategoryId());
        return true;
        // pasarle la notif a cada canal, generar log
    }
}
