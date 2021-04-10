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
      System.out.println(s.getInetAddress().getCanonicalHostName());
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
          Joueur j=(Joueur) ois.readObject();
          moteur.ajoutJoueur(j);
        }
        else if(o.equals("PRET"))
        {

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
