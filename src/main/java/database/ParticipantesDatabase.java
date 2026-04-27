package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipantesDatabase {
    private Connection dbConn;

    public ParticipantesDatabase() throws SQLException {
        setupBaseDeDatos();
    }

    private void setupBaseDeDatos() throws SQLException {
        String url = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    public void insertParticipante(String nombre, String telefono, String region) throws SQLException {
        PreparedStatement st = dbConn
                .prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
        try {
            st.setString(1, nombre);
            st.setString(2, telefono);
            st.setString(3, region);
            st.executeUpdate();
        } finally {
            st.close();
        }
    }

    public void closeConnection() throws SQLException {
        if (dbConn != null) {
            dbConn.close();
        }
    }
}

