package sop_corba;

/**
* sop_corba/GestionProductosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 10 de junio de 2024 12:06:12 AM COT
*/

public final class GestionProductosHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.GestionProductos value = null;

  public GestionProductosHolder ()
  {
  }

  public GestionProductosHolder (sop_corba.GestionProductos initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.GestionProductosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.GestionProductosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.GestionProductosHelper.type ();
  }

}
