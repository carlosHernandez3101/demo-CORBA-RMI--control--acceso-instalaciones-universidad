package sop_corba;


/**
* sop_corba/ClienteIntPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 9 de junio de 2024 06:00:17 PM COT
*/

public abstract class ClienteIntPOA extends org.omg.PortableServer.Servant
 implements sop_corba.ClienteIntOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("recibirMensaje", new java.lang.Integer (0));
    _methods.put ("recibirContacto", new java.lang.Integer (1));
    _methods.put ("obtenerNombre", new java.lang.Integer (2));
    _methods.put ("borrarListaDeContactos", new java.lang.Integer (3));
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
       case 0:  // sop_corba/ClienteInt/recibirMensaje
       {
         String usuario = in.read_string ();
         String mensaje = in.read_string ();
         this.recibirMensaje (usuario, mensaje);
         out = $rh.createReply();
         break;
       }

       case 1:  // sop_corba/ClienteInt/recibirContacto
       {
         String usuario = in.read_string ();
         this.recibirContacto (usuario);
         out = $rh.createReply();
         break;
       }

       case 2:  // sop_corba/ClienteInt/obtenerNombre
       {
         String $result = null;
         $result = this.obtenerNombre ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // sop_corba/ClienteInt/borrarListaDeContactos
       {
         this.borrarListaDeContactos ();
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
    "IDL:sop_corba/ClienteInt:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ClienteInt _this() 
  {
    return ClienteIntHelper.narrow(
    super._this_object());
  }

  public ClienteInt _this(org.omg.CORBA.ORB orb) 
  {
    return ClienteIntHelper.narrow(
    super._this_object(orb));
  }


} // class ClienteIntPOA
