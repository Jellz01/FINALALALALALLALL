package org.example.Business;


import jakarta.enterprise.context.ApplicationScoped;
import org.example.DAOs.BinomioDao;
import org.example.Models.Binomios;
import org.example.Models.Usuarios;

import java.util.List;

@ApplicationScoped
public class gestionBinomios {

    private BinomioDao binomioDao;


    public List<Binomios> getUsuarios() {
        return BinomioDao.
    }

}
