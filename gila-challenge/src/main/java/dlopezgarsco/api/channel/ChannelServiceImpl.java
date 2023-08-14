package dlopezgarsco.api.channel;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.User;

import java.util.HashMap;
import java.util.Map;

public class ChannelServiceImpl implements ChannelService {

    //TODO This could well be in a Factory or Enum.
    static String[] CHANNEL_NAMES = {"SMS", "E-mail", "Push Notification"};
    private final Map<String, Channel> channels = new HashMap<>() {{
        put(CHANNEL_NAMES[0], new SMS());
        put(CHANNEL_NAMES[1], new Email());
        put(CHANNEL_NAMES[2], new PushNotification());
    }};

    @Override
    public Boolean emit(User user, Notification notification, String channelName) {
        return channels.get(channelName).emit(user, notification);
    }
}
