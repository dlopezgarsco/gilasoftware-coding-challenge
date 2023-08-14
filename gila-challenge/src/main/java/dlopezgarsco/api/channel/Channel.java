package dlopezgarsco.api.channel;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.User;

public interface Channel {
    Boolean emit(User user, Notification notification);
}
