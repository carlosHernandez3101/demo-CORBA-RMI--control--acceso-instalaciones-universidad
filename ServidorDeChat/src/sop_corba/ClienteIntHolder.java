package sop_corba;

/**
* sop_corba/ClienteIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 9 de junio de 2024 05:58:15 PM COT
*/

public final class ClienteIntHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ClienteInt value = null;

  public ClienteIntHolder ()
  {
  }

  public ClienteIntHolder (sop_corba.ClienteInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ClienteIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ClienteIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ClienteIntHelper.type ();
  }

}
