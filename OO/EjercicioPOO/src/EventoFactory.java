import java.util.Date;

public class EventoFactory extends AbstractFactory {
    @Override
    public IContacto createContacto(Persona persona, String... args) {
        throw new UnsupportedOperationException("EventoFactory no puede crear contactos.");
    }

    @Override
    public IEvento createEvento(String descripcion, Date fecha, String ubicacion, String... args) {
        if (args.length == 0) {
            return new Evento(descripcion, fecha, ubicacion);
        } else if (args.length == 1) {
            return new EventoSocial(descripcion, fecha, ubicacion, args[0]);
        } else if (args.length == 2) {
            return new EventoProfesionales(descripcion, fecha, ubicacion, args[0]);
        }
        return null;
    }
}
