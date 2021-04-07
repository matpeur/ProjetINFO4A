import java.io.*;

public class Client
{
  static  final  int  port = 8080;

  public  static  void  main(String [] args) throws  Exception
  {
    Socket  socket = new  Socket(args[0], port);
    ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
    oss.writeObject(new  Moteur());
    //  attention  aux  commandes  de type  protocole
    oss.writeObject("MOTEUR") ;
    while (true)
    {
      Object o = ois.readObject ();
      if (o.equals("END")) break;
    }
    oss.close();
    socket.close();
    Socket  socket = new  Socket(args[0], port);
    System.out.println("SOCKET = " + socket);
    ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
    oss.writeObject(new  Moteur());
    System.out.println("END");
    //  attention  aux  commandes  de type  protocole
    oss.writeObject("END") ;
    while (true)
    {
      Object o = ois.readObject ();
      if (o.equals("END")) break;
    }
    oss.close();
    socket.close();
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
