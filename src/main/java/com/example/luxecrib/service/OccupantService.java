package com.example.luxecrib.service;

import com.example.luxecrib.dto.request.AccountRequest;
import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.OccupantRequest;
import org.springframework.http.ResponseEntity;

public interface OccupantService {
    ResponseEntity<?> addOccupants(OccupantRequest payload);
    ApiResponse<OccupantRequest> updateOccupant(Integer id, OccupantRequest payload);
    ApiResponse<?> listOccupant();
    ApiResponse<?> deleteOccupant(Integer Id);
}
