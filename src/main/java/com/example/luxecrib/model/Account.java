package com.example.luxecrib.model;

import com.example.luxecrib.enums.UserType;
import com.example.luxecrib.helper.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String fullName;
    @Embedded
    private Address address;
    private byte[] photo;
    private String userType;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
    private String socials;
}
