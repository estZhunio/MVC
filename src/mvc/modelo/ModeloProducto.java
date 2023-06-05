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
public class ModeloProducto {
    Conexion cpg = new Conexion();
    
    public ModeloProducto() {
        
    }
    public List<Producto> listaProductos() {
        List<Producto> listaProducto= new ArrayList<>();
        String sql = "SELECT \"idProducto\", nombre, precio, cantidad, foto, descripcion, \"fechaPublicacion\"\n" +
"	FROM public.\"Producto\";";
        ResultSet rs = cpg.consultaBD(sql);
        try {
            while(rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFoto(rs.getBytes("foto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                         
                listaProducto.add(producto);
            }  
            rs.close();
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean crearProducto(Producto p) {
        String sql;
        sql = "INSERT INTO public.\"Producto\"(\n" +
"	nombre, precio, cantidad, foto, descripcion, \"fechaPublicacion\")\n" +
"	VALUES ('" + p.getNombre() + "', " + p.getPrecio() + ", " + p.getCantidad() +", E'\\\\x" + byteArrayToHex(p.getFoto())+ 
                "', '" + p.getDescripcion() + "', '" + p.getFechaPublicacion() + "');";  
        return cpg.accionBD(sql);
    }
    
    public boolean removerProducto(String nombre) {
        String sql = "DELETE FROM public.\"Producto\"\n" +
            "WHERE \"nombre\" = '" + nombre + "';";   
        return cpg.accionBD(sql);
    }
    
    public boolean editarProducto(Producto p) {
        String sql = "UPDATE public.\"Producto\"\n" +
                "SET nombre= '"+ p.getNombre() +"', precio= " + p.getPrecio() + ", cantidad= " + p.getCantidad() +
                ", foto= E'\\\\x"+ byteArrayToHex(p.getFoto()) +"', descripcion= '"+p.getDescripcion()+"', \"fechaPublicacion\"= '"
                +p.getFechaPublicacion()+"'\n" +
                "WHERE \"idProducto\" = " + p.getIdProducto() + ";";   
        return cpg.accionBD(sql);
    }
    
        public Producto consultarProducto(String nombre) {
        Producto productoEncontrado = new Producto();
        String sql = "SELECT \"idProducto\", nombre, precio, cantidad, foto, descripcion, \"fechaPublicacion\"\n" +
                        "FROM public.\"Producto\"\n" +
                        "WHERE nombre = '" + nombre + "';";
        ResultSet rs = cpg.consultaBD(sql);   
        
        try {
            while(rs.next()) {
                productoEncontrado.setIdProducto(rs.getInt("idProducto"));
                productoEncontrado.setNombre(rs.getString("nombre"));
                productoEncontrado.setPrecio(rs.getDouble("precio"));
                productoEncontrado.setCantidad(rs.getInt("cantidad"));
                productoEncontrado.setFoto(rs.getBytes("foto"));
                productoEncontrado.setDescripcion(rs.getString("descripcion"));
                productoEncontrado.setFechaPublicacion(rs.getDate("fechaPublicacion"));    
            }
            rs.close();
            return productoEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public String byteArrayToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
    
}
