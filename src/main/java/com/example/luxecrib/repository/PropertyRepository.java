package com.example.luxecrib.repository;

import com.example.luxecrib.model.Occupant;
import com.example.luxecrib.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property,Integer> {
}
