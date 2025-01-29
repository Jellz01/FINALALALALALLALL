package org.example.DAOs;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.Models.Binomios;
import org.example.Models.Usuarios;

import java.util.List;

@ApplicationScoped
public class BinomioDao {

    @PersistenceContext(unitName = "org.examplePersistenceUnit")
    private EntityManager em;

    public List<Binomios> getAllBinomios() {
        return em.createQuery("SELECT u FROM Binomios u", Binomios.class)
                .getResultList();
    }

}
