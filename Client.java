import java.io.*;
import java.net.*;

public class Client extends Thread
{
  static  final  int  port = 8080;

  private Moteur moteur;
  private boolean arret;
  private String adresse;
  private int numero;
  private Ecouteur ecouteur;

  public Client()
  {
    moteur = new Moteur();;
    arret = true;
    try
    {
      System.out.println("Quel adresse ?");
      adresse ="";
      while(adresse.equals(""))
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        adresse =(String)saisie.readLine();
      }
    }catch(Exception e){e.printStackTrace();}
    numero = -1;
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

  public void transmetJoueur(Joueur j)
  {
    try
    {
      Socket  socket = new  Socket(adresse, port);
      ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
      ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
      oss.writeObject("JOUEUR");
      oss.writeObject(j);
      numero = ois.readInt();
      ecouteur = new Ecouteur(this, numero);
      oss.close();
      socket.close();
      ois.close();
    }
    catch(Exception e){}
  }

  public void transmetCommande(char c)
  {
    try
    {
      Socket  socket = new  Socket(adresse, port);
      ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
      oss.writeObject("COMMANDE");
      oss.writeInt(numero);
      oss.writeChar(c);
      oss.close();
      socket.close();
    }
    catch(Exception e){}
  }



  public void run()
  {
    boolean arret = true;
    try
    {

      while (moteur.fin())
      {
        Socket  socket = new  Socket(adresse, port);
        ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
        ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
        oss.writeObject("MOTEUR");
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
