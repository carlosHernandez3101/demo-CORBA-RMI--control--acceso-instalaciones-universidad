/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import java.util.HashMap;
import sop_corba.GestionProductosPOA;
import sop_corba.GestionProductosPackage.productoDTO;

public class GestionProductosImpl extends GestionProductosPOA {

    private HashMap<String, productoDTO> productos;

    public GestionProductosImpl() {
        this.productos = new HashMap();

    }

    @Override
    public boolean registrarProducto(productoDTO objProducto) {
        System.out.println("\nInvocando a registrar producto...");
        System.out.println(objProducto);
        boolean bandera = false;
        if (productos.size() < 5) {
            if (this.productos.containsKey(objProducto.idProducto) == false) {
                productos.put(objProducto.idProducto, objProducto);                
                bandera = true;
            }
        }
        return bandera;
    }

    @Override
    public productoDTO consultarProducto(String codigo) {
        System.out.println("\nInvocando a consultar producto...");
        productoDTO objProducto = new productoDTO("-1","-1","","","",false);
        if (this.productos.get(codigo) != null) {
            objProducto = this.productos.get(codigo);
        }
        return objProducto;
    }

    @Override
    public productoDTO[] listarProductos() {
        System.out.println("\nInvocando a listar productos...");
        ArrayList<productoDTO> lstProductos = new ArrayList<>(productos.values());
        productoDTO[] arrProductos = new productoDTO[lstProductos.size()];
        return lstProductos.toArray(arrProductos);
    }

    @Override
    public String cambiarEstadoProducto(String codigo, boolean nuevoEstado) {
        System.out.println("\nInvocando a cambio de estado de producto...");
        String bandera = "1";
        if (this.productos.get(codigo) != null) {
            this.productos.get(codigo).estado = nuevoEstado;
            bandera = "2";
        }
        return bandera;
    }
}
