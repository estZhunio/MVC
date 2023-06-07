package mvc.controlador;

import java.awt.Image;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static mvc.controlador.ControladorProducto.bytesPhoto;
import mvc.modelo.DetalleFactura;
import mvc.modelo.EncabezadoFactura;
import mvc.modelo.ModeloFactura;
import mvc.modelo.ModeloPersona;
import mvc.modelo.ModeloProducto;
import mvc.modelo.Persona;
import mvc.modelo.Producto;
import mvc.vista.VistaCompra;

/**
 * @author Zhunio
 */
public class ControladorFactura {
    private VistaCompra vista;
    private ModeloFactura modeloFactura;
    private ArrayList<DetalleFactura> detalles = new ArrayList<>();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    int rowSelected;
    
    public ControladorFactura(VistaCompra vista, ModeloFactura modeloFactura) {
        this.vista = vista;
        this.modeloFactura = modeloFactura;
        IniciarControl();
    }
    
    public void IniciarControl() {
        vista.setVisible(true);
        
        
        vista.getBtnBuscarPersona().addActionListener(l -> buscarPersona());
        vista.getBtnBuscarProducto().addActionListener(l -> agregaProductoProducto());
        vista.getBtnCrearFactura().addActionListener(l -> crearFactura());
        modeloTabla.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 3) {
                    int row = e.getFirstRow();
                    System.out.println(modeloTabla.getValueAt(row, 3));
                    int cantidad = Integer.parseInt((String) modeloTabla.getValueAt(row, 3));
                    double precioUnitario = (Double) modeloTabla.getValueAt(row, 2);
                    double total = cantidad * precioUnitario;
                    modeloTabla.setValueAt(total, row, 4);
                    
                    // Mostrar el total de factura
                    double sumaTotal = 0.0;
                    int rowCount = modeloTabla.getRowCount();
                    for (int i = 0; i < rowCount; i++) {
                        double totales = (Double) modeloTabla.getValueAt(i, 4);
                        sumaTotal += totales;
                    }
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    // Actualizar el JLabel con la suma total
                    vista.getLbSubtotal().setText(decimalFormat.format(sumaTotal));
                    vista.getLbTotal().setText(decimalFormat.format(sumaTotal));
                }
            }
        }); 
       
    }
    
    public void buscarPersona() {
        Persona comprador = new ModeloPersona().consultarPersona(vista.getTxtId().getText());
        System.out.println("El id que ingresastes es --> " + vista.getTxtId().getText());
        
        if (comprador != null) {
            vista.getLbCodigoFactura().setText(String.valueOf(modeloFactura.extraerUltimaFactura() + 1));
            vista.getLbRuc().setText(comprador.getIdPersona());
            vista.getLbNombre().setText(comprador.getNombre());
            vista.getLbApellido().setText(comprador.getApellido());
            vista.getLbFechaEmision().setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            
        } else {
            JOptionPane.showMessageDialog(null, "NO ESTA REGISTRADO DICHO USUARIO");
        }
        
    }
    
    public void agregaProductoProducto() {
        
        modeloTabla.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Precio", "Cantidad", "DEBE US $"});
        // modeloTabla.setRowCount(0);
        
        Producto compra = new ModeloProducto().consultarProducto(vista.getTxtNombreProducto().getText());
       
        Object[] datos = new Object[modeloTabla.getColumnCount()];
        System.out.println(compra.getIdProducto());
        if (compra.getIdProducto() != 0) {
            datos[0] = compra.getIdProducto();
            datos[1] = compra.getNombre();
            datos[2] = compra.getPrecio();
            
            modeloTabla.addRow(datos);
            vista.getTbProducto().setModel(modeloTabla);
            vista.getTxtNombreProducto().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "NO ESTA REGISTRADO DICHO PRODUCTO");
        }
    }
    
    public void crearFactura() {
        boolean error = false;
         
        if(!vista.getTxtId().getText().equals("") && modeloTabla.getRowCount() > 0) {
            
            // Crear el encabezado
            EncabezadoFactura ef = new EncabezadoFactura();
            ef.setFechaEmision(new java.sql.Date(new Date().getTime()));
            ef.setIdPersona(vista.getLbRuc().getText());
            ef.setTotal(Double.parseDouble(vista.getLbTotal().getText().replace(",", ".")));
            error = modeloFactura.crearEncabezadoFactura(ef);
            
        } else {
            JOptionPane.showMessageDialog(null, "DATOS INCOMPLETOS, VERIFIQUE QUE HAYA INSERTADO EL COMPRADOR, O EL O LOS PRODUCTOS A COMPRAR");
        }
        
        if (error) {
            int rowCount = vista.getTbProducto().getRowCount();
            DetalleFactura detalle = new DetalleFactura();
            detalle.setIdFactura(Integer.parseInt(vista.getLbCodigoFactura().getText()));
            
            for (int i = 0; i < rowCount; i++) {
                detalle.setIdProducto((int) vista.getTbProducto().getValueAt(i, 0));
                detalle.setCantidad(Integer.parseInt((String)vista.getTbProducto().getValueAt(i, 3)));
                detalle.setTotal((double) vista.getTbProducto().getValueAt(i, 4));

                error = modeloFactura.crearDetalleFactura(detalle);
                if (!error)  {
                    
                    break;
                } 
            }
        } 
        
        if (error) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
        } else {
            modeloFactura.removerEncabezadoFactura(Integer.parseInt(vista.getLbCodigoFactura().getText()));
            JOptionPane.showMessageDialog(null, "ERROR --> NO SE PUDO COMPLETAR LA ACCION DE GUARDAR");
        }
     
    }  
    
}
