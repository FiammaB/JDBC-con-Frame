/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudmvc;

import com.mycompany.crudmvc.controlador.ControladorProducto;
import com.mycompany.crudmvc.modelo.ConsultasProducto;
import com.mycompany.crudmvc.modelo.Producto;
import com.mycompany.crudmvc.vista.frmProducto;

/**
 *
 * @author brizu
 */
public class CRUDMVC {

    public static void main(String[] args) {
        Producto mod =new Producto();
        ConsultasProducto modConsultasProducto= new ConsultasProducto();
        frmProducto frm = new frmProducto();
         
        ControladorProducto cntrl = new ControladorProducto(mod, modConsultasProducto, frm);
        cntrl.iniciar();
        frm.setVisible(true);
    }
}
