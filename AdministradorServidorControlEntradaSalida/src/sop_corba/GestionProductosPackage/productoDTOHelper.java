package sop_corba.GestionProductosPackage;


/**
* sop_corba/GestionProductosPackage/productoDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 10 de junio de 2024 12:08:05 AM COT
*/

abstract public class productoDTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionProductos/productoDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.GestionProductosPackage.productoDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.GestionProductosPackage.productoDTO extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [6];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "idUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "idProducto",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "tipoProducto",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "fechaEntrada",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "horaEntrada",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[5] = new org.omg.CORBA.StructMember (
            "estado",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.GestionProductosPackage.productoDTOHelper.id (), "productoDTO", _members0);
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

  public static sop_corba.GestionProductosPackage.productoDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.GestionProductosPackage.productoDTO value = new sop_corba.GestionProductosPackage.productoDTO ();
    value.idUsuario = istream.read_string ();
    value.idProducto = istream.read_string ();
    value.tipoProducto = istream.read_string ();
    value.fechaEntrada = istream.read_string ();
    value.horaEntrada = istream.read_string ();
    value.estado = istream.read_boolean ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.GestionProductosPackage.productoDTO value)
  {
    ostream.write_string (value.idUsuario);
    ostream.write_string (value.idProducto);
    ostream.write_string (value.tipoProducto);
    ostream.write_string (value.fechaEntrada);
    ostream.write_string (value.horaEntrada);
    ostream.write_boolean (value.estado);
  }

}
