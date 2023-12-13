package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.AccountRequest;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<?> addAccount(AccountRequest payload);
    ApiResponse<?> updateAppUser(Integer id, AccountRequest payload);
    ApiResponse<?> listAppUser();
    ApiResponse<?> deleteAppUser(Long userId);

}
