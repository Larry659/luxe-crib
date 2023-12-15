package com.example.luxecrib.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {
    @Column(insertable=false, updatable=false)
    private String state;
    @Column(insertable=false, updatable=false)
    private String city;
    @Column(insertable=false, updatable=false)
    private String street;
}
