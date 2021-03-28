public class Debut{
  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutCuisinier("Michel");
    m.visualisation();
    boolean arret=false; //fin du jeu
    //while(!arret)
      {
        //m.visualisation();
        try
        {
          Runtime.getRuntime().exec("cmd/ccls");
          Thread.currentThread().sleep(1000);
        }catch(Exception e){e.printStackTrace();}
      }
  }


}
