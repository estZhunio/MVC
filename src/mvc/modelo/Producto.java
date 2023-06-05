package mvc.modelo;

import java.sql.Date;

/**
 *
 * @author Zhunio
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private Double Precio;
    private int cantidad;
    private byte[] foto;
    private String descripcion;
    private Date fechaPublicacion;
    
    public Producto() {
        
    }

    public Producto(int idProducto, String nombre, Double Precio, int cantidad, byte[] foto, String descripcion, Date fechaPublicacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.Precio = Precio;
        this.cantidad = cantidad;
        this.foto = foto;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}
