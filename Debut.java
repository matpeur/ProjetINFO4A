import java.io.*;
public class Debut{
  public static void main(String[] args)
  {
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
      Moteur m=new Moteur();
      m.ajoutCuisinier("Michel");
      m.getCreature(0).setPlace(4*m.getPlateau().getNbColonne()+15);
      m.visualisation();
      Serveur serveur = new Serveur(m);
      serveur.start();
      while(s.equals("pret"))
      {
        try
        {
          BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
          s =(String)saisie.readLine();
        }catch(Exception e){e.printStackTrace();}
      }
      m.start();
      while(true)
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
    else
    {
      Client c= new Client();
      c.start();
      while(c.getMoteur().equals(new Moteur()))
      {
      }
      System.out.println("Fichier reçu");
      Moteur m =c.getMoteur();
      m.visualisation();
      while (true)
      {
        Moteur mot = c.getMoteur();
        if(mot != m)
        {
          m = mot;
          m.visualisation();
        }
      }

    }
  }


}
