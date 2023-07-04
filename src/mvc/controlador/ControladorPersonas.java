 package mvc.controlador;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import mvc.modelo.Conexion;
import mvc.modelo.ModeloPersona;
import mvc.modelo.Persona;
import mvc.vista.IngresoParametrosReporte;
import mvc.vista.VistaPersona;
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
public class ControladorPersonas {
    private static ModeloPersona modelo;
    private static VistaPersona vista;

    public static byte[] bytesPhoto;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    int rowSelected;
    
    
    public ControladorPersonas(ModeloPersona modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        IniciarControl();
        
    }
    
    public void IniciarControl() {
        CargarDatosTabla();
        vista.getBtnEditar().setEnabled(false);
        vista.getBtnRemover().setEnabled(false);
        
        
        vista.getBtnEscoger().addActionListener(e -> escogerFoto());
       
        vista.getBtnCrear().addActionListener(e -> crearPersona());  
        
        vista.getBtnConsultar().addActionListener(e -> consultarPersona());  
                
        vista.getBtnEditar().addActionListener(e -> EditarPersona());
        
        vista.getBtnRemover().addActionListener(e -> removerPersona()); 
        
        vista.getBtnReporte().addActionListener(l -> reportePersona());
        
        vista.getBtnImprimir().addActionListener(e -> {
            reporteCondicional();
        });  
        
        vista.getTbPersona().getSelectionModel().addListSelectionListener( e -> {
            if (!e.getValueIsAdjusting()) {
                rowSelected = vista.getTbPersona().getSelectedRow();
                if (rowSelected != -1) {
                    vista.getBtnEditar().setEnabled(true);
                    vista.getBtnRemover().setEnabled(true);
                    vista.getBtnCrear().setEnabled(false);
                    vista.getBtnConsultar().setEnabled(false);
                    
                    vista.getTxtId().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 0)));
                    vista.getTxtId().setEditable(false);
                    vista.getTxtNombre().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 1)));
                    vista.getTxtApellido().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 2)));
                    vista.getJdcFecha().setDate((Calendar.getInstance()).getTime());
                    vista.getTxtTelefono().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 4)));
                    JRadioButton escogido = String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 5)).equals("Masculino")? vista.getRbMasculino(): vista.getRbFemenino();
                    escogido.setSelected(true);
                    vista.getTxtSueldo().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 6)));
                    vista.getSpCupo().setValue((int) vista.getTbPersona().getValueAt(rowSelected, 7));   
                    
                    bytesPhoto = (byte[]) vista.getTbPersona().getValueAt(rowSelected, 8);
                    ImageIcon imageIcon = new ImageIcon(bytesPhoto);
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);      
                    vista.getLbFoto().setIcon(new ImageIcon(scaledImage));
           
                    vista.getTxtCorreo().setText(String.valueOf(vista.getTbPersona().getValueAt(rowSelected, 9)));
                    vista.getJdcFecha().setDate((java.util.Date) vista.getTbPersona().getValueAt(rowSelected, 10));
                    
                } else {
                    vista.getBtnCrear().setEnabled(true);
                    vista.getBtnConsultar().setEnabled(true);
                }
                   
            } 
        });
        
    }
    
    
    public void CargarDatosTabla() {
        
        modeloTabla.setColumnIdentifiers(new String[] {"Id", "Nombre", "Apellido", "Edad", "Telefono", "Sexo", "Sueldo", "Cupo", "Foto", "Correo", "Fecha de nacimiento"});
        modeloTabla.setRowCount(0);
        
        List<Persona> registros = modelo.listaPersonas();
        registros.stream().map(registro -> {
            Object[] datos = new Object[modeloTabla.getColumnCount()];
            datos[0] = registro.getIdPersona();
            datos[1] = registro.getNombre();
            datos[2] = registro.getApellido();
            datos[3] = Period.between(registro.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears();
            datos[4] = registro.getTelefono();
            datos[5] = registro.getSexo();
            datos[6] = registro.getSueldo();
            datos[7] = registro.getCupo();
            datos[8] = registro.getFoto();
            datos[9] = registro.getCorreo();
            datos[10] = registro.getFechaNacimiento();
            
            return datos;
        }).forEach(modeloTabla::addRow);
        
        vista.getTbPersona().setModel(modeloTabla);
        vista.getLbEstado().setText("Se imprimieron " + String.valueOf(modeloTabla.getRowCount()) + " registros de la base de datos");
    }
    
    public void escogerFoto() {
        JFileChooser viewPhoto = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        viewPhoto.setFileFilter(filtro);
        
        
        int respuesta = viewPhoto.showOpenDialog(vista);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            
            try {
                Image icono = ImageIO.read(viewPhoto.getSelectedFile()).getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLbFoto().setIcon(new ImageIcon(icono));
                bytesPhoto = Files.readAllBytes(viewPhoto.getSelectedFile().toPath());
            } catch (IOException ex) {
                Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
    } 
    
    public void crearPersona() {
        
        if (Validacion.validarCampos(vista)) {
            Persona nuevaPersona = extraerDatos();
            if(modelo.crearPersona(nuevaPersona)) {        
                JOptionPane.showMessageDialog(vista, "GUARDADO CORRECTAMENTE");
                CargarDatosTabla();
            } 
            LimpiarCampos();
        }   
       
    }
    
    public void LimpiarCampos() {
        vista.getTxtId().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getJdcFecha().setDate((Calendar.getInstance()).getTime());
        vista.getTxtTelefono().setText("");
        vista.getBgSexo().clearSelection();
        vista.getSpCupo().setValue(0);
        vista.getTxtSueldo().setText("");  
        vista.getTxtCorreo().setText("");
        
        bytesPhoto = null;
        vista.getLbFoto().setIcon(null);
        vista.getBtnEditar().setEnabled(false);
        vista.getBtnRemover().setEnabled(false);

        
    }
    public void EditarPersona() {
        if (rowSelected != -1) {
            if(Validacion.validarCampos(vista)){
                Persona personaEditar = extraerDatos();
                if (modelo.editarPersona(personaEditar)) {
                    CargarDatosTabla();
                    LimpiarCampos();
                    vista.getTxtId().setEditable(true);
                    JOptionPane.showMessageDialog(vista, "EDITADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(vista, "OCURRIO UN PERCANCE, VERIFIQUE QUE TODOS LOS CAMPOS");
                }
            }       
            
        } else {
            JOptionPane.showMessageDialog(vista, "SELECCIONA UNA COLUMNA PARA EDITAR");
        }    
    }
    
    private void consultarPersona() {
        modeloTabla.setColumnIdentifiers(new String[] {"Id", "Nombre", "Apellido", "Edad", "Telefono", "Sexo", "Sueldo", "Cupo", "Foto", "Correo", "Fecha de nacimiento"});
        modeloTabla.setRowCount(0);
        if (!vista.getTxtId().getText().equals("")) {
            if (!(modelo.consultarPersona(vista.getTxtId().getText()).getIdPersona() == null)) {
                Persona PersonaEncontrada = modelo.consultarPersona(vista.getTxtId().getText());
        
                Object[] datos = new Object[modeloTabla.getColumnCount()];
                datos[0] = PersonaEncontrada.getIdPersona();
                datos[1] = PersonaEncontrada.getNombre();
                datos[2] = PersonaEncontrada.getApellido();
                datos[3] = Period.between(PersonaEncontrada.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears();
                datos[4] = PersonaEncontrada.getTelefono();
                datos[5] = PersonaEncontrada.getSexo();
                datos[6] = PersonaEncontrada.getSueldo();
                datos[7] = PersonaEncontrada.getCupo();
                datos[8] = PersonaEncontrada.getFoto();
                datos[9] = PersonaEncontrada.getCorreo();
                datos[10] = PersonaEncontrada.getFechaNacimiento();

                modeloTabla.addRow(datos);    
                vista.getTbPersona().setModel(modeloTabla);
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "NO SE ENCONTRO NINGUN REGISTO");
            }
            
            
        } else {
            JOptionPane.showMessageDialog(vista, "DIGITE UN NUMERO DE ID PARA LA BUSQUEDAD");
        }
        
        
    }
    
    
    public Persona extraerDatos() {
        Persona auxPersona = new Persona();
        auxPersona.setIdPersona(vista.getTxtId().getText());
        auxPersona.setNombre(vista.getTxtNombre().getText());
        auxPersona.setApellido(vista.getTxtApellido().getText());
        auxPersona.setFechaNacimiento(new Date((long) vista.getJdcFecha().getDate().getTime()));
        auxPersona.setTelefono(vista.getTxtTelefono().getText());
        auxPersona.setSexo(vista.getRbMasculino().isSelected()? "Masculino": "Femenino");
        auxPersona.setCupo((int) vista.getSpCupo().getValue());
        auxPersona.setSueldo(Double.parseDouble(vista.getTxtSueldo().getText()));
        auxPersona.setFoto(vista.getLbFoto().getIcon() == null? iniciarPhoto(): bytesPhoto);
        auxPersona.setCorreo(vista.getTxtCorreo().getText());
        
        return auxPersona;
    }
    
    public void removerPersona() {
        if (!vista.getTxtId().getText().equals("")) {
            if(modelo.removerPersona(vista.getTxtId().getText())) {
            JOptionPane.showMessageDialog(vista, "ELIMINADO CORRECTAMENTE");
            CargarDatosTabla();
            LimpiarCampos();
            vista.getTxtId().setEditable(true);
            } 
        } else {
            JOptionPane.showMessageDialog(vista, "DIGITE UN ID A PARA ELIMINAR");
        }
            
    }
    
    public void reportePersona() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/mvc/reportes/Persona_MVC.jasper"));
            Map<String, Object> params = new HashMap<String, Object>();
            String aguja = vista.getTxtId().getText();
            params.put("idpersona", aguja);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, conectar.getCon());
            JasperViewer pv = new JasperViewer(jp, false);
            pv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteCondicional(){
        ControladorParametroReporte controlador = new ControladorParametroReporte(new IngresoParametrosReporte());
    }    

    
    public static byte[] iniciarPhoto() {
        try {
                bytesPhoto = Files.readAllBytes(new File("../mvc/icons/anonimo.png").toPath());
                return bytesPhoto;
        } catch (IOException ex) {
                Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
     
}
