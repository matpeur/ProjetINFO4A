import java.io.*;
import java.net.*;

public class Serveur extends Thread
{
  public int  port = 8080;
  private Moteur moteur;

  public Serveur( Moteur m)
  {
    moteur = m;
  }

  public synchronized void setMoteur(Moteur m)
  {
      this.moteur = m;
  }

  public synchronized Moteur getMoteur()
  {
    return moteur;
  }

  public void run()
  {
    try
    {
      while (true)
      {
        ServerSocket s = new  ServerSocket(port);
        Socket  soc = s.accept ();
        System.out.println("Socket accepté");
        ObjectOutputStream  oss = new  ObjectOutputStream(soc.getOutputStream ());
        ObjectInputStream  ois =   new  ObjectInputStream(soc.getInputStream ());
        Object o = ois.readObject ();
        if(o.equals("MOTEUR"))
        {
            oss.writeObject(getMoteur());
            System.out.println("Moteur envoyé");
        }
        if (o.equals("END")) break;
        oss.close();
        ois.close();
        soc.close();
      }
    }
    catch(Exception e){e.printStackTrace();}
  }
}
