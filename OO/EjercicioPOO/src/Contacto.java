public class Contacto implements IContacto {
    protected Persona persona;

    public Contacto(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Contacto: " + persona.toString();
    }
}


/*
 * Justificación del uso del patrón Abstract Factory:
 *
 * Usé el patrón Abstract Factory para la creación de contactos y eventos para:
 * 1. Facilitar la creación de familias de objetos relacionados sin especificar sus clases concretas.
 * 2. Proveer una interfaz para la creación de objetos, lo que permite cambiar las implementaciones sin afectar el código cliente.
 * 3. Permitir la extensión del sistema de manera más sencilla agregando nuevos tipos de contactos y eventos sin modificar las clases existentes.
 */


