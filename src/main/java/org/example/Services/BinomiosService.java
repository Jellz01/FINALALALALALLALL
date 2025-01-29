package org.example.Services;


import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.DAOs.BinomioDao;
import org.example.DAOs.UsuarioDAO;

import java.sql.*;

@Path("Binomios")
public class BinomiosService {


    @Inject
    private BinomioDao binomioDao;

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jjwm20020";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        String query = "SELECT CEDULA,PARTIDO,NOMBREPARTIDO,NOMBRE,VICE FROM BINOMIOS;";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                arrayBuilder.add(
                        Json.createObjectBuilder()
                                .add("cedula", rs.getString("cedula"))
                                .add("partido", rs.getString("partido"))
                                .add("nombrePartido", rs.getString("NombrePartido"))
                                .add("nombre", rs.getString("nombre"))
                                .add("vice",rs.getString("vice"))
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



