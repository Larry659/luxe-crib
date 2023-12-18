package com.example.luxecrib.route;


import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.AccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value ="/api/v1/accounts")
@RequiredArgsConstructor
public class AccountRoute{
    private final AccountService accountService;
    private final AccountRepository accountRepository;

//    public AccountRoute (AccountService service) {
//        this.accountService = service;
//    }

    @PostMapping("/add")
    ResponseEntity<?> addAccount(@RequestBody AccountRequest payload) {

        return accountService.addAccount(payload);
    }

    @GetMapping("/list")
    public ApiResponse<?> getAllAccounts () {
        return accountService.listAppUser();
    }
    @PostMapping("/update")
    ApiResponse<?> updateAccount(@RequestParam Integer id, @RequestBody AccountRequest payload) {
        return accountService.updateAppUser(id,payload);
    }

    @DeleteMapping("/delete")
    ApiResponse<?> deleteAccount(@RequestParam Integer id) {
        return accountService.deleteAppUser(id);
    }
}
