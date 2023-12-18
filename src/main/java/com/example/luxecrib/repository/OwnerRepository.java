package com.example.luxecrib.repository;

import com.example.luxecrib.model.Occupant;
import com.example.luxecrib.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
