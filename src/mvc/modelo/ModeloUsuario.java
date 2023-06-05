package mvc.modelo;

/**
 *
 * @author Zhunio
 */
public class ModeloUsuario {
    
    Conexion cpg = new Conexion();
    
    public boolean crearUsuario(Usuario u) {
        String sql;
        sql = "INSERT INTO public.\"Usuario\"(\n" +
                "username, miclave, \"idPersona\")\n" +
                "VALUES ('"+u.getUserName()+"', E'\\\\x"+ ModeloPersona.byteArrayToHex(u.getPassword())+"', '"+u.getIdPersona()+"');";
        return cpg.accionBD(sql);
    }
    
}
