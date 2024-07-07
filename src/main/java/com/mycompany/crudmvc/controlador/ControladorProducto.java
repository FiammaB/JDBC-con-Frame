/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmvc.controlador;

import com.mycompany.crudmvc.modelo.ConsultasProducto;
import com.mycompany.crudmvc.modelo.Producto;
import com.mycompany.crudmvc.vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author brizu
 */
public class ControladorProducto implements ActionListener{
    private Producto modProducto;
    private ConsultasProducto modConsultasProducto;
    private frmProducto frm;

    public ControladorProducto(Producto modProducto, ConsultasProducto modConsultasProducto, frmProducto frm) {
        this.modProducto = modProducto;
        this.modConsultasProducto = modConsultasProducto;
        this.frm = frm;
        this.frm.btnbuscar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
        this.frm.btnguardar.addActionListener(this);
        this.frm.btnlimpiar.addActionListener(this);
        this.frm.btnmodificar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtid.setVisible(false);
    }
    @Override
    public  void actionPerformed(ActionEvent e){
        if (e.getSource()==frm.btnguardar) {
             modProducto.setCodigo(frm.txtcodigo.getText());
              modProducto.setNombre(frm.txtnombre.getText());
             modProducto.setPrecio(Double.parseDouble(frm.txtprecio.getText()));
             modProducto.setCantidad(Integer.parseInt(frm.txtcantidad.getText()));
             
            if (modConsultasProducto.registrar(modProducto)) {
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
                  
            }else{
                 JOptionPane.showMessageDialog(null, "error al guardar");
                 limpiar();
            }
        }
        
         if (e.getSource()==frm.btnmodificar) {
             modProducto.setId(Integer.parseInt(frm.txtid.getText()));
             modProducto.setCodigo(frm.txtcodigo.getText());
              modProducto.setNombre(frm.txtnombre.getText());
             modProducto.setPrecio(Double.parseDouble(frm.txtprecio.getText()));
             modProducto.setCantidad(Integer.parseInt(frm.txtcantidad.getText()));
             
            if (modConsultasProducto.modificar(modProducto)) {
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
                  
            }else{
                 JOptionPane.showMessageDialog(null, "error al modificar");
                 limpiar();
            }
        }
         
           if (e.getSource()==frm.btneliminar) {
             modProducto.setId(Integer.parseInt(frm.txtid.getText()));
           
            if (modConsultasProducto.eliminar(modProducto)) {
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
                  
            }else{
                 JOptionPane.showMessageDialog(null, "error al eliminar");
                 limpiar();
            }
        }

             if (e.getSource()==frm.btnbuscar) {
             modProducto.setCodigo(frm.txtcodigo.getText());
           
            if (modConsultasProducto.buscar(modProducto)) {
                frm.txtid.setText(String.valueOf( modProducto.getId()));
                 frm.txtcodigo.setText(String.valueOf(modProducto.getCodigo()));
                 frm.txtnombre.setText(String.valueOf(modProducto.getNombre()));
                 frm.txtprecio.setText(String.valueOf(modProducto.getPrecio()));
                 frm.txtcantidad.setText(String.valueOf(modProducto.getCantidad()));

                  
            }else{
                 JOptionPane.showMessageDialog(null, "no se encontro registro");
                 limpiar();
            }
        }
                          if (e.getSource()==frm.btnlimpiar) {
                              limpiar();
                          }
    }
  
    public void limpiar(){
    frm.txtid.setText(null);
     frm.txtcodigo.setText(null);
      frm.txtnombre.setText(null);
       frm.txtprecio.setText(null);
        frm.txtcantidad.setText(null);
    }
}
