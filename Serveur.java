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
      ServerSocket s = new  ServerSocket(port);
      Socket  soc;
      while (true)
      {
        soc = s.accept ();
        ObjectOutputStream  oss = new  ObjectOutputStream(soc.getOutputStream ());
        ObjectInputStream  ois =   new  ObjectInputStream(soc.getInputStream ());
        Object o = ois.readObject();
        if(o.equals("MOTEUR"))
        {
            oss.writeObject(getMoteur());
        }
        else if(o.equals("JOUEUR"))
        {
          Joueur j=ois.readObject();
          m.ajoutJoueur(j);
        }
        else if(o.equals("PRET"))
        {
          System.out.println(o.get)
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
