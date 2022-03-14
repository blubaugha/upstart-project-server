package com.upstart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
// "user" is a key word in Postgres
@Table(name = "app_user", indexes = {
        @Index(name = "email", columnList = "email")
})
@Data
public class AppUserModel extends AbstractBaseModel {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;
}
