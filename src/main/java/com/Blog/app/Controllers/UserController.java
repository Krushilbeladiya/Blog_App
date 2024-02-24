package com.Blog.app.Controllers;

import com.Blog.app.Payloads.UserDTO;
import com.Blog.app.Service.UserService;
import com.Blog.app.Service_imlements.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class UserController {


    @Autowired
    private UserService userService;

    // create User

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUserDto = this.userService.createUser(userDTO);

        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }


    //Update User

    @PostMapping("/{UserId}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable("UserId") Integer UserId) {
        UserDTO updateUser = this.userService.updateUser(userDTO, UserId);
        return ResponseEntity.ok(updateUser);
    }

    //Delete User

    @DeleteMapping("/{UserId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("UserId") Integer UserId) {
        userService.deleteUser(UserId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Delete Successfully", true), HttpStatus.OK);


    }

    //Get User

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{UserId}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer UserId) {
        return ResponseEntity.ok(userService.getUserByid(UserId));

    }
}
