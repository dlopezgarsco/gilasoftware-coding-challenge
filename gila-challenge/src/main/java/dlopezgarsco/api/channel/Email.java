package dlopezgarsco.api.channel;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.User;

public class Email implements Channel {
    @Override
    public Boolean emit(User user, Notification notification) {
        return true;
    }
}
