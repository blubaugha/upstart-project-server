package com.upstart.service;


import com.upstart.model.AppUserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    AppUserModel save(AppUserModel appUserModel);

    List<AppUserModel> getAll();

    AppUserModel getById(UUID id);

    AppUserModel getByEmail(String email);

    void deleteById(UUID id);
}
