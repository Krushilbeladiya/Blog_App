package com.Blog.app.Controllers;


import com.Blog.app.Config.AppConstants;
import com.Blog.app.Payloads.PostDTO;
import com.Blog.app.Service.PostService;
import com.Blog.app.Service_imlements.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    // Create Post
    @PostMapping("/user/{UserId}/category/{categoryId}/Post")
        public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer UserId, @PathVariable Integer categoryId) {

        PostDTO CreatePost = postService.CreatePost(postDTO, UserId, categoryId);
        return new ResponseEntity<PostDTO>(CreatePost, HttpStatus.CREATED);

    }

    //Get by User
    @GetMapping("/User/{UserId}/Post")
    private ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer UserId) {

        List<PostDTO> postDTOS = postService.getPostByUser(UserId);
        return new ResponseEntity<List<PostDTO>>(postDTOS, HttpStatus.OK);

    }
    //Get by category

    @GetMapping("/category/{CategoryId}/post")
    public ResponseEntity<List<PostDTO>> getPostbycategory(@PathVariable Integer CategoryId) {
        List<PostDTO> postDTOS = postService.getPostByCategory(CategoryId);
        return new ResponseEntity<List<PostDTO>>(postDTOS, HttpStatus.OK);
    }

    //Get all Post
    @GetMapping("/allpost")
    public ResponseEntity<List<PostDTO>> getallpost(
            @RequestParam(value = "pageNumber ", defaultValue = AppConstants.Page_Number,required = false)Integer pageNumber) {
        return ResponseEntity.ok(postService.getAllPost());
    }

    //Get postById
    @GetMapping("/postbyId")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer PostId) {
        return ResponseEntity.ok(postService.getPostById(PostId));

    }

    //Get Post details By Id
//    @GetMapping("/Post/{postId}")
//    public ResponseEntity<PostDTO> get


    //Delete Post

    @DeleteMapping("/Post/{postId}")
    public ApiResponse deletePost(@PathVariable Integer PostId) {
        postService.deletePost(PostId);
        return new ApiResponse("Post is Successsfully deleted !! ", true);

    }
//        @PutMapping("/post/{PostId}")
//        public ResponseEntity<PostDTO> updatePost (@RequestBody PostDTO postDTO, @PathVariable Integer postId, PostDTO updatePost){
//            PostDTO postDTO = postService.updatepost(postDTO, postId);
//            return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
//        }

    // Search
    @GetMapping("/Post/Search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable ("keyword")String keyword){
        List<PostDTO> result =postService.SearchPost(keyword);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}