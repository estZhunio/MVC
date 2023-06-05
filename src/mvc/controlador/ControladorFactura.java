package mvc.controlador;

import java.util.Date;
import java.text.SimpleDateFormat;
import mvc.modelo.ModeloFactura;
import mvc.modelo.ModeloPersona;
import mvc.modelo.Persona;
import mvc.vista.VistaCompra;

/**
 * @author Zhunio
 */
public class ControladorFactura {
    private VistaCompra vista;
    private ModeloFactura modeloFactura;
    
    public ControladorFactura(VistaCompra vista, ModeloFactura modeloFactura) {
        this.vista = vista;
        this.modeloFactura = modeloFactura;
        IniciarControl();
    }
    
    public void IniciarControl() {
        vista.setVisible(true);
        vista.getBtnBuscar().addActionListener(l -> buscarPersona());
    }
    
    public void buscarPersona() {
        ModeloPersona modelopersona = new ModeloPersona();
        Persona personaFacturnado = modelopersona.consultarPersona(vista.getTxtId().getText());
        if (personaFacturnado.getIdPersona() != null) {
            vista.getLbRuc().setText(personaFacturnado.getIdPersona());
            vista.getLbNombre().setText(personaFacturnado.getNombre());
            vista.getLbApellido().setText(personaFacturnado.getApellido());
            vista.getLbFechaEmision().setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            
            
        }
        
    }
    
    
    
}
