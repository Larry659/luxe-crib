package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.AppUserRequest;

public interface AppUserService {
    ApiResponse<?> addAppUser(AppUserRequest payload);
    ApiResponse<?> updateAppUser(AppUserRequest payload);
    ApiResponse<?> listAppUser();
    ApiResponse<?> deleteAppUser(Long userId);

}
