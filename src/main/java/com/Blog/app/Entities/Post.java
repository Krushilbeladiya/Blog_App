package com.Blog.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Post {

    @Id
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
