package com.upstart.controller;

import com.upstart.model.AppUserModel;
import com.upstart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/users")
@Slf4j
public class UserRestController {
    /*

    NO DELETE EXPOSED HERE!

     */

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public AppUserModel getById(@PathVariable UUID id) {
        log.info("Getting user by id '{}'", id);
        return userService.getById(id);
    }

    @GetMapping(value = "/", params = "email")
    public AppUserModel getByEmail(@RequestParam String email) {
        log.info("Getting user by email '{}'", email);
        return userService.getByEmail(email);
    }

    @GetMapping(value = "/")
    public List<AppUserModel> getAll() {
        log.info("Getting all users");
        return userService.getAll();
    }

    @PostMapping("/")
    public AppUserModel save(@RequestBody AppUserModel user) {
        log.info("Adding userModel {}", user);
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public AppUserModel update(@RequestBody AppUserModel user, @PathVariable UUID id) {
        log.info("Updating userModel with id '{}'", id);
        user.setId(id);
        return userService.save(user);
    }
}
