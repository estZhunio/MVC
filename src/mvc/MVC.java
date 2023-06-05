package mvc;

import mvc.controlador.ControladorMenuPrincipal;
import mvc.vista.MenuPrincipal;

/**
 *
 * @author Zhunio
 */
public class MVC {

    public static void main(String[] args) {
               
        ControladorMenuPrincipal principal = new ControladorMenuPrincipal(new MenuPrincipal());
        principal.IniciarControl();
        
        
    }
    
}
