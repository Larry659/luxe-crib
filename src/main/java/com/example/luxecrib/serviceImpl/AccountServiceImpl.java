package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.response.AccountResponse;
import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.exception.RecordNotFoundException;
import com.example.luxecrib.mapper.Mapper;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.luxecrib.dto.AppCode.ERROR_CODE;
import static com.example.luxecrib.dto.AppCode.OKAY;
import static com.example.luxecrib.dto.MessageUtil.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepo;
//   private final AppMapper appMapper;
    @Override
    public ResponseEntity<String> addAccount(AccountRequest payload) {
       Optional<Account> accountCheck = accountRepo.findAccountByEmail(payload.getEmail());
        if(accountCheck.isEmpty()){
           //Account account= appMapper.convertToAccount(payload);
            Account account = new Account();
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
    public ApiResponse<AccountRequest> updateAppUser(Integer id, AccountRequest payload) {
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
List<Account> accountList = accountRepo.findAll();
        if(!accountList.isEmpty()){
            List<AccountResponse> responseList = Mapper.convertList(accountList, AccountResponse.class);
            //List<AccountResponse> responseList = AccountConverter.convertToResponseList(accountsList);
            log.info("This is the responseList {}",responseList);
            return new ApiResponse<>(SUCCESS,OKAY,responseList);
        }
        else
            return new ApiResponse<>(FAILED,ERROR_CODE);
    }

    @Override
    public ApiResponse<?> deleteAppUser(Integer userId) {

        Optional<Account> account = accountRepo.findById(userId);
        if(account.isPresent()){
            accountRepo.delete(account.get());
            return new ApiResponse<>(DELETED,OKAY);

        }else
            throw new RecordNotFoundException("record with id " + account.get().getUserId());


    }
}
