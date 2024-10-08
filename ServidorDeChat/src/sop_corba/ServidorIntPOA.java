package sop_corba;


/**
* sop_corba/ServidorIntPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 9 de junio de 2024 05:58:15 PM COT
*/

public abstract class ServidorIntPOA extends org.omg.PortableServer.Servant
 implements sop_corba.ServidorIntOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registrarCliente", new java.lang.Integer (0));
    _methods.put ("enviarMensaje", new java.lang.Integer (1));
    _methods.put ("desconectarCliente", new java.lang.Integer (2));
    _methods.put ("obtenerUsuariosConectados", new java.lang.Integer (3));
    _methods.put ("notificar", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/ServidorInt/registrarCliente
       {
         sop_corba.ClienteInt objcllbck = sop_corba.ClienteIntHelper.read (in);
         String usuario = in.read_string ();
         boolean $result = false;
         $result = this.registrarCliente (objcllbck, usuario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // sop_corba/ServidorInt/enviarMensaje
       {
         String usuario = in.read_string ();
         String mensaje = in.read_string ();
         this.enviarMensaje (usuario, mensaje);
         out = $rh.createReply();
         break;
       }

       case 2:  // sop_corba/ServidorInt/desconectarCliente
       {
         sop_corba.ClienteInt objcllbck = sop_corba.ClienteIntHelper.read (in);
         String usuario = in.read_string ();
         boolean $result = false;
         $result = this.desconectarCliente (objcllbck, usuario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // sop_corba/ServidorInt/obtenerUsuariosConectados
       {
         sop_corba.ServidorIntPackage.datosUsuario $result[] = null;
         $result = this.obtenerUsuariosConectados ();
         out = $rh.createReply();
         sop_corba.ServidorIntPackage.ListUsuariosHelper.write (out, $result);
         break;
       }

       case 4:  // sop_corba/ServidorInt/notificar
       {
         this.notificar ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/ServidorInt:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ServidorInt _this() 
  {
    return ServidorIntHelper.narrow(
    super._this_object());
  }

  public ServidorInt _this(org.omg.CORBA.ORB orb) 
  {
    return ServidorIntHelper.narrow(
    super._this_object(orb));
  }


} // class ServidorIntPOA
