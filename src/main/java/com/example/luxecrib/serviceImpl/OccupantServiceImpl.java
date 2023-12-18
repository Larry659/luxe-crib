package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.dto.request.OccupantRequest;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.model.Occupant;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.repository.OccupantRepository;
import com.example.luxecrib.service.OccupantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OccupantServiceImpl implements OccupantService {
    private final OccupantRepository occupantRepository;
    private final AccountRepository accountRepo;
    @Override
    public ResponseEntity<?> addOccupants(OccupantRequest payload) {
        Optional<Account> accountCheck = accountRepo.findAccountByEmail(payload.getEmail());
        Account user = accountCheck.get();
        if(user.getUserType().equalsIgnoreCase("occupant")){
            //Account account= appMapper.convertToAccount(payload);
            Occupant occupant = new Occupant();
           occupant.setOccupation(user.getOccupation());
           occupant.setNumberOfOccupant(payload.getNumberOfOccupant());
           occupant.setIsMarried(user.getIsMarried());
           Address address = Address.builder()
                   .city(payload.getGuarantorRequest().getAddressRequest().getCity())
                   .state(payload.getGuarantorRequest().getAddressRequest().getState())
                   .street(payload.getGuarantorRequest().getAddressRequest().getStreet())
                   .build();
          Guarantor guarantor =  Guarantor.builder()
                  .fullName(payload.getGuarantorRequest().getFullName())
                            .address(address)
                                    .build();
           occupant.setGuarantor(guarantor);
            occupantRepository.save(occupant);
            log.info("Account successfully added: {}", occupant );
        }else
            throw new DuplicateRecordException("record already exist");
        return  ResponseEntity.ok("Occupant created successfully");
    }

    @Override
    public ApiResponse<OccupantRequest> updateOccupant(Integer id, OccupantRequest payload) {
        return null;
    }

    @Override
    public ApiResponse<?> listOccupant() {
        return null;
    }

    @Override
    public ApiResponse<?> deleteOccupant(Integer Id) {
        return null;
    }
}
