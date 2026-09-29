package sistemabiblioteca;
/**
 * Clase principal del sistema.
 * Aquí se realizan pruebas de funcionamiento del TDA Biblioteca.
 * Autor: Tomasa Rodriguez Hdez.
 */
public class SistemaBiblioteca {
    public static void main(String[] args) {

        // CREACIÓN DE LA BIBLIOTECA
        Biblioteca biblioteca =
                new Biblioteca("Biblioteca Escolar de la Huasteca Hidalguense");
        // CREACIÓN DE USUARIOS
        Usuario usuario1 = new Usuario(
                "Ana Lopez",
                "U001",
                "Ingenieria en Desarrollo de Software Multiplataforma"
        );
        Usuario usuario2 = new Usuario(
                "Carlos Perez",
                "U002",
                "Administracion"
        );
        // Registrar usuarios.
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);
        // CREACIÓN DE LIBROS
        Libro libro1 = new Libro(
                "Java desde cero",
                "Juan Martinez",
                "L001"
        );
        Libro libro2 = new Libro(
                "Programacion Orientada a Objetos",
                "Maria Gonzalez",
                "L002"
        );
        Libro libro3 = new Libro(
                "Estructuras de Datos",
                "Pedro Hernandez",
                "L003"
        );
        // Registrar libros.
        biblioteca.registrarLibro(libro1);
        biblioteca.registrarLibro(libro2);
        biblioteca.registrarLibro(libro3);
        // MOSTRAR INFORMACIÓN
        System.out.println("     SISTEMA DE GESTION DE BIBLIOTECA");
        System.out.println();
        System.out.println(biblioteca.obtenerResumen());
        System.out.println();
        // MOSTRAR LIBROS DISPONIBLES
        System.out.println("LIBROS DISPONIBLES:");
        System.out.println("-------------------");
        System.out.println(
                biblioteca.mostrarLibrosDisponibles()
        );
        // REALIZAR PRÉSTAMO
        System.out.println("REALIZANDO PRESTAMO...");
        biblioteca.prestarLibro("L001", "U001");
        System.out.println(
                "El libro L001 fue prestado a Ana Lopez."
        );
        System.out.println();
        // MOSTRAR LIBROS DESPUÉS DEL PRÉSTAMO
        System.out.println(
                "LIBROS DISPONIBLES DESPUES DEL PRESTAMO:"
        );
        System.out.println("-----------------------------------------");
        System.out.println(
                biblioteca.mostrarLibrosDisponibles()
        );
        // PROBAR BÚSQUEDA
        System.out.println("BUSCANDO EL LIBRO L002...");
        Libro libroEncontrado =
                biblioteca.buscarLibro("L002");
        if (libroEncontrado != null) {
            System.out.println(
                    libroEncontrado.obtenerInformacion()
            );
        }
        System.out.println();
        // PROBAR DEVOLUCIÓN
        System.out.println("DEVOLVIENDO EL LIBRO L001...");
        biblioteca.devolverLibro("L001");
        System.out.println(
                "Libro devuelto correctamente."
        );
        System.out.println();
        // PROBAR RECURSIVIDAD
        System.out.println("CANTIDAD DE LIBROS:");
        int cantidad =
                biblioteca.contarLibrosRecursivo();
        System.out.println(
                "Total de libros: " + cantidad
        );
        System.out.println();
        // RESUMEN FINAL
        System.out.println("          RESUMEN FINAL");
        System.out.println(
                biblioteca.obtenerResumen()
        );
    }
}