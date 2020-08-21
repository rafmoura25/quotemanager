package com.quotemanager.service;

import com.quotemanager.model.User;
import com.quotemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not founded");

        return user.get();
    }

    public void save(User user){
        userRepository.save(user);
    }
}
