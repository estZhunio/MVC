/*
 * Hace las transacciones de persona
 */
package mvc.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhunio
 */
public class ModeloPersona extends Persona{
    Conexion cpg = new Conexion();
    
    public ModeloPersona() {
        
    }
    public List<Persona> listaPersonas() {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        String sql = "SELECT idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto, correo\n" +
"	FROM public.\"Persona\";";
        ResultSet rs = cpg.consultaBD(sql);
        try {
            while(rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("idpersona"));
                persona.setNombre(rs.getString("nombres"));
                persona.setApellido(rs.getString("apellidos"));
                persona.setFechaNacimiento(rs.getDate("fechanacimiento"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(rs.getDouble("sueldo"));
                persona.setCupo(rs.getInt("cupo"));
                persona.setFoto(rs.getBytes("foto"));
                persona.setCorreo(rs.getString("correo"));
                         
                listaPersonas.add(persona);
            }  
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean crearPersona(Persona p) {
        String sql;
        sql = "INSERT INTO public.\"Persona\"(\n" +
"	idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto, correo)\n" +
"	VALUES ('"+p.getIdPersona()+"', '"+p.getNombre()+"','"+p.getApellido()+"', '"+p.getFechaNacimiento()+"', '"+p.getTelefono()
                +"', '"+p.getSexo()+"', "+p.getSueldo()+", "+p.getCupo()+", E'\\\\x"+ byteArrayToHex(p.getFoto())+"', '"+p.getCorreo()+"');";
        return cpg.accionBD(sql);
    }
    
    public Persona consultarPersona(String idpersona) {
        Persona personaEncontrada = new Persona();
        String sql = "SELECT idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto, correo\n" +
                    "FROM public.\"Persona\"\n" +
                    "WHERE idpersona = '"+ idpersona +"';";
        ResultSet rs = cpg.consultaBD(sql);
        
        
        try {
            while(rs.next()) {
                personaEncontrada.setIdPersona(rs.getString("idpersona"));
                personaEncontrada.setNombre(rs.getString("nombres"));
                personaEncontrada.setApellido(rs.getString("apellidos"));
                personaEncontrada.setFechaNacimiento(rs.getDate("fechanacimiento"));
                personaEncontrada.setTelefono(rs.getString("telefono"));
                personaEncontrada.setSexo(rs.getString("sexo"));
                personaEncontrada.setSueldo(rs.getDouble("sueldo"));
                personaEncontrada.setCupo(rs.getInt("cupo"));
                personaEncontrada.setFoto(rs.getBytes("foto"));
                personaEncontrada.setCorreo(rs.getString("correo"));    
            }
            rs.close();
            return personaEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean editarPersona(Persona p) {
        String sql = "UPDATE public.\"Persona\"\n" +
                    "SET nombres='"+p.getNombre()+"', apellidos='"+p.getApellido()+"', fechanacimiento='"+p.getFechaNacimiento()+"', telefono='"+p.getTelefono()
                    + "', sexo='"+p.getSexo()+"', sueldo= "+p.getSueldo()+", cupo="+p.getCupo()+", foto=E'\\\\x"+byteArrayToHex(p.getFoto())+"', correo='"+p.getCorreo()+"'\n" +
                    "WHERE idpersona = '"+p.getIdPersona()+"';";   
        return cpg.accionBD(sql);
    }
    
    
    public boolean removerPersona(String idpersona) {
        String sql = "DELETE FROM public.\"Persona\"\n" +
                    "WHERE idpersona = '"+idpersona+"';";   
        return cpg.accionBD(sql);
    }
    
    public String byteArrayToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        sb.append(String.format("%02X", b));
    }
    return sb.toString();
}

    
    
    
    // Crear los metodos de Crear, actualizar, eliminar y mostrar la edad en vez de la fecha de nacimiento.
}
