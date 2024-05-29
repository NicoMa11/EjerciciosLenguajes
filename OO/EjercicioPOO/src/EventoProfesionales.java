import java.util.Date;

public class EventoProfesionales extends Evento {
    private String enfoque;

    public EventoProfesionales(String descripcion, Date fecha, String ubicacion, String enfoque) {
        super(descripcion, fecha, ubicacion);
        this.enfoque = enfoque;
    }

    @Override
    public String toString() {
        return "Evento Profesional: " + getDescripcion() + " el " + getFecha() + " en " + getUbicacion() + " - Enfoque: " + enfoque;
    }
}