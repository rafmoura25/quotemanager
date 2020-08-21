package com.quotemanager.controller;

import com.quotemanager.dto.UserDTO;
import com.quotemanager.model.User;
import com.quotemanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserDTO> findAllUsers(){
        List<User> users = userService.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public UserDTO findUser(@PathVariable("id") String id){
        return convertToDto(userService.findById(id));
    }

    private UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }


}
