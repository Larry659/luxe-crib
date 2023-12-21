package com.example.luxecrib.dto.response;

import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.example.luxecrib.model.Property;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public record OwnerResponse( Boolean stayIn, Guarantor guarantor, Integer numberOfOccupant,Address address,List<PropertyResponse> propertyResponses) {

}
