import java.io.*;
import java.net.*;

public class Client extends Thread
{
  static  final  int  port = 8080;

  private Moteur moteur;
  private boolean arret;

  public Client()
  {
    moteur = new Moteur();;
    arret = true;
  }

  public synchronized void setMoteur(Moteur m)
  {
      this.moteur = m;
  }

  public void arret()
  {
    this.arret = false;
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
      while(s.equals(""))
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        s =(String)saisie.readLine();
      }
      while (arret)
      {
        Socket  socket = new  Socket(s, port);
        ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
        ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
        oss.writeObject("MOTEUR");
        this.sleep(100);
        Object o = ois.readObject();
        if(o.getClass() == moteur.getClass())
        {
          Moteur m =(Moteur) o;
          setMoteur(m);
        }
        oss.close();
        socket.close();
        ois.close();
      }
    System.out.println("Fin");
    }
    catch(Exception e){e.printStackTrace();}
  }
}
