package org.nick.bookmarks.rest;

import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestPath;
import org.nick.bookmarks.model.Category;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Path("/v1")
public class Categories extends Controller {
    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance categories(List<Category> categories);
    }

    @GET
    public TemplateInstance categories() {
        return Templates.categories(Category.categoryList);
    }

    @POST
    @Path("/categories")
    public void add(@RestForm @NotBlank String name) {
        if (validationFailed()) categories();

        Category.categoryList.add(new Category(100L, name));

        flash("message", "Category added");

        categories();
    }

    @POST
    @Path("/categories")
    public void delete(@RestPath Long id) {
    }
}
