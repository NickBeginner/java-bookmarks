package org.nick.bookmarks.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public Long id;
    public String name;

    public static List<Category> categoryList = new ArrayList<>(
            List.of(
                    new Category(1L, "Book"),
                    new Category(2L, "Movie"),
                    new Category(3L, "TV"),
                    new Category(4L, "Music"),
                    new Category(5L, "Art")
            )
    );

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
