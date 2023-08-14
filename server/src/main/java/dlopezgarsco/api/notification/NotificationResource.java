package dlopezgarsco.api.notification;

import dlopezgarsco.db.Notification;
import dlopezgarsco.db.NotificationLog;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.util.List;


@Path("/api/notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {
    private final NotificationService service;

    public NotificationResource(NotificationService notificationService) {
        this.service = notificationService;
    }

    @GET
    public List<Notification> fetch() {
        return service.fetch();
    }

    @GET
    @Path("/{id}")
    public Notification fetch(@PathParam("id") Integer notificationId) {
        return service.fetch(notificationId);
    }

    @POST
    public Response create(@NotNull @Valid Notification notification) {
        Integer notificationId = service.create(notification);
        return Response
                .created(UriBuilder.fromResource(NotificationResource.class).build(notificationId))
                .build();
    }

    @GET
    @Path("/log")
    public List<NotificationLog> fetchLogs() {
        return service.fetchLog();
    }

}
