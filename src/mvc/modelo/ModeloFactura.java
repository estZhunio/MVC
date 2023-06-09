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
    
    public EncabezadoFactura consultarFactura(int idFactura) {
        EncabezadoFactura FacturaEncontrada = new EncabezadoFactura();
        String sql = "SELECT \"idFactura\", fechaemision, total, \"idPersona\"\n" +
                    "FROM public.\"EncabezadoFactura\"\n" +
                    "WHERE \"idFactura\" = "+ idFactura +" AND \"Activo\" = true;";
        ResultSet rs = cpg.consultaBD(sql);   
        
        try {
            while(rs.next()) {
                FacturaEncontrada.setIdEncabezadoFactura(rs.getInt("idFactura"));
                FacturaEncontrada.setIdPersona(rs.getString("idPersona"));
                FacturaEncontrada.setFechaEmision(rs.getDate("fechaemision"));
                FacturaEncontrada.setTotal(rs.getDouble("total"));                  
            }
            rs.close();
            return FacturaEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean removerEncabezadoFactura(int idEncabezadoFactura) {
        String sql = "UPDATE public.\"EncabezadoFactura\"\n" +
                        "SET \"Activo\"= false\n" +
                        "WHERE \"idFactura\" = "+ idEncabezadoFactura +";";
        
        return cpg.accionBD(sql);
    }
    
    public List<EncabezadoFactura> listaFacturas() {
        List<EncabezadoFactura> listaFacturas = new ArrayList<>();
        String sql = "SELECT \"idFactura\", fechaemision, total, \"Activo\", \"idPersona\"\n" +
                    "FROM public.\"EncabezadoFactura\"\n" +
                    "WHERE \"Activo\" = true;";
        ResultSet rs = cpg.consultaBD(sql);
        try {
            while(rs.next()) {
                EncabezadoFactura factura = new EncabezadoFactura();
                factura.setIdEncabezadoFactura(rs.getInt("idFactura"));
                factura.setIdPersona(rs.getString("idPersona"));
                factura.setFechaEmision(rs.getDate("fechaemision"));
                factura.setTotal(rs.getDouble("total"));       
                         
                listaFacturas.add(factura);
            }  
            rs.close();
            return listaFacturas;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
