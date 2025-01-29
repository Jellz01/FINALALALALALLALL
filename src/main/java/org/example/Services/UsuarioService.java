package org.example.Services;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.DAOs.UsuarioDAO;
import org.example.Models.Usuarios;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

import java.sql.*;

@Path("/Usuario")
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jjwm20020";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        String query = "SELECT cedula, nombre, consumo, deudas FROM Usuarios";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                arrayBuilder.add(
                        Json.createObjectBuilder()
                                .add("cedula", rs.getString("cedula"))
                                .add("nombre", rs.getString("nombre"))
                                .add("consumo", rs.getString("consumo"))
                                .add("deudas", rs.getString("deudas"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Database error: " + e.getMessage()).build();
        }

        JsonArray usuariosArray = arrayBuilder.build();
        return Response.ok(usuariosArray).build();
    }
}
