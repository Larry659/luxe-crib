package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.OccupantRequest;
import com.example.luxecrib.dto.request.OwnerRequest;
import com.example.luxecrib.dto.response.OccupantResponse;
import com.example.luxecrib.dto.response.OwnerResponse;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.exception.RecordNotFoundException;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.example.luxecrib.mapper.Mapper;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.model.Occupant;
import com.example.luxecrib.model.Owner;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.repository.OccupantRepository;
import com.example.luxecrib.repository.OwnerRepository;
import com.example.luxecrib.service.OccupantService;
import com.example.luxecrib.service.OwnerService;
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
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepo;
    private final AccountRepository accountRepo;

    @Override
    public ResponseEntity<?> addOwner(OwnerRequest payload) {
        Optional<Account> accountCheck = accountRepo.findAccountByEmail(payload.getEmail());
        Account user = accountCheck.get();
        if(user.getUserType().equalsIgnoreCase("owner")){
            //Account account= appMapper.convertToAccount(payload);
           Owner owner = new Owner();
            owner.setStayIn(payload.getStayIn());
            Address address = Address.builder()
                    .city(payload.getGuarantorRequest().getAddressRequest().getCity())
                    .state(payload.getGuarantorRequest().getAddressRequest().getState())
                    .street(payload.getGuarantorRequest().getAddressRequest().getStreet())
                    .build();
            Address addressOwner = Address.builder()
                    .city(payload.getAddressRequest().getCity())
                    .state(payload.getAddressRequest().getState())
                    .street(payload.getAddressRequest().getStreet())
                    .build();
            Guarantor guarantor =  Guarantor.builder()
                    .fullName(payload.getGuarantorRequest().getFullName())
                    .address(address)
                    .build();
            owner.setGuarantor(guarantor);
            owner.setAddress(addressOwner);
            ownerRepo.save(owner);
            log.info("Account successfully added: {}", owner );
        }else
            throw new DuplicateRecordException("record already exist");
        return  ResponseEntity.ok("Occupant created successfully");
    }

    @Override
    public ApiResponse<OwnerRequest> updateOwner(Integer id, OwnerRequest payload) {
        Owner owner = ownerRepo.findById(id).get();
        if(Objects.nonNull(owner.getAddress())){
            Address addressOwner = Address.builder()
                    .city(payload.getAddressRequest().getCity())
                    .state(payload.getAddressRequest().getState())
                    .street(payload.getAddressRequest().getStreet())
                    .build();
            owner.setAddress(addressOwner);
        }
        if(Objects.nonNull(owner.getStayIn())){
            owner.setStayIn(payload.getStayIn());
        }

        if(Objects.nonNull(owner.getGuarantor())){

            Address address = Address.builder()
                    .city(payload.getGuarantorRequest().getAddressRequest().getCity())
                    .state(payload.getGuarantorRequest().getAddressRequest().getState())
                    .street(payload.getGuarantorRequest().getAddressRequest().getStreet())
                    .build();
            Guarantor guarantor =  Guarantor.builder()
                    .fullName(payload.getGuarantorRequest().getFullName())
                    .address(address)
                    .build();
            owner.setGuarantor(guarantor);
        }

        ownerRepo.save(owner);
        log.info("Updated value :{}",owner);
        return new ApiResponse<>(SUCCESS,OKAY,payload);

    }

    @Override
    public ApiResponse<?> listOwner() {

        List<Owner> ownerList = ownerRepo.findAll();
        if(!ownerList.isEmpty()){
            List<OccupantResponse> responseList = Mapper.convertList(ownerList, OwnerResponse.class);
            //List<AccountResponse> responseList = AccountConverter.convertToResponseList(accountsList);
            log.info("This is the responseList {}",responseList);
            return new ApiResponse<>(SUCCESS,OKAY,responseList);
        }
        else
            return new ApiResponse<>(FAILED,ERROR_CODE);
    }

    @Override
    public ApiResponse<?> deleteOwner(Integer id) {
        Optional<Owner> owner = ownerRepo.findById(id);
        if(owner.isPresent()){
            ownerRepo.delete(owner.get());
            return new ApiResponse<>(DELETED,OKAY);

        }else
            throw new RecordNotFoundException("record with id " + owner.get().getId());


    }
    }

