package com.Blog.app.Payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDTO {



    private Integer CategoryId;
    @NotBlank
    @Size(min = 4,message = " Tile minimum size 4 ")
    private String categoryTitle;


    String Descriptions;


}
