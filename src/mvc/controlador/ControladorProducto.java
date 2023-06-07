package mvc.controlador;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import mvc.modelo.ModeloProducto;
import mvc.modelo.Producto;
import mvc.vista.VistaProducto;

/**
 *
 * @author Zhunio
 */
public class ControladorProducto {
    private VistaProducto vista;
    private ModeloProducto modelo;
    
    public static byte[] bytesPhoto;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    int rowSelected;
    
    public ControladorProducto(ModeloProducto modelo, VistaProducto vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        IniciarControl();
        
    }
    
    public void IniciarControl() {
        CargarDatosTabla();
        vista.getBtnEditar().setEnabled(false);
        vista.getBtnRemover().setEnabled(false);
        vista.getTxtId().setVisible(false);
        vista.getLbIdProducto().setVisible(false);
        
        
        vista.getBtnEscoger().addActionListener(e -> escogerFoto());
       
        vista.getBtnCrear().addActionListener(e -> crearProducto());  
        
        vista.getBtnConsultar().addActionListener(e -> consultarProducto());  
                
        vista.getBtnEditar().addActionListener(e -> EditarProducto());
        
        vista.getBtnRemover().addActionListener(e -> removerProducto());  
        
        vista.getBtnImprimir().addActionListener(e -> {
            CargarDatosTabla();
            LimpiarCampos();
            vista.getTxtId().setEditable(true);
        });  
        
        vista.getTbProducto().getSelectionModel().addListSelectionListener( e -> {
            if (!e.getValueIsAdjusting()) {
                rowSelected = vista.getTbProducto().getSelectedRow();
                if (rowSelected != -1) {
                    vista.getBtnEditar().setEnabled(true);
                    vista.getBtnRemover().setEnabled(true);
                    vista.getBtnCrear().setEnabled(false);
                    vista.getBtnConsultar().setEnabled(false);
                    vista.getTxtId().setEditable(false);
                    vista.getLbIdProducto().setVisible(true);
                    vista.getTxtId().setVisible(true);
                    
                    vista.getTxtId().setText(String.valueOf(vista.getTbProducto().getValueAt(rowSelected, 0)));
                    vista.getTxtNombre().setText(String.valueOf(vista.getTbProducto().getValueAt(rowSelected, 1)));
                    vista.getTxtPrecio().setText(String.valueOf(vista.getTbProducto().getValueAt(rowSelected, 2)));
                    vista.getSpCantidad().setValue((int) vista.getTbProducto().getValueAt(rowSelected, 3));     
                    
                    bytesPhoto = (byte[]) vista.getTbProducto().getValueAt(rowSelected, 4);
                    ImageIcon imageIcon = new ImageIcon(bytesPhoto);
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);      
                    vista.getLbFoto().setIcon(new ImageIcon(scaledImage));
                    vista.getTxtDescripcion().setText(String.valueOf(vista.getTbProducto().getValueAt(rowSelected, 5)));
                                        
                } else {
                    vista.getBtnCrear().setEnabled(true);
                    vista.getBtnConsultar().setEnabled(true);
                    vista.getLbIdProducto().setVisible(false);
                    vista.getTxtId().setVisible(false);
                }
                   
            } 
        });
        
    }
    
    public void CargarDatosTabla() {
        
        modeloTabla.setColumnIdentifiers(new String[] {"Id", "Nombre", "Precio", "Cantidad", "Foto", "Descripcion", "Fecha de publicacion"});
        modeloTabla.setRowCount(0);
        
        List<Producto> registros = modelo.listaProductos();
        registros.stream().map(registro -> {
            Object[] datos = new Object[modeloTabla.getColumnCount()];
            datos[0] = registro.getIdProducto();
            datos[1] = registro.getNombre();
            datos[2] = registro.getPrecio();
            datos[3] = registro.getCantidad();
            datos[4] = registro.getFoto();
            datos[5] = registro.getDescripcion();
            datos[6] = registro.getFechaPublicacion();
            return datos;
        }).forEach(modeloTabla::addRow);
        
        vista.getTbProducto().setModel(modeloTabla);
        vista.getLbEstado().setText("Se imprimieron " + String.valueOf(modeloTabla.getRowCount()) + " registros de la base de datos");
    }
    
    public void crearProducto() {
        
        if (Validacion.validarProducto(vista)) {
            Producto nuevaProducto = extraerDatos();
            if(modelo.crearProducto(nuevaProducto)) {
                JOptionPane.showMessageDialog(vista, "GUARDADO CORRECTAMENTE");
                CargarDatosTabla();
            }
            LimpiarCampos();
        }
        
         
       
    }
    
        public void EditarProducto() {
        if (rowSelected != -1) {
            if(Validacion.validarProducto(vista)){
                Producto productoEditar = extraerDatos();
                if (modelo.editarProducto(productoEditar)) {
                    CargarDatosTabla();
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(vista, "EDITADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(vista, "OCURRIO UN PERCANCE, VERIFIQUE QUE TODOS LOS CAMPOS");
                }
            }       
            
        } else {
            JOptionPane.showMessageDialog(vista, "SELECCIONA UNA COLUMNA PARA EDITAR");
        }    
    }
        
    private void consultarProducto() {
        modeloTabla.setColumnIdentifiers(new String[] {"Id", "Nombre", "Precio", "Cantidad", "Foto", "Descripcion", "Fecha de publicacion"});
        modeloTabla.setRowCount(0);
        if (!vista.getTxtNombre().getText().equals("")) {
            if (!(modelo.consultarProducto(vista.getTxtNombre().getText()).getNombre() == null)) {
                Producto productoEncontrado = modelo.consultarProducto(vista.getTxtNombre().getText());
        
                Object[] datos = new Object[modeloTabla.getColumnCount()];
                datos[0] = productoEncontrado.getIdProducto();
                datos[1] = productoEncontrado.getNombre();
                datos[2] = productoEncontrado.getPrecio();
                datos[3] = productoEncontrado.getCantidad();
                datos[4] = productoEncontrado.getFoto();
                datos[5] = productoEncontrado.getDescripcion();
                datos[6] = productoEncontrado.getFechaPublicacion();

                modeloTabla.addRow(datos);    
                vista.getTbProducto().setModel(modeloTabla);
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "NO SE ENCONTRO NINGUN REGISTO");
            }
                
        } else {
            JOptionPane.showMessageDialog(vista, "DIGITE UN NUMERO DE ID PARA LA BUSQUEDAD");
        }
    
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
    
    
    public Producto extraerDatos() {
        Producto auxProducto = new Producto(); 
        auxProducto.setIdProducto(vista.getTxtId().getText() != null ? Integer.parseInt(vista.getTxtId().getText()) : 0);
        auxProducto.setNombre(vista.getTxtNombre().getText());
        auxProducto.setPrecio(Double.valueOf(vista.getTxtPrecio().getText()));
        auxProducto.setFechaPublicacion(new java.sql.Date(System.currentTimeMillis()));
        auxProducto.setFoto(vista.getLbFoto().getIcon() == null ? IniciarPhoto() : bytesPhoto);
        auxProducto.setCantidad((int) vista.getSpCantidad().getValue());
        auxProducto.setDescripcion(vista.getTxtDescripcion().getText());
       
        return auxProducto;
    }
    public void LimpiarCampos() {
        vista.getTxtId().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtPrecio().setText("");;
        vista.getSpCantidad().setValue(0);
        bytesPhoto = null;
        vista.getLbFoto().setIcon(null);
        vista.getTxtDescripcion().setText("");
        vista.getBtnEditar().setEnabled(false);
        vista.getBtnRemover().setEnabled(false);

        
    }
    
    public void removerProducto() {
        if (!vista.getTxtId().getText().equals("")) {
            if(modelo.removerProducto(vista.getTxtNombre().getText())) {
                JOptionPane.showMessageDialog(vista, "ELIMINADO CORRECTAMENTE");
                CargarDatosTabla();
                LimpiarCampos();
            vista.getTxtId().setEditable(true);
            } 
        } else {
            JOptionPane.showMessageDialog(vista, "DIGITE UN ID A PARA ELIMINAR");
        }
            
    }
    
    
   
    public static byte[] IniciarPhoto() {
        try {
                bytesPhoto = Files.readAllBytes(new File("C:\\Users\\Zhunio\\OneDrive\\Documentos\\NetBeansProjects\\MVC\\src\\mvc\\vista\\icons\\productoAnonimo.jpg").toPath());
                return bytesPhoto;
        } catch (IOException ex) {
                Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
}
