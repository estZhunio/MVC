package mvc.modelo;

import java.sql.Date;

/**
 *
 * @author Zhunio
 */
public class EncabezadoFactura {
    private int idEncabezadoFactura;
    private String idPersona;
    private Date fechaEmision;
    private boolean estado;
    private double total;

    public EncabezadoFactura() {
        
    }

    public EncabezadoFactura(int idEncabezadoFactura, String idPersona, Date fechaEmision, boolean estado, double total) {
        this.idEncabezadoFactura = idEncabezadoFactura;
        this.idPersona = idPersona;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.total = total;
    }

    public int getIdEncabezadoFactura() {
        return idEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(int idEncabezadoFactura) {
        this.idEncabezadoFactura = idEncabezadoFactura;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
