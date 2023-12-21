package com.example.luxecrib.route;


import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.OwnerRequest;
import com.example.luxecrib.dto.request.OwnerRequest;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.OwnerService;
import com.example.luxecrib.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value ="/api/v1/owner")
@RequiredArgsConstructor
public class OwnerRoute {
    private final OwnerService ownerService;
    private final AccountRepository accountRepository;

//    public AccountRoute (AccountService service) {
//        this.accountService = service;
//    }

    @PostMapping("/add")
    ResponseEntity<?> addOwner(@RequestBody OwnerRequest payload) {
        return ownerService.addOwner(payload);
    }

    @GetMapping("/list")
    public ApiResponse<?> getAllOwner () {

        return ownerService.listOwner();
    }
    @PostMapping("/update")
    ApiResponse<?> updateOwner(@RequestParam Integer id, @RequestBody OwnerRequest payload) {
        return ownerService.updateOwner(id,payload);
    }

    @DeleteMapping("/delete")
    ApiResponse<?> deleteOwner(@RequestParam Integer id) {
        return ownerService.deleteOwner(id);
    }
}
