package sop_corba.ServidorIntPackage;


/**
* sop_corba/ServidorIntPackage/datosUsuarioHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 9 de junio de 2024 05:58:15 PM COT
*/

abstract public class datosUsuarioHelper
{
  private static String  _id = "IDL:sop_corba/ServidorInt/datosUsuario:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.ServidorIntPackage.datosUsuario that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.ServidorIntPackage.datosUsuario extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "nombre",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.ServidorIntPackage.datosUsuarioHelper.id (), "datosUsuario", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.ServidorIntPackage.datosUsuario read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.ServidorIntPackage.datosUsuario value = new sop_corba.ServidorIntPackage.datosUsuario ();
    value.nombre = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.ServidorIntPackage.datosUsuario value)
  {
    ostream.write_string (value.nombre);
  }

}
