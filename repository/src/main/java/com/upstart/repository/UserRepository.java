package com.upstart.repository;

import com.upstart.model.AppUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUserModel, UUID> {
    AppUserModel getByEmail(String email);
}
