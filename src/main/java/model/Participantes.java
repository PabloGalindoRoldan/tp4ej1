package model;

public class Participantes {
    private RegistroParticipantes registroDeParticipantes;

    public Participantes(RegistroParticipantes registroDeparticipantes){
        this.registroDeParticipantes = registroDeParticipantes;
    }


    public void nuevoParticipante(String nombre, String telefono, String region){
        var Participante = new Participante(nombre, telefono, region);
        this.registroDeParticipantes.registrar(Participante);
    }

}
