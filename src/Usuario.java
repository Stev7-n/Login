import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> obtenerHistorialCompras(int opcion) {
        List<String> historial = new ArrayList<String>();
        try {
            File archivo = new File("compras.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (opcion == 1 && campos[1].equals(this.nombreUsuario)) {
                    historial.add(linea);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar leer el archivo de compras");
            e.printStackTrace();
        }
        return historial;
    }

    public List<Compra> getHistorialCompras() {
        return menus.leerComprasUsuario(Compra.nombreUsuarioCompra);
    }


}
