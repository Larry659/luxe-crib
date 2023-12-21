package com.example.luxecrib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerRequest {
    private String email;
    private Boolean stayIn;
    private GuarantorRequest guarantorRequest;
    private OwnerAddressRequest addressRequest;


}
