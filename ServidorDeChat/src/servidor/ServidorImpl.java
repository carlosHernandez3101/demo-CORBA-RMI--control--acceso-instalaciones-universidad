/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.util.ArrayList;
import java.util.List;
import sop_corba.ClienteInt;
import sop_corba.ServidorIntPOA;
import sop_corba.ServidorIntPackage.datosUsuario;

/**
 *
 * @author ASUS
 */
public class ServidorImpl extends ServidorIntPOA{
    
    private final List<ClienteInt> usuarios;
    private final List<String> datosUsuarios;

    public ServidorImpl() {
        this.usuarios = new ArrayList();
        this.datosUsuarios = new ArrayList();
    }    

    @Override
    public boolean registrarCliente(ClienteInt objcllbck, String usuario) {
        System.out.println("Registrar...");
        boolean registro = false;
        if (!usuarios.contains(objcllbck)) {
            registro = usuarios.add(objcllbck);
            datosUsuarios.add(usuario);
            notificar();
        }
        
        if (registro) {
            System.out.println("El usuario "+usuario+" se registro.");
        }else{
            System.out.println("El usuario "+usuario+" no se registro.");
        }
        return registro;
    }

    @Override
    public void enviarMensaje(String usuario, String mensaje) {
        for (ClienteInt cliente : usuarios) {
            cliente.recibirMensaje(usuario, mensaje);
        }
    }
    
    public void notificar(){
        for (ClienteInt cliente : usuarios) {
            cliente.borrarListaDeContactos();
            for (ClienteInt usuario : usuarios) {
                if (usuario!=cliente) {
                    cliente.recibirContacto(usuario.obtenerNombre());
                }
                
            }
        }
    }

    @Override
    public boolean desconectarCliente(ClienteInt objcllbck, String usuario) {
        this.datosUsuarios.remove(usuario);
        this.usuarios.remove(objcllbck);
        notificar();
        return true;
    }

    @Override
    public datosUsuario[] obtenerUsuariosConectados() {
        return (datosUsuario[]) this.usuarios.toArray();
    }
    
}
