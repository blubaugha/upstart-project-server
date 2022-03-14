package com.upstart.service;


import com.upstart.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserModel save(UserModel userModel);

    List<UserModel> getAll();

    UserModel getById(UUID id);

    UserModel getByEmail(String email);

    void deleteById(UUID id);
}
