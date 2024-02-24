package com.Blog.app.Service_imlements;

import com.Blog.app.Entities.User;
import com.Blog.app.Exceptions.ResourceNotFoundException;
import com.Blog.app.Payloads.UserDTO;
import com.Blog.app.Repositories.UserRepo;
import com.Blog.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = dtoToUser(userDTO);

        User savedUser = userRepo.save(user);
        System.out.println(savedUser);
        return UserToDto(savedUser);
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updateUser = this.userRepo.save(user);

        UserDTO userDTO1 = this.UserToDto(updateUser);
        return userDTO1;

    }

    @Override
    public UserDTO getUserByid(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.UserToDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {

        List<User> users = this.userRepo.findAll();

        List<UserDTO> userDTOS = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        return user;
    }

    private UserDTO UserToDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userDTO.getId());
        userDTO.setName(userDTO.getName());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setAbout(userDTO.getAbout());
        userDTO.setPassword(userDTO.getPassword());
        return userDTO;
    }
}
