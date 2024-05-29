public class ContactoEmpresarial extends Contacto {
    private String empresa;
    private String puesto;

    public ContactoEmpresarial(Persona persona, String empresa, String puesto) {
        super(persona);
        this.empresa = empresa;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Contacto Empresarial: " + persona.toString() + " - Empresa: " + empresa + " - Puesto: " + puesto;
    }
}