package org.example.Business;
import org.example.DAOs.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import org.example.Models.Usuarios;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Services.UsuarioService;

import java.util.List;

@ApplicationScoped
public class Gestion {

    @Inject
    private UsuarioDAO usuarioDao;

    public List<Usuarios> getUsuarios() {
        return usuarioDao.getAllUsuarios();
    }

    public Usuarios getUsuarioCedula(String cedula) {
        return usuarioDao.getUsuarioByCedula(cedula);
    }






}