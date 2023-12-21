package com.example.luxecrib.serviceImpl;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.PropertyRequest;
import com.example.luxecrib.dto.request.PropertyRequest;
import com.example.luxecrib.dto.response.OccupantResponse;
import com.example.luxecrib.dto.response.PropertyResponse;
import com.example.luxecrib.exception.DuplicateRecordException;
import com.example.luxecrib.exception.RecordNotFoundException;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.example.luxecrib.mapper.Mapper;
import com.example.luxecrib.model.Account;
import com.example.luxecrib.model.Property;
import com.example.luxecrib.model.Property;
import com.example.luxecrib.repository.AccountRepository;
import com.example.luxecrib.repository.PropertyRepository;
import com.example.luxecrib.repository.PropertyRepository;
import com.example.luxecrib.service.PropertyService;
import com.example.luxecrib.service.PropertyService;
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
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepo;
    private final AccountRepository accountRepo;

    @Override
    public ResponseEntity<?> addProperty(PropertyRequest payload, String email) {
        Optional<Account> accountCheck = accountRepo.findAccountByEmail(email);
        Account user = accountCheck.get();
        if(user.getUserType().equalsIgnoreCase("property")){
            //Account account= appMapper.convertToAccount(payload);
           Property property = new Property();
            Address address = Address.builder()
                    .city(payload.getAddress().getCity())
                    .state(payload.getAddress().getState())
                    .street(payload.getAddress().getStreet())
                    .build();
            property.setAddress(address);
            property.setAmount(payload.getAmount());
            property.setForSale(payload.getForSale());
            property.setForLease(payload.getForLease());
            property.setIsVacant(payload.getIsVacant());
            property.setPhotos(payload.getPhotos());
            property.setDescription(payload.getDescription());
            property.setHouseType(payload.getHouseType());
            propertyRepo.save(property);
            log.info("Account successfully added: {}", property );
        }else
            throw new DuplicateRecordException("record already exist");
        return  ResponseEntity.ok("Property created successfully");
    }

    @Override
    public ApiResponse<PropertyRequest> updateProperty(Integer id, PropertyRequest payload) {
        Property property = propertyRepo.findById(id).get();
        if(Objects.nonNull(property.getAddress())){
            Address addressProperty = Address.builder()
                    .city(payload.getAddress().getCity())
                    .state(payload.getAddress().getState())
                    .street(payload.getAddress().getStreet())
                    .build();
            property.setAddress(addressProperty);
        }
        if(Objects.nonNull(property.getForSale())){
            property.setForSale(payload.getForSale());
        }

        if(Objects.nonNull(property.getAmount())){
            property.setAmount(payload.getAmount());
        }
        if(Objects.nonNull(property.getHouseType())){
            property.setHouseType(payload.getHouseType());
        }
        if(Objects.nonNull(property.getForLease())){
            property.setForLease(payload.getForLease());
        }
        if(Objects.nonNull(property.getIsVacant())){
            property.setIsVacant(payload.getIsVacant());
        }
        if(Objects.nonNull(property.getDescription())){
            property.setIsVacant(payload.getIsVacant());
        }
        propertyRepo.save(property);
        log.info("Updated value :{}",property);
        return new ApiResponse<>(SUCCESS,OKAY,payload);
    }





    @Override
    public ApiResponse<?> listProperty() {

        List<Property> propertyList = propertyRepo.findAll();
        if(!propertyList.isEmpty()){
            List<OccupantResponse> responseList = Mapper.convertList(propertyList, PropertyResponse.class);
            //List<AccountResponse> responseList = AccountConverter.convertToResponseList(accountsList);
            log.info("This is the responseList {}",responseList);
            return new ApiResponse<>(SUCCESS,OKAY,responseList);
        }
        else
            return new ApiResponse<>(FAILED,ERROR_CODE);
    }

    @Override
    public ApiResponse<?> deleteProperty(Integer id) {
        Optional<Property> property = propertyRepo.findById(id);
        if(property.isPresent()){
            propertyRepo.delete(property.get());
            return new ApiResponse<>(DELETED,OKAY);

        }else
            throw new RecordNotFoundException("record with id " + property.get().getPropertyId());


    }
    }

