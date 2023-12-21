package com.example.luxecrib.route;


import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.PropertyRequest;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value ="/api/v1/property")
@RequiredArgsConstructor
public class PropertyRoute {
    private final PropertyService propertyService;
    private final AccountRepository accountRepository;

//    public AccountRoute (AccountService service) {
//        this.accountService = service;
//    }

    @PostMapping("/add")
    ResponseEntity<?> addProperty(@RequestBody PropertyRequest payload,@RequestParam String email) {
        return propertyService.addProperty(payload,email);
    }

    @GetMapping("/list")
    public ApiResponse<?> getAllProperty () {

        return propertyService.listProperty();
    }
    @PostMapping("/update")
    ApiResponse<?> updateProperty(@RequestParam Integer id, @RequestBody PropertyRequest payload) {
        return propertyService.updateProperty(id,payload);
    }

    @DeleteMapping("/delete")
    ApiResponse<?> deleteProperty(@RequestParam Integer id) {
        return propertyService.deleteProperty(id);
    }
}
