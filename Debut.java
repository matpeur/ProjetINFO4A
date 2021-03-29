public class Debut
{
  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutCuisinier("Michel");
    m.visualisation();
    boolean arret=false; //fin du jeu
    int i=0;
    while(i<10)
      {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        m.visualisation();
        i++;

      }
  }
}
