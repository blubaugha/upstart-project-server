package com.upstart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
// "user" is a key word in Postgres
@Table(name = "app_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_key", columnNames = {"email"})
        },
        indexes = {
                @Index(name = "email", columnList = "email")
        }
)
@Data
public class AppUserModel extends AbstractBaseModel {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;
}
