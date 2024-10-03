package cliente.servicios;

import cliente.GUI.GUICliente;
import cliente.utilidades.UtilidadesConsola;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidor.controladores.ControladorGestionarEntradaSalidaInt;
import sop_corba.GestionProductosHelper;
import sop_corba.GestionProductosOperations;

public class ClienteDeObjetos
{

    private static ControladorGestionarEntradaSalidaInt objRemoto;
    private static GestionProductosOperations ref;

    public static void main(String[] args)
    {
        System.out.println("===========Obteniendo referencia de SERVIDOR PRODUCTOS con CORBA...");
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
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
        
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("\n===========Obteniendo referencia del SERVIDOR CONTROL ENTRADA SALIDA con RMI...");
        System.out.println("Cual es el la dirección ip donde se encuentra el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 

        objRemoto = (ControladorGestionarEntradaSalidaInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry,
                numPuertoRMIRegistry, 
                "objServicioGestionUsuariosEntradaSalida");
        
        GUICliente chat = new GUICliente();
        chat.setVisible(true);
        
        Menu objMenu= new Menu(objRemoto, ref);
        objMenu.ejecutarMenuPrincipal();
        
        chat.ejecutarSalir();
        chat.setVisible(false);
    }
}