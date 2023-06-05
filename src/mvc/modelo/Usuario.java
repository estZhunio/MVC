package mvc.modelo;

/**
 *
 * @author Zhunio
 */
public class Usuario {
    private int idUsuario;
    private String idPersona;
    private String userName;
    private byte[] password;

    public Usuario() {
        
    }

    public Usuario(int idUsuario, String idPersona, String userName, byte[] password) {
        this.idUsuario = idUsuario;
        this.idPersona = idPersona;
        this.userName = userName;
        this.password = password;
    }

    public Usuario(String idPersona, String userName, byte[] password) {
        this.idPersona = idPersona;
        this.userName = userName;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }
    
}
