package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuarios
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="cedula")
    private String cedula;


    @Column(name = "consumo")
    private String consumo;

    @Column (name="deudas")
    private String  deudas;


    @Column(name="nombre")
    private String nombre;

    public long getId()
    {
        return id;
    }
    public void setId (long id)
    {
        this.id = id;

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDeudas() {
        return deudas;
    }

    public void setDeudas(String deudas) {
        this.deudas = deudas;
    }
}