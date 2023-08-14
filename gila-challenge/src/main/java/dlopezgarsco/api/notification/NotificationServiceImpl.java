package dlopezgarsco.api.notification;

import dlopezgarsco.api.channel.ChannelService;
import dlopezgarsco.db.*;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private final NotificationDAO notificationDAO;
    private final UserDAO userDAO;
    private final ChannelService channelService;

    public NotificationServiceImpl(NotificationDAO notificationDAO, UserDAO userDAO, ChannelService channelService) {
        this.notificationDAO = notificationDAO;
        this.userDAO = userDAO;
        this.channelService = channelService;
    }

    @Override
    public List<NotificationLog> fetchLog() {
        return notificationDAO.fetchLog();
    }

    @Override
    public Notification fetch(Integer notificationId) {
        return notificationDAO.fetch(notificationId);
    }

    @Override
    public List<Notification> fetch() {
        return notificationDAO.fetch();
    }

    @Override
    public Integer create(Notification notification) {
        List<User> users = userDAO.getUsersWithCategoriesAndChannelsByCategory(notification.getCategoryId());
        Integer notificationId = notificationDAO.insert(notification);
        //TODO I would do the following segment with observables in order to decouple the POST request from the
        //  channels emissions but I'm running out of time to deliver the challenge.
        users.forEach(u -> u.getChannels().forEach(c -> {
            Boolean success = channelService.emit(u, notification, c.getName());
            NotificationLog log = new NotificationLog();
            log.setNotificationId(notificationId);
            log.setUserId(u.getUserId());
            log.setChannelId(c.getChannelId());
            log.setSuccess(success);
            notificationDAO.insertLog(log);
        }));
        return notificationId;
    }
}
