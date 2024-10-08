package sop_corba;


/**
* sop_corba/GestionProductosHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 10 de junio de 2024 12:06:12 AM COT
*/

abstract public class GestionProductosHelper
{
  private static String  _id = "IDL:sop_corba/GestionProductos:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.GestionProductos that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.GestionProductos extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sop_corba.GestionProductosHelper.id (), "GestionProductos");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.GestionProductos read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GestionProductosStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.GestionProductos value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sop_corba.GestionProductos narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.GestionProductos)
      return (sop_corba.GestionProductos)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._GestionProductosStub stub = new sop_corba._GestionProductosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sop_corba.GestionProductos unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.GestionProductos)
      return (sop_corba.GestionProductos)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._GestionProductosStub stub = new sop_corba._GestionProductosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
