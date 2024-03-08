package com.Blog.app.Payloads;

import com.Blog.app.Entities.Category;
import com.Blog.app.Entities.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class PostDTO {

@Id
    private Integer PostId;
    private String title;

    private String Content;
    private String Imagename;

    private Date addedDate;


    private CategoryDTO category;

    private UserDTO user;


}
