package sistemabiblioteca;
import java.util.ArrayList;
import java.util.List;
/**
 * TDA Biblioteca.
 * Esta clase administra los libros y usuarios de la biblioteca.
 * Contiene operaciones de registro, búsqueda, préstamo,
 * devolución y conteo recursivo.
 * Autor: Tomasa Rodriguez Hdez
 */
public class Biblioteca {
    // Atributos privados para aplicar encapsulamiento.
    private String nombre;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    /**
     * Constructor de la biblioteca.
     * @param nombre nombre de la biblioteca
     */
    public Biblioteca(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de la biblioteca no puede estar vacío."
            );
        }
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    // Getter del nombre.
    public String getNombre() {
        return nombre;
    }
    // Setter del nombre.
    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de la biblioteca no puede estar vacío."
            );
        }
        this.nombre = nombre;
    }
    /** MÉTODO 1: REGISTRAR LIBRO
     * Registra un libro en la biblioteca.
     * @param libro libro que se desea registrar
     */
    public void registrarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException(
                    "El libro no puede ser nulo."
            );
        }
        if (buscarLibro(libro.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un libro con ese código."
            );
        }
        libros.add(libro);
    }
    /** MÉTODO 2: REGISTRAR USUARIO
     * Registra un usuario en la biblioteca.
     * @param usuario usuario que se desea registrar
     */
    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario no puede ser nulo."
            );
        }
        if (buscarUsuario(usuario.getIdentificacion()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un usuario con esa identificación."
            );
        }
        usuarios.add(usuario);
    }
    /**MÉTODO 3: BUSCAR LIBRO
     * Busca un libro mediante su código.
     * @param codigo código del libro
     * @return libro encontrado o null si no existe
     */
    public Libro buscarLibro(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }
        return null;
    }
    /**
    MÉTODO 4: BUSCAR USUARIO
     * Busca un usuario mediante su identificación.
     * @param identificacion identificación del usuario
     * @return usuario encontrado o null si no existe
     */
    public Usuario buscarUsuario(String identificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            return null;
        }
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {
                return usuario;
            }
        }
        return null;
    }

    /**
    MÉTODO 5: PRESTAR LIBRO
     * Realiza el préstamo de un libro a un usuario.
     * @param codigoLibro código del libro
     * @param identificacionUsuario identificación del usuario
     */
    public void prestarLibro(
            String codigoLibro,
            String identificacionUsuario) {
        Libro libro = buscarLibro(codigoLibro);
        Usuario usuario = buscarUsuario(identificacionUsuario);

        if (libro == null) {
            throw new IllegalArgumentException(
                    "El libro no existe."
            );
        }
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario no existe."
            );
        }
        libro.prestar();
    }
    /**
    // MÉTODO 6: DEVOLVER LIBRO
     * Registra la devolución de un libro.
     * @param codigoLibro código del libro
     */
    public void devolverLibro(String codigoLibro) {
        Libro libro = buscarLibro(codigoLibro);
        if (libro == null) {
            throw new IllegalArgumentException(
                    "El libro no existe."
            );
        }
        libro.devolver();
    }
    /**
    // MÉTODO 7: MOSTRAR LIBROS DISPONIBLES
     * Obtiene todos los libros que están disponibles.
     * @return texto con los libros disponibles
     */
    public String mostrarLibrosDisponibles() {
        StringBuilder resultado = new StringBuilder();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                resultado.append(libro.obtenerInformacion());
                resultado.append("\n----------------------\n");
            }
        }
        if (resultado.length() == 0) {
            return "No hay libros disponibles.";
        }
        return resultado.toString();
    }
    /** MÉTODO 8: CONTAR LIBROS RECURSIVAMENTE
     * Cuenta la cantidad de libros utilizando recursividad.
     * CASO BASE:
     * Cuando la posición es igual al tamaño de la lista,
     * ya no existen más libros por contar.
     * CASO RECURSIVO:
     * Se cuenta un libro y se avanza a la siguiente posición.
     * @return cantidad total de libros
     */
    public int contarLibrosRecursivo() {
        return contarLibrosDesde(0);
    }
    /**
     * Método auxiliar recursivo.
     * @param posicion posición actual de la lista
     * @return cantidad de libros desde la posición indicada
     */
    private int contarLibrosDesde(int posicion) {
        // CASO BASE
        if (posicion >= libros.size()) {
            return 0;
        }
        // PASO RECURSIVO
        return 1 + contarLibrosDesde(posicion + 1);
    }
    /**MÉTODO 9: CONTAR USUARIOS
     * Devuelve la cantidad de usuarios registrados.
     * @return cantidad de usuarios
     */
    public int cantidadUsuarios() {
        return usuarios.size();
    }
    /**MÉTODO 10: OBTENER INFORMACIÓN GENERAL
     * Genera un resumen de la información de la biblioteca.
     * @return resumen de la biblioteca
     */
    public String obtenerResumen() {
        return "Biblioteca: " + nombre
                + "\nLibros registrados: "
                + contarLibrosRecursivo()
                + "\nUsuarios registrados: "
                + cantidadUsuarios();
    }
}