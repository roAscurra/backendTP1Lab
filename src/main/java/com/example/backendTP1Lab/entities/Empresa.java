package com.example.backendTP1Lab.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "")
    private String denominacion;
    @Column(name = "")
    private String telefono;
    @Column(name = "")
    private String horarioAtencion;
    @Column(name = "")
    private String quienesSomos;
    @Column(name = "")
    private Double latitud;
    @Column(name = "")
    private Double longitud;
    @Column(name = "")
    private String domicilio;
    @Column(name = "")
    private String email;
}
