package sistemabiblioteca;
/**
 * Clase base que representa los datos generales de una persona.
 * Autor: Tomasa Rodriguez Hdez.
 */
public class Persona {
    // Atributos privados para aplicar encapsulamiento.
    private String nombre;
    private String identificacion;
    /**
     * Constructor de la clase Persona.
     * @param nombre nombre de la persona
     * @param identificacion identificación de la persona
     */
    public Persona(String nombre, String identificacion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
        }
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
    // Getter del nombre.
    public String getNombre() {
        return nombre;
    }
    // Setter del nombre.
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    // Getter de la identificación.
    public String getIdentificacion() {
        return identificacion;
    }
    // Setter de la identificación.
    public void setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
        }
        this.identificacion = identificacion;
    }
}