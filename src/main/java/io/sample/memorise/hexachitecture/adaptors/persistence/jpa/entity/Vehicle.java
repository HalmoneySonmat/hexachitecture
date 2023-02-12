package io.sample.memorise.hexachitecture.adaptors.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class Vehicle {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME" , nullable = false)
    private String name;


    private String bornDate;


    private String color;


    private String type;


    private String useStatus;

}
