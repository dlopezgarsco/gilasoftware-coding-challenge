package dlopezgarsco.api.category;

import dlopezgarsco.db.Category;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class CategoryResource {
    private final CategoryService service;

    @Inject
    public CategoryResource(CategoryService categoryService) {
        this.service = categoryService;
    }

    @GET
    public List<Category> fetch() {
        return service.getAll();
    }
}
