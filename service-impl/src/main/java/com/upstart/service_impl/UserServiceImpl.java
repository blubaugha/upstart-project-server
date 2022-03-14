package com.upstart.service_impl;

import com.upstart.model.AppUserModel;
import com.upstart.repository.UserRepository;
import com.upstart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
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
    public AppUserModel save(AppUserModel appUserModel) {
        simulateWaiting(3000);

        if (Strings.isNotEmpty(appUserModel.getEmail())) {
            AppUserModel existingUser = userRepository.getByEmail(appUserModel.getEmail());

            if (existingUser != null) {
                appUserModel.setId(existingUser.getId());
            }
        }

        log.info("Updating appUserModel with id '{}'", appUserModel);
        return userRepository.save(appUserModel);
    }

    @Override
    public List<AppUserModel> getAll() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public AppUserModel getById(UUID id) {
        log.info("Getting user by id '{}'", id);
        return userRepository.getById(id);
    }

    @Override
    public AppUserModel getByEmail(String email) {
        simulateWaiting(3000);
        log.info("Finding user by email '{}'", email);
        return userRepository.getByEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        log.warn("WHOA! Deleting user with id '{}'", id);
        userRepository.deleteById(id);
    }

    private void simulateWaiting(int milliseconds) {
        try {
            // Just to test long requests in the UI
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            log.error("Thread interrupted", e);
        }
    }
}
