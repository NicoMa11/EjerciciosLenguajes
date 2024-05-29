public class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + telefono + ")";
    }
}
