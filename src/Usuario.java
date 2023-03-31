public class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    private String tipoUsuario;

    public Usuario(String nombreUsuario, String contrasenia, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setContrasenia(String nuevaContrasenia) {
    }
    private static void actualizarUsuario(Usuario usuario) {
    }

    static void verPerfil(String nombreUsuario) {
    }
}

