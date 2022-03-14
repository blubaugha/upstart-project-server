package com.upstart.controller;

import com.upstart.model.UserModel;
import com.upstart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/users")
@CrossOrigin
@Slf4j
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserModel getById(@PathVariable UUID id) {
        log.info("Getting user by id '{}'", id);
        return userService.getById(id);
    }

    @GetMapping(value = "/", params = "email")
    public UserModel getByEmail(@RequestParam String email) {
        log.info("Getting user by email '{}'", email);
        return userService.getByEmail(email);
    }

    @GetMapping(value = "/")
    public List<UserModel> getAll() {
        log.info("Getting all users");
        return userService.getAll();
    }

    @PostMapping("/")
    public UserModel add(UserModel user) {
        log.info("Adding userModel {}", user);
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserModel update(UserModel user, @PathVariable UUID id) {
        log.info("Updating userModel with id '{}'", id);
        user.setId(id);
        return userService.save(user);
    }
}
