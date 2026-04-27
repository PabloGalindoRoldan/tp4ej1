package model;

import database.ParticipantesDatabase;
import java.sql.SQLException;

public class DatabaseRegistroParticipantes implements RegistroParticipantes {
    private ParticipantesDatabase db;

    public DatabaseRegistroParticipantes() throws SQLException {
        this.db = new ParticipantesDatabase();
    }

    @Override
    public void registrar(Participante participante) {
        try {
            db.insertParticipante(participante.getNombre(), participante.getTelefono(), participante.getRegion());
        } catch (SQLException e) {
            throw new RuntimeException("Error registering participant: " + e.getMessage(), e);
        }
    }

    public void closeConnection() throws SQLException {
        db.closeConnection();
    }
}
