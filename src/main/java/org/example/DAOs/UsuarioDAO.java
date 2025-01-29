package org.example.DAOs;

import jakarta.transaction.Transactional;
import org.example.Models.Usuarios;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class UsuarioDAO {

    @PersistenceContext(unitName = "org.examplePersistenceUnit")
    private EntityManager em;

    @Transactional
    public List<Usuarios> getAllUsuarios() {
        return em.createQuery("SELECT u FROM Usuarios u", Usuarios.class)
                .getResultList();
    }

    @Transactional
    public Usuarios getUsuarioByCedula(String cedula) {
        return em.find(Usuarios.class, cedula);
    }
}