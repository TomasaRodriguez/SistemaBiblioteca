package sistemabiblioteca;
import javax.swing.*;
import java.awt.*;
/**
 * Ventana principal del Sistema de Gestión de Biblioteca.
 * Permite interactuar visualmente con el TDA Biblioteca.
 * Autor: Tomasa Rodriguez Hdez.
 */
public class VentanaPrincipal extends JFrame {
    // TDA principal del sistema.
    private Biblioteca biblioteca;
    // Campos para libros.
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCodigo;
    // Campos para usuarios.
    private JTextField txtNombreUsuario;
    private JTextField txtIdentificacion;
    private JTextField txtCarrera;
    // Área donde se muestran los resultados.
    private JTextArea areaResultado;
    // Constructor de la ventana.
    public VentanaPrincipal() {
        biblioteca = new Biblioteca(
                "Biblioteca Escolar de la Universidad Tecnológica de la Huasteca Hidalguense"
        );
        configurarVentana();
        crearComponentes();
    }
    // Configura las características principales de la ventana.
    private void configurarVentana() {
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    // Crea y organiza los componentes gráficos.
    private void crearComponentes() {
        setLayout(new BorderLayout(10, 10));
        // ENCABEZADO
        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setLayout(new BoxLayout(
                panelEncabezado,
                BoxLayout.Y_AXIS
        ));
        JLabel titulo = new JLabel(
                "SISTEMA DE GESTIÓN DE BIBLIOTECA"
        );
        titulo.setFont(new Font(
                "Arial",
                Font.BOLD,
                26
        ));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel autor = new JLabel(
                "Autor: Tomasa Rodriguez Hdez."
        );
        autor.setFont(new Font(
                "Arial",
                Font.PLAIN,
                15
        ));
        autor.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelEncabezado.add(titulo);
        panelEncabezado.add(Box.createVerticalStrut(5));
        panelEncabezado.add(autor);
        add(panelEncabezado, BorderLayout.NORTH);
        // FORMULARIO
        JPanel panelFormulario = new JPanel(
                new GridLayout(6, 2, 8, 8)
        );
        panelFormulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Datos del sistema"
                )
        );
        panelFormulario.add(new JLabel("Título del libro:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);
        panelFormulario.add(new JLabel("Autor del libro:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);
        panelFormulario.add(new JLabel("Código del libro:"));
        txtCodigo = new JTextField();
        panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombre del usuario:"));
        txtNombreUsuario = new JTextField();
        panelFormulario.add(txtNombreUsuario);
        panelFormulario.add(new JLabel("Identificación:"));
        txtIdentificacion = new JTextField();
        panelFormulario.add(txtIdentificacion);
        panelFormulario.add(new JLabel("Carrera:"));
        txtCarrera = new JTextField();
        panelFormulario.add(txtCarrera);
        JPanel panelIzquierdo = new JPanel(
                new BorderLayout()
        );
        panelIzquierdo.add(
                panelFormulario,
                BorderLayout.NORTH
        );
        add(panelIzquierdo, BorderLayout.WEST);
        // ÁREA DE RESULTADOS
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font(
                "Monospaced",
                Font.PLAIN,
                14
        ));
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(
                areaResultado
        );
        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Información"
                )
        );
        add(scroll, BorderLayout.CENTER);
        // BOTONES
        JPanel panelBotones = new JPanel(
                new GridLayout(2, 4, 8, 8)
        );
        JButton btnRegistrarLibro =
                new JButton("Registrar libro");
        JButton btnRegistrarUsuario =
                new JButton("Registrar usuario");
        JButton btnPrestar =
                new JButton("Prestar libro");
        JButton btnDevolver =
                new JButton("Devolver libro");
        JButton btnBuscar =
                new JButton("Buscar libro");
        JButton btnDisponibles =
                new JButton("Libros disponibles");
        JButton btnResumen =
                new JButton("Mostrar resumen");
        JButton btnLimpiar =
                new JButton("Limpiar");
        panelBotones.add(btnRegistrarLibro);
        panelBotones.add(btnRegistrarUsuario);
        panelBotones.add(btnPrestar);
        panelBotones.add(btnDevolver);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnDisponibles);
        panelBotones.add(btnResumen);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);
        // EVENTOS DE LOS BOTONES
        btnRegistrarLibro.addActionListener(e ->
                registrarLibro()
        );
        btnRegistrarUsuario.addActionListener(e ->
                registrarUsuario()
        );
        btnPrestar.addActionListener(e ->
                prestarLibro()
        );
        btnDevolver.addActionListener(e ->
                devolverLibro()
        );
        btnBuscar.addActionListener(e ->
                buscarLibro()
        );
        btnDisponibles.addActionListener(e ->
                mostrarDisponibles()
        );
        btnResumen.addActionListener(e ->
                mostrarResumen()
        );
        btnLimpiar.addActionListener(e ->
                limpiarCampos()
        );
        // Mensaje inicial.
        areaResultado.setText(
                "Bienvenido al Sistema de Gestión de Biblioteca.\n\n"
                + "Utiliza los botones para registrar usuarios, "
                + "registrar libros, realizar préstamos, devoluciones "
                + "y consultas."
        );
    }
    // Registra un nuevo libro.
    private void registrarLibro() {
        try {
            Libro libro = new Libro(
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    txtCodigo.getText()
            );
            biblioteca.registrarLibro(libro);
            areaResultado.setText(
                    "Libro registrado correctamente.\n\n"
                    + libro.obtenerInformacion()
            );
            limpiarCamposLibro();
        } catch (Exception ex) {
            mostrarError(ex.getMessage());
        }
    }
    // Registra un nuevo usuario.
    private void registrarUsuario() {
        try {
            Usuario usuario = new Usuario(
                    txtNombreUsuario.getText(),
                    txtIdentificacion.getText(),
                    txtCarrera.getText()
            );
            biblioteca.registrarUsuario(usuario);
            areaResultado.setText(
                    "Usuario registrado correctamente.\n\n"
                    + usuario.obtenerInformacion()
            );
            limpiarCamposUsuario();
        } catch (Exception ex) {
            mostrarError(ex.getMessage());
        }
    }
    // Realiza el préstamo de un libro.
    private void prestarLibro() {
        try {
            biblioteca.prestarLibro(
                    txtCodigo.getText(),
                    txtIdentificacion.getText()
            );
            areaResultado.setText(
                    "Préstamo realizado correctamente.\n\n"
                    + "Código del libro: "
                    + txtCodigo.getText()
                    + "\nIdentificación del usuario: "
                    + txtIdentificacion.getText()
            );
        } catch (Exception ex) {
            mostrarError(ex.getMessage());
        }
    }
    // Realiza la devolución de un libro.
    private void devolverLibro() {
        try {
            biblioteca.devolverLibro(
                    txtCodigo.getText()
            );
            areaResultado.setText(
                    "Libro devuelto correctamente.\n\n"
                    + biblioteca.buscarLibro(
                            txtCodigo.getText()
                    ).obtenerInformacion()
            );
        } catch (Exception ex) {
            mostrarError(ex.getMessage());
        }
    }
    // Busca un libro por código.
    private void buscarLibro() {
        Libro libro = biblioteca.buscarLibro(
                txtCodigo.getText()
        );
        if (libro != null) {
            areaResultado.setText(
                    "LIBRO ENCONTRADO\n\n"
                    + libro.obtenerInformacion()
            );
        } else {
            mostrarError("No se encontró el libro.");
        }
    }
    // Muestra todos los libros disponibles.
    private void mostrarDisponibles() {
        areaResultado.setText(
                "LIBROS DISPONIBLES\n\n"
                + biblioteca.mostrarLibrosDisponibles()
        );
    }
    // Muestra el resumen general de la biblioteca.
    private void mostrarResumen() {
        areaResultado.setText(
                "RESUMEN DE LA BIBLIOTECA\n\n"
                + biblioteca.obtenerResumen()
        );
    }
    // Limpia todos los campos.
    private void limpiarCampos() {
        limpiarCamposLibro();
        limpiarCamposUsuario();
        areaResultado.setText("");
    }
    // Limpia los campos relacionados con libros.
    private void limpiarCamposLibro() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
    }
    // Limpia los campos relacionados con usuarios.
    private void limpiarCamposUsuario() {
        txtNombreUsuario.setText("");
        txtIdentificacion.setText("");
        txtCarrera.setText("");
    }
    /**
     * Muestra un mensaje de error.
     * @param mensaje mensaje que se mostrará
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    // Método principal para iniciar la aplicación.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana =
                    new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}