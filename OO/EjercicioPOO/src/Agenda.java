import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Agenda {
    private List<Object> items;
    private static Agenda instance;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase
    private Agenda() {
        this.items = new ArrayList<>();
    }

    // Método estático para obtener la única instancia de la clase (Singleton)
    public static synchronized Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }

    // Métodos para añadir, eliminar y modificar contactos y eventos
    public void addItem(Object item) {
        items.add(item);
    }

    public void removeItem(Object item) {
        items.remove(item);
    }

    public List<Object> getItems() {
        return items;
    }

    // Método toString
    @Override
    public String toString() {
        return items.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    // Método para filtrar elementos
    public List<Object> filterItems(Predicate<Object> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }
}

/*
 * Justificación del uso del patrón Singleton:
 *
 * Usé el patrón Singleton para la clase Agenda para asegurar que solo
 * exista una única instancia de la agenda a lo largo de la aplicación, lo cual
 * es útil para centralizar el almacenamiento y la gestión de contactos y eventos.
 * Esto va a evitar la inconsistencia de datos que podría ocurrir si se permitiera
 * múltiples instancias de la agenda.
 *
 * Diferencias entre Eager Singleton y Lazy Singleton:
 * - Eager Singleton: La instancia se crea en el momento de la carga de la clase.
 *   Es más simple, pero puede ser ineficiente si la instancia nunca es utilizada.
 * - Lazy Singleton: La instancia se crea solo cuando es necesaria por primera vez.
 *
 * En esta implementación, utilicé Lazy Singleton porque:
 * 1. No hay seguridad de que siempre se necesitará la instancia de Agenda.
 * 2. La idea es optimizar el uso de recursos creando la instancia solo cuando realmente se necesita.
 */