package mvc.controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import mvc.modelo.Conexion;
import mvc.vista.IngresoParametrosReporte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Zhunio
 */
public class ControladorParametroReporte {
    
    private IngresoParametrosReporte vista;

    public ControladorParametroReporte() {
    }

    public ControladorParametroReporte(IngresoParametrosReporte vista) {
        this.vista = vista;
        iniciarControl();
        
        
        vista.getBtnLimpiar().addActionListener(l -> limpiarCampos());
        vista.getBtnGenerar().addActionListener(l -> generarReporte());
    }
    
    public void iniciarControl() {
        vista.setVisible(true);
        
        
    }
    
    public void limpiarCampos() {
        vista.getTxtTituloReporte().setText("");
        vista.getTxtResponsable().setText("");
    }
    
    public void generarReporte() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/mvc/reportes/MVC_PersonaCondicional.jasper"));
            Map<String, Object> params = new HashMap<String, Object>();
           
            String titulo = vista.getTxtTituloReporte().getText();
            String responsable = vista.getTxtResponsable().getText();
            int maximo = (int)vista.getSpMaximoCupos().getValue();
            int minimo = (int)vista.getSpMinimoCupos().getValue();
            params.put("TituloReporte", titulo);
            params.put("Responsable", responsable);
            params.put("TituloReporte", titulo);
            params.put("RutaImagen", "src/mvc/reportes/icono.png");
            params.put("maximo", maximo);
            params.put("minimo", minimo);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, conectar.getCon());
            JasperViewer pv = new JasperViewer(jp, false);
            pv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pv.setVisible(true);
            vista.dispose();
        } catch (JRException ex) {
            Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
