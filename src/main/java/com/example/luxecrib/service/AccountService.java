package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.AccountRequest;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<?> addAccount(AccountRequest payload);
    ApiResponse<AccountRequest> updateAppUser(Integer id, AccountRequest payload);
    ApiResponse<?> listAppUser();
    ApiResponse<?> deleteAppUser(Integer userId);

}
