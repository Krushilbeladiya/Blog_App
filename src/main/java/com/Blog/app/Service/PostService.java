package com.Blog.app.Service;

import com.Blog.app.Entities.Post;
import com.Blog.app.Payloads.PostDTO;

import java.util.List;

public interface PostService {

//Create

    PostDTO CreatePost(PostDTO postDTO,Integer UserId,Integer CategoryId);


    //Update
    PostDTO UpdatePost(PostDTO postDTO,Integer PostId);

    //Delete
    void deletePost(Integer PostId);


    //AllGet
    List<PostDTO> getAllPost();

    //Get Single Post



    //Get  all Post by Category
    List<PostDTO> getPostByCategory(Integer categoryId);

    // Get all Post by User

    List<PostDTO> getPostByUser(Integer UserId);


    //get PostById

    PostDTO getPostById(Integer postId);


    List<PostDTO> getPostByCategorry(Integer category);

    PostDTO updatepost(PostDTO postDTO, Integer postId);

    List<PostDTO> SearchPost(String keyword);
}
