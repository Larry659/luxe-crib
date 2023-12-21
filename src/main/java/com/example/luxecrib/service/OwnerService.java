package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.OccupantRequest;
import com.example.luxecrib.dto.request.OwnerRequest;
import org.springframework.http.ResponseEntity;

public interface OwnerService {
    ResponseEntity<?> addOwner(OwnerRequest payload);
    ApiResponse<OwnerRequest> updateOwner(Integer id, OwnerRequest payload);
    ApiResponse<?> listOwner();
    ApiResponse<?> deleteOwner(Integer Id);
}
