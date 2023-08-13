package dlopezgarsco.api.notification;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.NotificationLog;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {
    private final NotificationService service;

    public NotificationResource(NotificationService notificationService) {
        this.service = notificationService;
    }

    @GET
    public List<Notification> fetch() {
        return service.getNotifications();
    }

    @POST
    public Response create(@NotNull @Valid Notification notification) {
        if (service.createNotification(notification))
            return Response.ok().build();
        else
            return Response.serverError().build();
    }

    @GET
    @Path("/log")
    public List<NotificationLog> fetchLogs() {
        return service.getNotificationsLogged();
    }

}
