package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import sop_corba.*;
import sop_corba.GestionProductosPackage.productoDTO;

public class ClienteDeObjetos {

    static GestionProductosOperations ref;

    public static void main(String[] args) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vec[1] = UtilidadesConsola.leerCadena();
            vec[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = UtilidadesConsola.leerCadena();

            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objProductos";
            ref = GestionProductosHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);

            int rta = 0;
            do {
                rta = menu();

                switch (rta) {
                    case 1:
                        opcion1();
                        break;
                    case 2:
                        opcion2();
                        break;
                }

            } while (rta != 3);

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    private static int menu() {
        System.out.println("\n= = = = MENU = = = =");
        System.out.println("1. Registrar Producto.");
        System.out.println("2. Consultar Producto.");
        System.out.println("3. Salir.");
        int rta = UtilidadesConsola.leerEntero();

        return rta;
    }

    private static void opcion1() {
        boolean bandera = false;
        productoDTO objProdID = null;
        System.out.println("\nIngrese el codigo del producto.");
        String codigo = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el nombre del producto.");
        String nombre = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el valor del producto.");
        float valor = UtilidadesConsola.leerEntero();

//        productoDTO objProducto = new productoDTO(codigo, nombre, valor);
//        bandera = ref.registrarProducto(objProducto);//invocación al método remoto

    }

    private static void opcion2() {
        String codigo;
        System.out.println("\nDigite el codigo del producto: ");
        codigo = UtilidadesConsola.leerCadena();
        productoDTO objProducto = ref.consultarProducto(codigo);
        mostrarProducto(objProducto);
    }

    private static void mostrarProducto(productoDTO objProducto) {
        System.out.printf("\n %-10s  %-15s  %-15s \n", "Codigo", "Nombre", "Fecha Entrada","Hora Entrada");
        System.out.printf(" %-10s  %-15s  %-15s \n", objProducto.idProducto, objProducto.tipoProducto, objProducto.fechaEntrada, objProducto.horaEntrada);
    }

}
