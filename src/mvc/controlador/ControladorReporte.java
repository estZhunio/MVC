package mvc.controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mvc.modelo.EncabezadoFactura;
import mvc.modelo.ModeloFactura;
import mvc.vista.VistaReporte;

/**
 *
 * @author Zhunio
 */
public class ControladorReporte {
    private VistaReporte vista = new VistaReporte();
    private ModeloFactura modelo = new ModeloFactura();
    private int rowSelected;
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public ControladorReporte() {
        
    }
    
    public ControladorReporte(VistaReporte vista, ModeloFactura modelo) {
        this.vista = vista;
        this.modelo = modelo;
        IniciarControl();
    }    

    public void IniciarControl() {
        vista.setVisible(true);
        vista.getBtnEliminar().setEnabled(false);
        cargarDatos(0);
        
        vista.getBtnEliminar().addActionListener(l -> eliminarFactura());
        vista.getCbOrdenar().addItemListener(l -> cargarDatos(vista.getCbOrdenar().getSelectedIndex()));
        vista.getBtnBuscar().addActionListener(l -> buscarFactura());
        vista.getBtnRefrescar().addActionListener(l -> cargarDatos(0));
        vista.getTbFacturas().getSelectionModel().addListSelectionListener( e -> {
            if (!e.getValueIsAdjusting()) {
                rowSelected = vista.getTbFacturas().getSelectedRow();
                if (rowSelected != -1) {
                    vista.getBtnEliminar().setEnabled(true);
         
                } else {
                    vista.getBtnEliminar().setEnabled(false);
                }
                   
            } 
        });
    }
    
    public void cargarDatos(int ordenamiento) {
         
        String[] titulos = {"Id Factura", "Cedula del cliente", "Fecha de emision", "Total de factura"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);
        ArrayList<EncabezadoFactura> listaFacturas = OrdenarStream((ArrayList<EncabezadoFactura>) modelo.listaFacturas(),ordenamiento);
        
        listaFacturas.stream().map(registro -> {
            Object[] datos = new Object[4];
            datos[0] = registro.getIdEncabezadoFactura();
            datos[1] = registro.getIdPersona();
            datos[2] = registro.getFechaEmision();
            datos[3] = registro.getTotal();
            return datos;
        }).forEach(modeloTabla::addRow);
        vista.getTbFacturas().setModel(modeloTabla);
    }
    
    public ArrayList<EncabezadoFactura> OrdenarStream(ArrayList<EncabezadoFactura> listaFacturas, int orden) {
        
        if (orden == 0) {
            return (ArrayList<EncabezadoFactura>) listaFacturas.stream()
                    .sorted(Comparator.comparing(EncabezadoFactura::getFechaEmision)).collect(Collectors.toList());
        } else {
            return (ArrayList<EncabezadoFactura>) listaFacturas.stream()
                    .sorted(Comparator.comparing(EncabezadoFactura::getFechaEmision).reversed()).collect(Collectors.toList());
        }
        
    }
    
    public void buscarFactura() {
        System.out.println("Codigo " + vista.getTxtCodigo().getText());
        if (!(vista.getTxtCodigo().getText()).equals("")) {
            String[] titulos = {"Id Factura", "Cedula del cliente", "Fecha de emision", "Total de factura"};
            modeloTabla.setColumnIdentifiers(titulos);
            modeloTabla.setRowCount(0);
            
            int idFactura = Integer.parseInt(vista.getTxtCodigo().getText());
            EncabezadoFactura registro = modelo.consultarFactura(idFactura);  
            if (registro.getIdEncabezadoFactura() != 0) {
            
                Object[] datos = new Object[4];
                datos[0] = registro.getIdEncabezadoFactura();
                datos[1] = registro.getIdPersona();
                datos[2] = registro.getFechaEmision();
                datos[3] = registro.getTotal();

                modeloTabla.addRow(datos);
                vista.getTbFacturas().setModel(modeloTabla);
                vista.getTxtCodigo().setText("");
            } else {
                JOptionPane.showMessageDialog(vista, "No se ha econtrado el codigo de la factura");
                vista.getTxtCodigo().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Digite un codigo de factura");
        }
        
    }
    
    public void eliminarFactura() {
        int idFactura = (int) vista.getTbFacturas().getValueAt(rowSelected, 0);
        
        if(modelo.removerEncabezadoFactura(idFactura)){
            JOptionPane.showMessageDialog(vista, "Eliminado correctamente");
            cargarDatos(0);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
    }
}
