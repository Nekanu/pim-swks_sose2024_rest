package de.htwsaar.pimswks.restspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long UserId;

    @Length(min = 3, max = 64)
    @Pattern(regexp = "^[a-zA-Z0-9-_.]{3,64}$")
    public String Username;

    @jakarta.validation.constraints.Email
    public String Email;
}
