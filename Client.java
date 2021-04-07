import java.io.*;
import java.net.*;

public class Client extends Thread
{
  static  final  int  port = 8080;

  private Moteur moteur;

  public Client()
  {
    moteur = null;
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
    boolean arret = true;
    try
    {
      System.out.println("Quel adresse ?");
      String s="";
      while(!s.equals(""))
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        s =(String)saisie.readLine();
      }
      Socket  socket = new  Socket(s, port);
      ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
      ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
      while (arret)
      {
        oss.writeObject("MOTEUR");
        Object o = ois.readObject();
        if(o.getClass() == moteur.getClass())
        {
          Moteur m =(Moteur) o;
          setMoteur(m);
        }
        arret = false;
      }
    oss.close();
    socket.close();
    ois.close();
    }
    catch(Exception e){e.printStackTrace();}
  }
}
