import java.io.*;
public class Serveur extends Thread
{
  public int  port = 8080;
  private synchronized Moteur moteur;

  public Serveur( Moteur m)
  {
    moteur = m;
  }

  public void setMoteur(Moteur m)
  {
    while(!m.tryLock())
    {
      m.lock();
      this.moteur = m;
      m.unlock();
    }
  }

  public void  run()
  {
    try
    {
      ServerSocket s = new  ServerSocket(port);
      Socket  soc = s.accept ();
      ObjectOutputStream  oss = new  ObjectOutputStream(soc.getOutputStream ());
      ObjectInputStream  ois =   new  ObjectInputStream(soc.getInputStream ());
      while (true)
      {
        Object o = ois.readObject ();
        if(o.equals("MOTEUR"))
        {
          while(!m.tryLock())
          {
          m.Lock();
          oss.writeObject(m);
          m.unLock();
          }
        }
        if (o.equals("END")) break;
      }
      oss.close();
      ois.close();
      soc.close();
    }
    catch(Execption e){e.printStackTrace();}
  }
}
