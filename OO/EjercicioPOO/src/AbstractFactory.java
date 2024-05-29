import java.util.Date;

abstract class AbstractFactory {
    public abstract IContacto createContacto(Persona persona, String... args);
    public abstract IEvento createEvento(String descripcion, Date fecha, String ubicacion, String... args);
}
