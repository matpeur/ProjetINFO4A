import java.io.*;

public class Client
{
  static  final  int  port = 8080;

  public  static  void  main(String [] args) throws  Exception
  {
    Socket  socket = new  Socket(args[0], port);
    System.out.println("SOCKET = " + socket);
    ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
    oss.writeObject(new  Moteur());
    System.out.println("END");
    //  attention  aux  commandes  de type  protocole
    oss.writeObject("END") ;
    oss.close();
    socket.close();
  }
}
