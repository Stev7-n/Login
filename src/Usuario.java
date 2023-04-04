import java.io.FileWriter;
import java.io.IOException;

public class Usuario {
    private static String nombreUsuario;
    private String contrasenia;
    private String tipoUsuario;

    public Usuario(String nombreUsuario, String contrasenia, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void agregarCompra(Producto productoEncontrado, int cantidadComprar, double totalCompra)
            throws IOException, IOException {
        try {
            FileWriter archivo = new FileWriter("compras.txt", true);
            archivo.write(Usuario.getNombreUsuario() + ", " + productoEncontrado.getNombreProducto()
                    + ", " + cantidadComprar + ", " + totalCompra + "\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}

