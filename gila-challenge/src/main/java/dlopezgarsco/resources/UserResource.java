package dlopezgarsco.resources;

import dlopezgarsco.core.models.User;
import dlopezgarsco.db.UserDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    public List<User> getAll() {
        return userDAO.selectAll();
    }
}
