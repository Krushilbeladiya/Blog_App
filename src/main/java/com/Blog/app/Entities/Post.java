package com.Blog.app.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PostId;

    private String title;

    private String Content;

    private String imageName;

    private Date AddDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

}
