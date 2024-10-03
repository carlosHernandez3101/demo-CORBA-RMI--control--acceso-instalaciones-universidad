package cliente.vista;

import cliente.GUI.GUICliente;
import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import servidor.controladores.ControladorGestionarEntradaSalidaInt;
import sop_corba.GestionProductosOperations;
import sop_corba.GestionProductosPackage.productoDTO;

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
            System.out.println("1. Entrar a las instalaciones.");
            System.out.println("2. Salir de las instalaciones.");
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

    private int leerIdentificacion(String msj) {
        boolean idValido = false;
        int identificacion;
        String id;
        do {
            System.out.println(msj);
            identificacion = UtilidadesConsola.leerEntero();
            id = String.valueOf(identificacion);
            idValido = (id.length() == 8);
            if (idValido == false) {
                System.out.println("\nInvalido. El codigo debe ser de 8 caracteres. Intente nuevamente.\n");
            }
        } while (idValido == false);

        return identificacion;
    }

    private void registrarIngresoProducto(String idUsuario) {
        productoDTO objProd;
        String respuesta;
        do {
            do {
                System.out.print("\n¿Desea registrar algun producto? (s/n): ");
                respuesta = UtilidadesConsola.leerCadena().trim().toLowerCase();
                if (!respuesta.equals("s") && !respuesta.equals("n")) {
                    System.out.println("\nRespuesta inválida. Por favor, ingrese 's' para si o 'n' para no.");
                }
            } while (!respuesta.equals("s") && !respuesta.equals("n"));

            if (respuesta.equals("s")) {
                System.out.println("\nIngrese el codigo del producto.");
                String codigo = UtilidadesConsola.leerCadena();
                System.out.println("Ingrese el tipo de producto.");
                String nombre = UtilidadesConsola.leerCadena();

                String fechaEntrada = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String horaEntrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm: a"));

                objProd = new productoDTO(idUsuario, codigo, nombre, fechaEntrada, horaEntrada, true);

                ref.registrarProducto(objProd);

                System.out.println("\nProducto registrado exitosamente.");
            } else {
                System.out.println("\nOperaci?n cancelada.");
            }

        } while (respuesta.equals("s"));
    }

    private void cambiarEstadoProducto() {
        String respuesta;
        do {
            do {
                System.out.print("\n¿Desea registrar salida de algun producto? (s/n): ");
                respuesta = UtilidadesConsola.leerCadena().trim().toLowerCase();
                if (!respuesta.equals("s") && !respuesta.equals("n")) {
                    System.out.println("\nRespuesta inválida. Por favor, ingrese 's' para si o 'n' para no.");
                }
            } while (!respuesta.equals("s") && !respuesta.equals("n"));

            if (respuesta.equals("s")) {
                System.out.println("\nIngrese el codigo del producto.");
                String codigo = UtilidadesConsola.leerCadena();
                String accion = ref.cambiarEstadoProducto(codigo, false);
                switch (accion) {
                    case "1":
                        System.out.println("\nEl producto solicitado no existe.");
                        break;
                    case "2":
                        System.out.println("\nCambio de estado de producto exitoso.");
                        break;
                }
            }

        } while (respuesta.equals("s"));

    }

    private void Opcion1() {
        System.out.println("\n= = Entrada = =");
        try {
            int identificacion;
            identificacion = leerIdentificacion("Digite la identificación: ");
            int resultado = objRemoto.registrarEntrada(identificacion); //InvocaciÃ³n mÃ©todo remoto
            switch (resultado) {
                case 1:
                    System.out.println("\nError, el usuario no existe.");
                    break;
                case 2:
                    System.out.println("\nError, el usuario existe y está dentro.");
                    break;
                case 3:
                    System.out.println("\n    Acceso concedido.\n");
                    System.out.println(objRemoto.generarTicket(identificacion, "e"));
                    registrarIngresoProducto(String.valueOf(identificacion));
                    break;
            }
        } catch (RemoteException e) {
            System.out.println("\nLa operación no se pudo completar, intente nuevamente...");
        }
    }

    private void Opcion2() {

        System.out.println("\n= = Salida = =");
        try {
            int identificacion;
            identificacion = leerIdentificacion("Digite la identificación: ");
            int resultado = objRemoto.registrarSalida(identificacion); //InvocaciÃ³n mÃ©todo remoto
            switch (resultado) {
                case 1:
                    System.out.println("\nError, el usuario no existe.");
                    break;
                case 2:
                    System.out.println("\nError, el usuario existe y no está dentro.");
                    break;
                case 3:
                    System.out.println("\n    Salida concedida.\n");
                    System.out.println(objRemoto.generarTicket(identificacion, "s"));
                    cambiarEstadoProducto();
                    break;
            }
        } catch (RemoteException e) {
            System.out.println("\nLa operación no se pudo completar, intente nuevamente...");
        }
    }


//    private void Opcion3() {
//        String codigo;
//        System.out.println("\nDigite el codigo del producto: ");
//        codigo = UtilidadesConsola.leerCadena();
//        productoDTO objProducto = ref.consultarProducto(codigo);
//        if (!objProducto.idProducto.equals("-1")) {
//            mostrarProducto(objProducto);
//        } else {
//            System.out.println("\nEl producto no existe.");
//        }
//    }
//
//    private static void mostrarProducto(productoDTO objProducto) {
//        System.out.printf("\n %-10s  %-15s  %-15s \n", "Codigo", "Nombre", "Fecha Entrada", "Hora Entrada");
//        System.out.printf(" %-10s  %-15s  %-15s \n", objProducto.idProducto, objProducto.tipoProducto, objProducto.fechaEntrada, objProducto.horaEntrada);
//    }
}
