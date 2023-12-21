package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.dto.request.OccupantRequest;
import com.example.luxecrib.dto.response.AccountResponse;
import com.example.luxecrib.dto.response.OccupantResponse;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.exception.RecordNotFoundException;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.example.luxecrib.mapper.Mapper;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.model.Occupant;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.repository.OccupantRepository;
import com.example.luxecrib.service.OccupantService;
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
        Occupant occupant = occupantRepository.findById(id).get();

        if(Objects.nonNull(occupant.getNumberOfOccupant())){
            occupant.setNumberOfOccupant(payload.getNumberOfOccupant());
        }
        if(Objects.nonNull(occupant.getGuarantor())){

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
        }

        occupantRepository.save(occupant);
        log.info("Updated value :{}",occupant);
        return new ApiResponse<>(SUCCESS,OKAY,payload);

    }

    @Override
    public ApiResponse<?> listOccupant() {

        List<Occupant> occupantList = occupantRepository.findAll();
        if(!occupantList.isEmpty()){
            List<OccupantResponse> responseList = Mapper.convertList(occupantList, OccupantResponse.class);
            //List<AccountResponse> responseList = AccountConverter.convertToResponseList(accountsList);
            log.info("This is the responseList {}",responseList);
            return new ApiResponse<>(SUCCESS,OKAY,responseList);
        }
        else
            return new ApiResponse<>(FAILED,ERROR_CODE);
    }

    @Override
    public ApiResponse<?> deleteOccupant(Integer id) {
        Optional<Occupant> occupant = occupantRepository.findById(id);
        if(occupant.isPresent()){
            occupantRepository.delete(occupant.get());
            return new ApiResponse<>(DELETED,OKAY);

        }else
            throw new RecordNotFoundException("record with id " + occupant.get().getOccupantId());


    }
    }

