package com.Blog.app.Service_imlements;

import com.Blog.app.Entities.Category;
import com.Blog.app.Entities.Post;
import com.Blog.app.Entities.User;
import com.Blog.app.Exceptions.ResourceNotFoundException;
import com.Blog.app.Payloads.PostDTO;
import com.Blog.app.Repositories.CategoryRepo;
import com.Blog.app.Repositories.PostRepo;
import com.Blog.app.Repositories.UserRepo;
import com.Blog.app.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceimpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PostDTO CreatePost(PostDTO postDTO, Integer UserId, Integer CategoryId) {

        User user = userRepo.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", UserId));

        Category category = categoryRepo.findById(CategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", CategoryId));

        Post post = modelMapper.map(postDTO, Post.class);

        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post ewPost = postRepo.save(post);
        return this.modelMapper.map(ewPost, PostDTO.class);
    }

    @Override
    public PostDTO UpdatePost(PostDTO postDTO, Integer PostId) {
        Post post= postRepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",PostId));

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageName(postDTO.getImagename());

    Post updatepost= postRepo.save(post);

    return this.modelMapper.map(updatepost,PostDTO.class);
    }

    @Override
    public void deletePost(Integer PostId) {
        Post post=postRepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",PostId));
         postRepo.delete(post);


    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> allPost=this.postRepo.findAll();
        List<PostDTO> PostDto=allPost.stream().map((post) -> modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());


        return PostDto;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));


        return this.modelMapper.map(post,PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostByCategorry(Integer category) {
        return null;
    }

    @Override
    public PostDTO updatepost(PostDTO postDTO, Integer postId) {
        return null;
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        List<Post> posts = postRepo.findByCategory(category);

        List<PostDTO> postDTOS = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());


        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer UserId) {

        User user = userRepo.findById(UserId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", UserId));

        List<Post> posts = postRepo.findAllByUser(user);

        List<PostDTO> PostDTOS = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());


        return PostDTOS;
    }
    //SerchPost
    public List<PostDTO> SearchPost(String keyword){
        List<Post> posts=postRepo.findByTitleContaining(keyword);
       List<PostDTO>postDTOS= posts.stream().map((post)->modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());

       return postDTOS;
    }



}
