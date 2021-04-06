public class Debut{
  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutCuisinier("Michel");
    m.getCreature(0).setPlace(4*m.getPlateau().getNbColonne()+15);
    m.visualisation();
    m.start();
    boolean arret=false; //fin du jeu

    while(!arret)
      {
        m.visualisation();
        try
        {
          //efface la console
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
          for(int i=0; i<1000000000; i++)
          {}
        }catch(Exception e){e.printStackTrace();}
      }
  }


}
