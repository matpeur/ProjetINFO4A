import java.io.*;
import java.net.*;

public class Client extends Thread
{
  static  final  int  port = 8080;

  private String moteur;
  private boolean arret;
  private String adresse;
  private int numero;
  private Ecouteur ecouteur;

  public Client()
  {
    moteur = "";
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

  public synchronized void setMoteur(String m)
  {
      this.moteur = m;
  }

  public void arret()
  {
    this.arret = false;
  }

  public synchronized String getMoteur()
  {
    return moteur;
  }

  public boolean fin()
  {
    boolean result = false;
    try
    {
      Socket  socket = new  Socket(adresse, port);
      ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
      ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
      oss.writeObject("FIN");
      result = (boolean)ois.readObject();
      oss.close();
      socket.close();
      ois.close();
    }
    catch(Exception e){}
    return result;
  }

  public Joueur getJoueur(int i)
  {
    Joueur j=null;
    try
    {
      Socket  socket = new  Socket(adresse, port);
      ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
      ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
      oss.writeObject("GETJOUEUR");
      oss.writeInt(i);
      j = (Joueur) ois.readObject();
      oss.close();
      socket.close();
      ois.close();
    }
    catch(Exception e){}
    return j;
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
      ecouteur.start();
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

      while (fin())
      {
        Socket  socket = new  Socket(adresse, port);
        ObjectOutputStream  oss = new  ObjectOutputStream(socket.getOutputStream ());
        ObjectInputStream  ois =   new  ObjectInputStream(socket.getInputStream ());
        oss.writeObject("MOTEUR");
        Object o = ois.readObject();
        String m =(String) o;
        setMoteur(m);
        oss.close();
        socket.close();
        ois.close();
      }
    System.out.println("Fin");
    }
    catch(Exception e){e.printStackTrace();}
  }
}
