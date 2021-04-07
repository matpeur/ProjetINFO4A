import java.io.*;
public class Debut{
  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutCuisinier("Michel");
    m.getCreature(0).setPlace(4*m.getPlateau().getNbColonne()+15);
    m.visualisation();
    System.out.println("Quel adresse ?");
    String s="";
    while(s.equals(""))
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        s =(String)saisie.readLine();
      }catch(Exception e){e.printStackTrace();}
    }
    if(s.equals("server"))
    {
      Serveur serveur = new Serveur(m);
      serveur.start();
    }
    else
    {
      Client c= new Client();
      c.start();
      while(c.getMoteur()==new Moteur())
      {
      }
      System.out.println("Fichier reçu");
      System.out.println(c.getMoteur().getCreature(0).getNom());
    }
    //m.start();
    //boolean arret=false; //fin du jeu

    /*while(!arret)
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
      */
  }


}
