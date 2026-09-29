package sistemabiblioteca;
/**
 * Representa a un usuario de la biblioteca.
 * Esta clase hereda los atributos y métodos de Persona.
 * Autor: Tomasa Rodriguez Hdez.
 */
public class Usuario extends Persona {
    private String carrera;
    /**
     * Constructor de Usuario.
     * @param nombre nombre del usuario
     * @param identificacion identificación del usuario
     * @param carrera carrera del usuario
     */
    public Usuario(String nombre, String identificacion, String carrera) {
        super(nombre, identificacion);
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        }
        this.carrera = carrera;
    }
    // Getter de carrera.
    public String getCarrera() {
        return carrera;
    }
    // Setter de carrera.
    public void setCarrera(String carrera) {
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        }
        this.carrera = carrera;
    }
    /**
     * Devuelve la información completa del usuario.
     * @return información del usuario
     */
    public String obtenerInformacion() {
        return "Nombre: " + getNombre()
                + "\nIdentificación: " + getIdentificacion()
                + "\nCarrera: " + carrera;
    }
}