package com.induslink.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "interfaces")
@Data
public class Interface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "OPC UA", "Modbus"
    private String protocol;

    @OneToMany(mappedBy = "interfaceType", cascade = CascadeType.ALL)
    private List<Device> devices;
}
