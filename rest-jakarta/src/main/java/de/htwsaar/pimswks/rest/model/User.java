package de.htwsaar.pimswks.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long userId;

    @Column(name = "username")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,}$")
    public String username;

    @Column(name = "email")
    @Email
    public String email;
}
