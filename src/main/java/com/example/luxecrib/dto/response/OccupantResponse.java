package com.example.luxecrib.dto.response;

import com.example.luxecrib.helper.Guarantor;
import jakarta.persistence.Embedded;

public record OccupantResponse( String occupation, Boolean isMarried, Guarantor guarantor, Integer numberOfOccupant) {
}
