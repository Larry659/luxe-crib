package com.example.luxecrib.mapper;

import com.example.luxecrib.dto.AccountRequest;
import com.example.luxecrib.model.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AppMapper {
   // SimpleDestination sourceToDestination(SimpleSource source);
    //SimpleSource destinationToSource(SimpleDestination destination);
    Account convertToAccount(AccountRequest payload);
}
