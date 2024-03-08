package com.Blog.app.Repositories;

import com.Blog.app.Entities.Category;
import com.Blog.app.Entities.Post;
import com.Blog.app.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {



    List<Post> findAllByUser(User user);
    List<Post>  findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
