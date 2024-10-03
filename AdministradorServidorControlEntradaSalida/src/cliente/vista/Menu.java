package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import servidor.DTO.UsuarioAccesadoDTO;
import servidor.controladores.ControladorGestionarEntradaSalidaInt;
import sop_corba.GestionProductosOperations;
import sop_corba.GestionProductosPackage.productoDTO;

import java.util.Arrays;

public class Menu {

    private final ControladorGestionarEntradaSalidaInt objRemoto;
    private static GestionProductosOperations ref;

    public Menu(ControladorGestionarEntradaSalidaInt objRemoto, GestionProductosOperations refServProd) {
        this.objRemoto = objRemoto;
        this.ref = refServProd;
    }

    public void ejecutarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n= = Menú = =");
            System.out.println("1. Consultar usuarios accesados");
            System.out.println("2. Consultar historial de productos tecnologicos registrados");
            System.out.println("3. Salir");
            System.out.println("Digite opción:");
            opcion = UtilidadesConsola.leerEntero();
            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción incorrecta");
            }
        } while (opcion != 3);
    }

    private void Opcion1() {
        System.out.println("\n= = Listado de usuarios accesados = =");
        try {

            List<UsuarioAccesadoDTO> lstUsuarios = this.objRemoto.consultarUsuariosAccesados();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
            if (lstUsuarios != null) {
                System.out.printf("\n%-10s  %-15s  %-10s \n", "Codigo", "Hora Entrada", "Fecha Entrada");
                for (UsuarioAccesadoDTO objUsuarioDTO : lstUsuarios) {
                    System.out.printf("%-10s  %-15s  %-10s \n", objUsuarioDTO.getIdentificacion(), objUsuarioDTO.getHoraEntrada().format(formatter), objUsuarioDTO.getFechaEntrada().format(formatterFecha));
                }
            }

            System.out.println("\nCantidad de usuarios al interior de las instalaciones: " + lstUsuarios.size());
        } catch (RemoteException e) {
            System.out.println("\nLa operación no se pudo completar, intente nuevamente...");
        }
    }

    private void Opcion2() {
        System.out.println("\n= = Historial de productos tecnologicos registrados = =");
        productoDTO[] lstProductosRegistrados = this.ref.listarProductos();

        if (lstProductosRegistrados.length != 0) {
            System.out.printf("%-16s %-10s %-19s %-12s %-8s %-15s \n", "ID Producto", "Tipo", "Fecha Entrada", "Hora Entrada", "Estado", "ID Usuario");
            for (productoDTO objProd : lstProductosRegistrados) {
                System.out.printf("%-16s %-10s %-19s %-12s %-8s %-15s \n", objProd.idProducto, objProd.tipoProducto, objProd.fechaEntrada, objProd.horaEntrada, objProd.estado ? "Activo" : "Inactivo", objProd.idUsuario);
            }
        }
    }

//    private void Opcion2() {
//        System.out.println("\n= = Salida = =");
//        try {
//            int identificacion;
//            System.out.println("Digite la identificación: ");
//            identificacion = UtilidadesConsola.leerEntero();
//            int resultado = objRemoto.registrarSalida(identificacion); //InvocaciÃ³n mÃ©todo remoto
//            switch (resultado) {
//                case 1:
//                    System.out.println("\nError, el usuario no existe.");
//                    break;
//                case 2:
//                    System.out.println("\nError, el usuario existe y no está dentro.");
//                    break;
//                case 3:
//                    System.out.println("\nSalida autorizada y registrada.");
//                    break;
//            }
//        } catch (RemoteException e) {
//            System.out.println("\nLa operación no se pudo completar, intente nuevamente...");
//        }
//    }
}
