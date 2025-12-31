package org.nick.bookmarks.model;

import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    public Long id;
    public String title;
    public String url;
    public boolean completed;
    public Category category;

    public static List<Bookmark> bookmarkList = new ArrayList<>(
            List.of(
                    new Bookmark(1L, "Quarkus Framework", "https://quarkus.io", true, new Category(1L, "Java")),
                    new Bookmark(2L, "Docker Hub Official", "https://hub.docker.com", false, new Category(2L, "DevOps")),
                    new Bookmark(3L, "Hacker News", "https://news.ycombinator.com", true, new Category(3L, "News")),
                    new Bookmark(4L, "Nginx Proxy Manager", "http://npm.lan", true, new Category(4L, "Homelab")),
                    new Bookmark(5L, "Baeldung Spring vs Quarkus", "https://www.baeldung.com", false, new Category(1L, "Java")),
                    new Bookmark(6L, "JSON Formatter", "https://jsonformatter.curiousconcept.com", false, new Category(5L, "Utility")),
                    new Bookmark(7L, "Kubernetes Guide for Raspberry Pi", "https://k8s.io", false, new Category(2L, "DevOps"))
            )
    );

    public Bookmark(Long id, String title, String url, boolean completed, Category category) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.completed = completed;
        this.category = category;
    }
}
