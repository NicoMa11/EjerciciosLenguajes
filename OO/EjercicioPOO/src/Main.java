import java.util.Date;

public class Main {
    public static void main(String[] args) {
        AbstractFactory contactoFactory = new ContactoFactory();
        AbstractFactory eventoFactory = new EventoFactory();


        // Crear personas
        Persona persona1 = new Persona("Nicole", "Marin", "Chachagua", "60264869");
        Persona persona2 = new Persona("Pamela", "Marin", "San Rafael", "86047013");
        Persona persona3 = new Persona("Juan", "Perez", "La Fortuna", "74561234");
        Persona persona4 = new Persona("Maria", "Gomez", "San Carlos", "85214763");
        Persona persona5 = new Persona("Carlos", "Rojas", "Ciudad Quesada", "98765432");

        // Crear contactos
        IContacto contacto1 = contactoFactory.createContacto(persona1);
        IContacto contacto2 = contactoFactory.createContacto(persona2, "Hermana");
        IContacto contacto3 = contactoFactory.createContacto(persona1, "Tech Corp", "Desarrollador");
        IContacto contacto4 = contactoFactory.createContacto(persona3, "Amigo");
        IContacto contacto5 = contactoFactory.createContacto(persona4, "Soft Solutions", "Gerente");
        IContacto contacto6 = contactoFactory.createContacto(persona5, "Prima");

        // Crear eventos
        IEvento evento1 = eventoFactory.createEvento("Conferencia de Tecnología", new Date(), "Centro de Convenciones", "Tecnologia");
        IEvento evento2 = eventoFactory.createEvento("Fiesta de Cumpleaños", new Date(), "Casa de John", "4 horas");
        IEvento evento3 = eventoFactory.createEvento("Reunion de Negocios", new Date(), "Hotel La Fortuna", "Negocios");
        IEvento evento4 = eventoFactory.createEvento("Cena Familiar", new Date(), "Restaurante El Buen Comer", "2 horas");
        IEvento evento5 = eventoFactory.createEvento("Seminario de Desarrollo Personal", new Date(), "Auditorio Nacional", "Desarrollo Personal");

        // Obtener la instancia única de Agenda
        Agenda agenda = Agenda.getInstance();

        // Agregar elementos a la agenda
        agenda.addItem(contacto1);
        agenda.addItem(contacto2);
        agenda.addItem(contacto3);
        agenda.addItem(contacto4);
        agenda.addItem(contacto5);
        agenda.addItem(contacto6);
        agenda.addItem(evento1);
        agenda.addItem(evento2);
        agenda.addItem(evento3);
        agenda.addItem(evento4);
        agenda.addItem(evento5);

        // Mostrar la agenda completa
        System.out.println("Agenda Completa:");
        System.out.println(agenda);

        // Filtrar y mostrar solo contactos
        System.out.println("\nContactos:");
        agenda.filterItems(item -> item instanceof IContacto).forEach(System.out::println);

        // Filtrar y mostrar solo eventos
        System.out.println("\nEventos:");
        agenda.filterItems(item -> item instanceof IEvento).forEach(System.out::println);
    }
}

