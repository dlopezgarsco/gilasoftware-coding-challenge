package dlopezgarsco.api.channel;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.User;

public interface ChannelService {
    Boolean emit(User user, Notification notification, String channelName);
}
