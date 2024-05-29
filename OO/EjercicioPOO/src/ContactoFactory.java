import java.util.Date;

public class ContactoFactory extends AbstractFactory {
    @Override
    public IContacto createContacto(Persona persona, String... args) {
        if (args.length == 0) {
            return new Contacto(persona);
        } else if (args.length == 1) {
            return new ContactoFamiliar(persona, args[0]);
        } else if (args.length == 2) {
            return new ContactoEmpresarial(persona, args[0], args[1]);
        }
        return null;
    }

    @Override
    public IEvento createEvento(String descripcion, Date fecha, String ubicacion, String... args) {
        throw new UnsupportedOperationException("ContactoFactory no puede crear eventos.");
    }
}