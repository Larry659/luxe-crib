package com.example.luxecrib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuarantorRequest {
    private String fullName;
    private AddressRequest addressRequest;
}
