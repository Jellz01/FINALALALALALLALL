package org.example.Services;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Business.Gestion;
import org.example.Models.Usuarios;

import java.util.List;

@Path("/Usuario")
public class UsuarioService {
//asdasd
    @Inject
    private Gestion gestion;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuariosConsumos()
    {
        List<Usuarios> users = gestion.getUsuarios();
        return Response.ok(users).build();
    }

}