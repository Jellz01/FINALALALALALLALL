package org.example.DAOs;

import org.example.Models.Usuarios;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
//asdasdasd
@ApplicationScoped
public class UsuarioDAO {
    @PersistenceContext(unitName = "org.examplePersistenceUnit")
    private EntityManager em;

    public Usuarios getUsuarioByCedula(String cedula) {
        return em.find(Usuarios.class, cedula);
    }
   public List<Usuarios> getAllUsuarios() {
        return em.createQuery( "SELECT * FROM Usuarios ", Usuarios.class ).getResultList();
    }


}