package mvc.controlador;

import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static mvc.controlador.ControladorPersonas.bytesPhoto;
import mvc.modelo.ModeloUsuario;
import mvc.modelo.Persona;
import mvc.modelo.Usuario;
import mvc.vista.VistaUsuario;

/**
 *
 * @author Zhunio
 */
public class ControladorUsuario {
    private ModeloUsuario modelo;
    private VistaUsuario vista;
    private String idPersona;

    public ControladorUsuario(ModeloUsuario modelo, VistaUsuario vista, String idPersona) {
        this.modelo = modelo;
        this.vista = vista;
        this.idPersona = idPersona;
    }
    
    public void IniciarControl() {
        vista.setVisible(true);
        MostrarPhoto();
        
        vista.getBtnAceptar().addActionListener(l -> crearUsuario());
        vista.getBtnCancelar().addActionListener(l -> vista.setVisible(false));
        
    }
    
    public boolean crearUsuario() {
        Usuario nuevoUsuario;
        try {
            nuevoUsuario = new Usuario(idPersona, vista.getTxtUserName().getText(), new String(vista.getTxtPassword().getPassword()).getBytes("UTF-8"));
            return modelo.crearUsuario(nuevoUsuario);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    
    
    public void MostrarPhoto() {
        
        ImageIcon imageIcon = new ImageIcon(bytesPhoto);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(vista.getLbPhoto().getWidth(), vista.getLbPhoto().getHeight(), Image.SCALE_DEFAULT);      
        vista.getLbPhoto().setIcon(new ImageIcon(scaledImage)); 
        
    }
    
    
    
    
}
