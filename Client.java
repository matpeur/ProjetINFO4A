import java.io.*;

public class Client
{
  static  final  int  port = 8080;

  private synchronized Moteur moteur;

  public void setMoteur(Moteur m)
  {
    while(!m.tryLock())
    {
      m.lock();
      this.moteur = m;
      m.unlock();
    }
  }

  public synchronized void getMoteur()
  {
    return moteur;
  }

  public  static  void  main(String [] args) throws  Exception
  {
    Socket  socket = new  Socket(args[0], port);
    ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
    ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());

    while (true)
    {
      oss.writeObject("MOTEUR");
      Moteur m =(Moteur) ois.readObject ();
      while(!moteur.tryLock())

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

    while (true)
    {
      Object o = ois.readObject ();
      if (o.equals("END")) break;
    }
    ois.close();
    soc.close();
  }
}
