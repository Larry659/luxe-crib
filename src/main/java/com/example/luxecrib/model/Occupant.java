package com.example.luxecrib.model;

import com.example.luxecrib.helper.Guarantor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Occupant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String occupation;
    private Boolean isMarried;
    @Embedded
    private Guarantor guarantor;
    private Integer numberOfOccupant;
}
