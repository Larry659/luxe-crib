package com.example.luxecrib.service;

import com.example.luxecrib.dto.ApiResponse;
import com.example.luxecrib.dto.request.PropertyRequest;
import com.example.luxecrib.dto.request.PropertyRequest;
import org.springframework.http.ResponseEntity;

public interface PropertyService {
    ResponseEntity<?> addProperty(PropertyRequest payload,String email);
    ApiResponse<PropertyRequest> updateProperty(Integer id, PropertyRequest payload);
    ApiResponse<?> listProperty();
    ApiResponse<?> deleteProperty(Integer Id);
}
