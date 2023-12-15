package com.example.luxecrib.route;


import com.example.luxecrib.dto.AccountRequest;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("")
    public ResponseEntity getAllAccounts () {
        return new ResponseEntity( accountRepository.findAll(), HttpStatus.OK);
    }
//    @PostMapping("/update")
//    ApiResponse<?> updateAccount(@RequestParam Long id, @RequestBody AccountRequest payload) {
//        return accountService.updatedAccount(id,payload);
//    }
//    @GetMapping("/fetch")
//    ApiResponse<?> getAccount() {
//
//        return accountService.listAccounts();
//    }
//    @DeleteMapping("/delete")
//    ApiResponse<?> deleteAccount(@RequestParam Long id) {
//        return accountService.deleteAccount(id);
//    }
//
//    @GetMapping("/count")
//    ApiResponse<?> getAccountCount() {
//        return accountService.countAccounts();
//    }
//
//    @GetMapping("/count_month")
//    ApiResponse<?> getAccountCountForMonth() {
//        return accountService.countAccountForMonth();
//    }
}
