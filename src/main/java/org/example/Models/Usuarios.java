package org.example.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use Identity for auto-increment
    private Long id;

    @Column(nullable = false, unique = true)
    private String cedula;

    private String consumo;
    private String deudas;
    private String nombre;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getDeudas() {
        return deudas;
    }

    public void setDeudas(String deudas) {
        this.deudas = deudas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", consumo='" + consumo + '\'' +
                ", deudas='" + deudas + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
