import java.util.Date;

public class Evento implements IEvento {
    private String descripcion;
    private Date fecha;
    private String ubicacion;

    public Evento(String descripcion, Date fecha, String ubicacion) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    // Getters
    public String getDescripcion() { return descripcion; }

    public Date getFecha() { return fecha; }

    public String getUbicacion() { return ubicacion; }

    @Override
    public String toString() {
        return "Evento: " + descripcion + " el " + fecha + " en " + ubicacion;
    }
}

