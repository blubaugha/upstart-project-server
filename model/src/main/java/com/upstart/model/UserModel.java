package com.upstart.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Entity
// Use double-quotes since "user" is a key word in Postgres
@Table(name = "\"user\"", indexes = {
        @Index(name = "email", columnList = "email")
})
@Data
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    String email;
}
