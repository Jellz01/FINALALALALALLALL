package org.example.Models;


import jakarta.persistence.*;

@Entity
public class Binomios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use Identity for auto-increment
    private Long id;

    @Column(nullable = false, unique = true)
    private String cedula;

    private String partido;
    private String nombrePartido;
    private String nombre;
    private String VicePresidente;

    public String getVicePresidente() {
        return VicePresidente;
    }

    public void setVicePresidente(String vicePresidente) {
        VicePresidente = vicePresidente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
       this.nombrePartido = nombrePartido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Binomios{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", Partido='" + partido + '\'' +
                ", NombrePar='" + nombrePartido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


