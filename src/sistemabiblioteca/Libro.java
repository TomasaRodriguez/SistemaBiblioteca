package sistemabiblioteca;
/**
 * Representa un libro dentro de la biblioteca.
 * Autor: Tomasa Rodriguez Hdez.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private boolean disponible;
    /**
     * Constructor de Libro.
     * @param titulo título del libro
     * @param autor autor del libro
     * @param codigo código identificador del libro
     */
    public Libro(String titulo, String autor, String codigo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacio.");
        }
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacio.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        // Todo libro nuevo comienza disponible.
        this.disponible = true;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacio.");
        }
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío.");
        }
        this.autor = autor;
    }
    public String getCodigo() {
        return codigo;
    }
    public boolean isDisponible() {
        return disponible;
    }
    //Marca el libro como prestado.
    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El libro ya está prestado.");
        }
        disponible = false;
    }
    //Marca el libro como disponible.
    public void devolver() {
        disponible = true;
    }
    /**
     * Devuelve una descripción del libro.
     * @return información del libro
     */
    public String obtenerInformacion() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Codigo: " + codigo
                + "\nTitulo: " + titulo
                + "\nAutor: " + autor
                + "\nEstado: " + estado;
    }
}