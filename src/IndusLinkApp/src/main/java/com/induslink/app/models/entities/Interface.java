package com.induslink.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "interfaces")
@Data
public class Interface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    private String protocol; // e.g., HTTP, MQTT

    @OneToMany(mappedBy = "interfaceType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Device> devices;
}
