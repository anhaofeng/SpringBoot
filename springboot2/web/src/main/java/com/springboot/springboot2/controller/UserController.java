package com.springboot.springboot2.controller;

import com.springboot.springboot2.model.User;
import com.springboot.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)) {
            System.out.printf("用户对象: %s 保存成功!\n",user);
        }
        return user;
    }

}
