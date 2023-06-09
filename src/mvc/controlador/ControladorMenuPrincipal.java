package mvc.controlador;

import mvc.modelo.ModeloFactura;
import mvc.modelo.ModeloPersona;
import mvc.modelo.ModeloProducto;
import mvc.vista.MenuPrincipal;
import mvc.vista.VistaCompra;
import mvc.vista.VistaPersona;
import mvc.vista.VistaProducto;
import mvc.vista.VistaReporte;







/**
 * @author Zhunio
 */
public class ControladorMenuPrincipal {
    private MenuPrincipal menuPrincipal;
    
    public ControladorMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        menuPrincipal.setVisible(true);
    }
    public void IniciarControl() {
        menuPrincipal.getMnMantenimientoClientes().addActionListener(l -> mostrarMenuPersona());
        menuPrincipal.getMnMantenimientoProductos().addActionListener(l -> mostrarMenuProducto());
        menuPrincipal.getMnCompra().addActionListener(l -> mostrarMenuComprar());
        menuPrincipal.getMnReportes().addActionListener(l -> mostrarMenuReporte());
              
    }
    
    public void mostrarMenuPersona() {
        menuPrincipal.getPnInternalFrame().removeAll();
        VistaPersona vistaPersona =  new VistaPersona();
        ModeloPersona modeloPersona = new ModeloPersona();
        menuPrincipal.getPnInternalFrame().add(vistaPersona);
        ControladorPersonas controlador = new ControladorPersonas(modeloPersona, vistaPersona);  
    }
    
    public void mostrarMenuProducto() {
        menuPrincipal.getPnInternalFrame().removeAll();
        VistaProducto vistaProducto =  new VistaProducto();
        ModeloProducto modeloProducto = new ModeloProducto();
        menuPrincipal.getPnInternalFrame().add(vistaProducto);
        ControladorProducto controlador = new ControladorProducto(modeloProducto, vistaProducto);  
    }
    
    public void mostrarMenuComprar() {
        menuPrincipal.getPnInternalFrame().removeAll();
        VistaCompra vistaCompra =  new VistaCompra();
        ModeloFactura modeloFactura = new ModeloFactura();
        menuPrincipal.getPnInternalFrame().add(vistaCompra);
        ControladorFactura controlador = new ControladorFactura(vistaCompra, modeloFactura);  
    }
    
    public void mostrarMenuReporte() {
        menuPrincipal.getPnInternalFrame().removeAll();
        VistaReporte vistaFactura =  new VistaReporte();
        ModeloFactura modeloFactura = new ModeloFactura();
        menuPrincipal.getPnInternalFrame().add(vistaFactura);
        ControladorReporte controlador = new ControladorReporte(vistaFactura, modeloFactura);  
    }
    
    
    
    
    
}
