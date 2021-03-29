public class Jeu extends Thread
{

  private Moteur m;

  public Jeu()
  {
    m=new Moteur();
  }

  public void run()
  {
    m.ajoutCuisinier("Michel");
    m.visualisation();
    boolean arret=false; //fin du jeu
    int i=0;
    while(i<10)
      {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        m.visualisation();
        i++;
        try
        {
          this.sleep(1000);
        }
        catch(Exception e){e.printStackTrace();}
      }
  }
}
