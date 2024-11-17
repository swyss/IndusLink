package com.induslink.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name = "machines")
@Data
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String location;


}
