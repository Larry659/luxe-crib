package com.example.luxecrib.route;


import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.dto.request.OccupantRequest;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.AccountService;
import com.example.luxecrib.service.OccupantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value ="/api/v1/occupant")
@RequiredArgsConstructor
public class OccupantRoute {
    private final OccupantService occupantService;
    private final AccountRepository accountRepository;

//    public AccountRoute (AccountService service) {
//        this.accountService = service;
//    }

    @PostMapping("/add")
    ResponseEntity<?> addOccupant(@RequestBody OccupantRequest payload) {
        return occupantService.addOccupants(payload);
    }

    @GetMapping("/list")
    public ApiResponse<?> getAllOccupant () {

        return occupantService.listOccupant();
    }
    @PostMapping("/update")
    ApiResponse<?> updateOccupant(@RequestParam Integer id, @RequestBody OccupantRequest payload) {
        return occupantService.updateOccupant(id,payload);
    }

    @DeleteMapping("/delete")
    ApiResponse<?> deleteOccupant(@RequestParam Integer id) {
        return occupantService.deleteOccupant(id);
    }
}
