import java.util.Date;
public class EventoSocial extends Evento {
    private String duracion;

    public EventoSocial(String descripcion, Date fecha, String ubicacion, String duracion) {
        super(descripcion, fecha, ubicacion);
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Evento Social: " + getDescripcion() + " el " + getFecha() + " en " + getUbicacion() + " - Duracion: " + duracion;
    }
}
