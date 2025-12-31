package org.nick.bookmarks.rest;

import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestPath;
import org.nick.bookmarks.model.Bookmark;
import org.nick.bookmarks.model.Category;

import java.util.List;

@Path("/v1")
public class Bookmarks extends Controller {
    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance bookmarks(List<Bookmark> bookmarks);
    }

    @GET
    public TemplateInstance bookmarks() {
        return Bookmarks.Templates.bookmarks(Bookmark.bookmarkList);
    }

    @POST
    @Path("/bookmarks")
    public void add(@RestForm @NotBlank String title) {
        if (validationFailed()) bookmarks();

        Bookmark.bookmarkList.add(new Bookmark(100L, title, "https://hub.docker.com", false, new Category(2L, "DevOps")));

        flash("message", "Bookmark added");

        bookmarks();
    }

    @POST
    @Path("/bookmarks")
    public void delete(@RestPath Long id) {

    }
}
