package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.AppUserRequest;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<?> addAppUser(AppUserRequest payload);
    ApiResponse<?> updateAppUser(Integer id,AppUserRequest payload);
    ApiResponse<?> listAppUser();
    ApiResponse<?> deleteAppUser(Long userId);

}
