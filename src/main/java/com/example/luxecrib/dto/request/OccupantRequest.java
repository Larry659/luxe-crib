package com.example.luxecrib.dto.request;

import com.example.luxecrib.helper.Guarantor;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class OccupantRequest {
    private String email;
    private GuarantorRequest guarantorRequest;
    private Integer numberOfOccupant;
}
