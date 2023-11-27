package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.AppUserRequest;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.example.luxecrib.dto.AppCode.OKAY;
import static com.example.luxecrib.dto.MessageUtil.SUCCESS;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepo;
    @Override
    public ResponseEntity<?> addAppUser(AppUserRequest payload) {
       Optional<Account> accountCheck = accountRepo.findAccountByEmail(payload.getEmail());
        if(accountCheck.isEmpty()){
            Account account= new Account();
            account.setFullName(payload.getFullName());
            account.setEmail(payload.getEmail());
            account.setPassword(payload.getPassword());
            account.setPhoneNumber(payload.getPhoneNumber());
            account.setUsername(payload.getUsername());
            account.setSocials(payload.getSocials());
            account.setAddress(payload.getAddress());
            account.setPhoto(payload.getPhoto());
            account.setUserType(payload.getUserType());
            accountRepo.save(account);
            log.info("Account successfully added: {}", account );
        }else
            throw new DuplicateRecordException("record already exist");
        return  ResponseEntity.ok("Account created successfully");
    }

    @Override
    public ApiResponse<?> updateAppUser(Integer id,AppUserRequest payload) {
        Account acct = accountRepo.findById(id).get();
        if(Objects.nonNull(acct.getFullName()) && !"".equalsIgnoreCase(acct.getFullName())){
            acct.setFullName(payload.getFullName());
        }
        if(Objects.nonNull(acct.getEmail()) && !"".equalsIgnoreCase(acct.getEmail() )){
            acct.setEmail(payload.getEmail());
        }
        if(Objects.nonNull(acct.getPhoneNumber()) && !"".equalsIgnoreCase(acct.getPhoneNumber())){
            acct.setPhoneNumber(payload.getPhoneNumber());
        }
        if(Objects.nonNull(acct.getPassword()) && !"".equalsIgnoreCase(acct.getPassword() )){
            acct.setPassword(payload.getPassword());
        }
        if(Objects.nonNull(acct.getAddress())){
            acct.setAddress(payload.getAddress());
        }

         accountRepo.save(acct);
        log.info("Updated value :{}",acct);
        return new ApiResponse<>(SUCCESS,OKAY,payload);

    }

    @Override
    public ApiResponse<?> listAppUser() {
        return null;
    }

    @Override
    public ApiResponse<?> deleteAppUser(Long userId) {
        return null;
    }
}
