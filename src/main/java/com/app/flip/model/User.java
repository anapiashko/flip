package com.app.flip.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role")
    private Role role;
}
