package mvc;

import mvc.controlador.ControladorPersonas;
import mvc.modelo.ModeloPersona;
import mvc.vista.VistaPersona;

/**
 *
 * @author Zhunio
 */
public class MVC {

    public static void main(String[] args) {
        
        ModeloPersona modelo = new ModeloPersona();
        VistaPersona vista = new VistaPersona();
        
        ControladorPersonas controlador = new ControladorPersonas(modelo, vista);
    }
    
}
