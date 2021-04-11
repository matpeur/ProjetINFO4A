import java.io.*;
import java.net.*;

public class Serveur extends Thread
{
  public int  port = 8080;
  private Moteur moteur;
  private PipedWriter [] flux;

  public Serveur(Moteur m)
  {
    moteur = m;
    flux = new PipedWriter[20];
  }

  public synchronized void setMoteur(Moteur m)
  {
      this.moteur = m;
  }

  public synchronized Moteur getMoteur()
  {
    return moteur;
  }

  public void lier(PipedReader p, int i)
  {
    try
    {
      flux[i] = new PipedWriter(p);
    }catch(Exception e){}
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
            System.out.println(getMoteur());
            oss.writeObject(getMoteur());
        }
        else if(o.equals("JOUEUR"))
        {
          Joueur j=(Joueur) ois.readObject();
          int numero = moteur.getNbCreature();
          moteur.ajoutJoueur(j);
          lier(j.getFlux(), numero);
          oss.write(numero);
        }
        else if(o.equals("COMMANDE"))
        {
          int numero = (int) ois.readInt();
          char commande = (char) ois.readChar();
          flux[numero].write(commande);
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
