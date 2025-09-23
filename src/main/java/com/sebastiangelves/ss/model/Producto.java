package com.sebastiangelves.ss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity le dice a Spring que esta clase es una tabla de la BD
@Entity
public class Producto {

    // @Id indica que este es el campo de la clave primaria
    // @GeneratedValue indica que el ID se generará automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadStock;

    // Getters y Setters (sin cambios)
    // ...
}