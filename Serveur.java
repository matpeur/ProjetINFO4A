import java.io.*;
public class Serveur
{
  static  final  int  port = 8080;

  public  static  void  main(String [] args) throws  Exception
  {
    ServerSocket s = new  ServerSocket(port);
    Socket  soc = s.accept ();
    ObjectInputStream  ois =   new  ObjectInputStream(soc.getInputStream ());
    while (true)
    {
      Object o = ois.readObject ();
      if (o.equals("END")) break;
    }
    ois.close();
    soc.close();
  }
}
