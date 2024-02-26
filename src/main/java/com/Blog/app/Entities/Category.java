package com.Blog.app.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "Title", length = 100, nullable = false)
    private String categoryTitle;

    @Column(name = "Description")
    private String categoryDescription;

}
