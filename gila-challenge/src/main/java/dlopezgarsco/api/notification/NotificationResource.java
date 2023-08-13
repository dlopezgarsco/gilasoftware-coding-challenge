package dlopezgarsco.api.notification;

import dlopezgarsco.api.notification.service.NotificationService;
import dlopezgarsco.api.user.User;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class NotificationResource {
    private final NotificationService service;

    @Inject
    public NotificationResource(NotificationService notificationService) {
        this.service = notificationService;
    }


    @GET
    public List<User> getUsers() {
        return service.createNotification();
    }

    @GET
    @Path("/log")
    public List<NotificationLog> getAll() {
        return service.getNotificationsLogged();
    }

    @POST
    public void create() {

    }
}
