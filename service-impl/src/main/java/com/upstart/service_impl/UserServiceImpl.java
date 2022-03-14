package com.upstart.service_impl;

import com.upstart.model.UserModel;
import com.upstart.repository.UserRepository;
import com.upstart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel save(UserModel userModel) {
        log.info("Updating userModel with id '{}'", userModel);
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAll() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public UserModel getById(UUID id) {
        log.info("Getting user by id '{}'", id);
        return userRepository.getById(id);
    }

    @Override
    public UserModel getByEmail(String email) {
        log.info("Finding user by email '{}'", email);
        return userRepository.getByEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        log.warn("WHOA! Deleting user with id '{}'", id);
        userRepository.deleteById(id);
    }
}
