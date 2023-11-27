package com.example.luxecrib.dto;

import com.example.luxecrib.enums.UserType;
import com.example.luxecrib.helper.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserRequest {
    private String fullName;
    private String username;
    private Address address;
    private String photo;
    private String userType;
    private String email;
    private String password;
    private String phoneNumber;
    private String socials;
}
