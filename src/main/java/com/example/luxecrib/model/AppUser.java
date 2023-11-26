package com.example.luxecrib.model;

import com.example.luxecrib.enums.UserType;
import com.example.luxecrib.helper.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    @Embedded
    private Address address;
    private String photo;
    private UserType userType;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
    private String socials;
}
