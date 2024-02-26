package com.Blog.app.Service;

import com.Blog.app.Payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    //Crate

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    //Update
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer CategoryId);

    //delete
    void delete(Integer CategoryId);

    //get
    CategoryDTO getCategory(Integer categoryId);

    //get All
List<CategoryDTO> getAllCategory();


}
