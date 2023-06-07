package mvc.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhunio
 */
public class ModeloFactura {
    
    Conexion cpg = new Conexion();
    
    public boolean crearEncabezadoFactura(EncabezadoFactura ef) {
        String sql;
        sql = "INSERT INTO public.\"EncabezadoFactura\"(\n" +
                "fechaemision, total, \"Activo\", \"idPersona\")\n" +
                "VALUES ('"+ ef.getFechaEmision() +"', " + ef.getTotal() +", "+ true +", '"+ ef.getIdPersona() +"');";  
        return cpg.accionBD(sql);
    }
    
    public boolean crearDetalleFactura(DetalleFactura df) {
        String sql;
        sql = "INSERT INTO public.\"DetalleFactura\"(\n" +
                "\"idFactura\", \"idProducto\", cantidad, total)\n" +
                "VALUES ("+ df.getIdFactura() +", "+ df.getIdProducto() +", " + df.getCantidad() + ", "+ df.getTotal() +");";  
        return cpg.accionBD(sql);
    }
    
    
    
    public int extraerUltimaFactura(){
        String sql = "SELECT MAX(\"idFactura\") AS ultima_factura FROM\"EncabezadoFactura\";";
        ResultSet rs = cpg.consultaBD(sql); 
        try {
            if (rs.next()) {
                return rs.getInt("ultima_factura");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean removerEncabezadoFactura(int idEncabezadoFactura) {
        String sql = "DELETE FROM public.\"EncabezadoFactura\"\n" +
                    "WHERE \"idFactura\" = " + idEncabezadoFactura + ";";
        
        return cpg.accionBD(sql);
    }
    
    
}
