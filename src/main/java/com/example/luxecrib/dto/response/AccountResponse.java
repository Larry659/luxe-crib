package com.example.luxecrib.dto.response;

import com.example.luxecrib.helper.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;

public record AccountResponse(String username, String fullName, Address address, byte[] photo, String userType, String email, String password, String phoneNumber, String socials) {

}
