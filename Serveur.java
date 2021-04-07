import java.io.*;
public class Serveur
{
  static  final  int  port = 8080;
  private synchronized Moteur moteur;

  public Serveur( Moteur m)
  {
    moteur = m;
  }

  public  static  void  main(String [] args) throws  Exception
  {
    ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
    while (true)
    {
      Object o = ois.readObject ();
      if(o.equals("MOTEUR"))
      {
        oss.writeObject(m);
      }
      if (o.equals("END")) break;
    }
    oss.close();
    socket.close();
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
