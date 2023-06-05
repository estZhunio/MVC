package mvc.controlador;

import javax.swing.JOptionPane;
import mvc.vista.VistaPersona;
import mvc.vista.VistaProducto;

/**
 *
 * @author Zhunio
 */
public class Validacion {
   
    public static boolean validarCampos(VistaPersona vista) {
        
        if (!(vista.getTxtId().getText().matches("\\d{10,15}"))) {
            JOptionPane.showMessageDialog(vista, "ID INCORRECTO");
            return false;
        }
        
        if (!(vista.getTxtNombre().getText().matches("^[A-Z][a-zA-Z]{0,49}$"))) {
            JOptionPane.showMessageDialog(vista, "NOMBRE INCORRECTO");
            return false;
        }
        
        if (!(vista.getTxtApellido().getText().matches("^[A-Z][a-zA-Z]{0,49}$"))) {
            JOptionPane.showMessageDialog(vista, "APELLIDO INCORRECTO");
            return false;
        }
        
        if (vista.getJdcFecha().getDate() == null) {
            JOptionPane.showMessageDialog(vista, "DIGITE UNA FECHA ");
            return false;
        }
        if (!vista.getTxtTelefono().getText().equals("")) {
            if (!(vista.getTxtTelefono().getText().matches("\\d{10,20}"))) {
                JOptionPane.showMessageDialog(vista, "TELEFONO INCORRECTO");
                return false;
            }
        }
        
        
        if (vista.getBgSexo().getSelection() == null) {
            JOptionPane.showMessageDialog(vista, "DIGITE UN SEXO");
            return false;
        }
        if (!(vista.getTxtSueldo().getText().matches("^\\d+(\\.\\d{1,2})?$"))) {
            JOptionPane.showMessageDialog(vista, "SUELDO INCORRECTO, \"RECUERDE ESTE CAMPO RECIBE VALORES NUMERICOS CON 2 DECIMALES\"");
            return false;
        }
        
        if (!(vista.getTxtCorreo().getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))) {
            JOptionPane.showMessageDialog(vista, "CORREO INCORRECTO");
            return false;
        }

        return true;
    }
    
    public static boolean validarProducto(VistaProducto vista) {
        if (!(vista.getTxtNombre().getText().matches("^[A-Z][a-zA-Z]{0,49}$"))) {
            JOptionPane.showMessageDialog(vista, "NOMBRE INCORRECTO");
            return false;
        }
        
        if (!(vista.getTxtPrecio().getText().matches("^\\d+(\\.\\d{1,2})?$"))) {
            JOptionPane.showMessageDialog(vista, "PRECIO INCORRECTO, \"RECUERDE ESTE CAMPO RECIBE VALORES NUMERICOS CON 2 DECIMALES\"");
            return false;
        }
        
        
        
        return true;
    }
}
