import java.io.*;
public class Debut{

  public static String ecranTitre()
  {
    Scores sc= new Scores();
    System.out.println("Bienvenu dans BurgeTime");
    System.out.println("Un projet realise par BELLEGUEULLE Mathieu et TRAORE Moussa");
    sc.afficheScores();
    System.out.println("Enter quelquechose pour demarrer le jeu");
    String s = "null";
    while(s == "null")
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        return s =(String)saisie.readLine();
      }catch(Exception e){e.printStackTrace();}
    }
    return s;
  }

  public static int modeDeJeu()
  {
    System.out.println("Quel mode de jeu ?");
    System.out.println("1. En solo");
    System.out.println("2. En multijoueur");
    int i=-1;
    while (i!=1 && i!= 2)
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        i =Integer.parseInt(saisie.readLine());
      }catch(Exception e){e.printStackTrace();}
    }
    if(i == 2)
    {
      System.out.println("1. En local");
      System.out.println("2. En ligne");
      i = 0;
      while (i!=1 && i!= 2)
      {
        try
        {
          BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
          i =Integer.parseInt(saisie.readLine());
        }catch(Exception e){e.printStackTrace();}
      }
      i += 2;
    }
    return i;
  }

  public static void solo()
  {
    System.out.println("Entrez votre nom :");
    String s = null;
    while(s == null)
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
         s =(String)saisie.readLine();
      }catch(Exception e){e.printStackTrace();}
    }
    int i=1;
    while (i<2)
    {
      Moteur m=new Moteur(i);
      m.ajoutCuisinier(s);
      m.ajoutEnnemis();
      Moteur affichagecourant = new Moteur();
      while(!m.fin())
      {
        if(!(affichagecourant.equals(m)))
        {
          affichagecourant = new Moteur(m);
          affichagecourant.visualisation();
        }
      }
    }
  }

  public static void ligne()
  {
    System.out.println("1. Heberger");
    System.out.println("2. Joindre");
    int i = 0;
    while( i!= 1 && i != 2)
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        String s = saisie.readLine();
        i = Integer.parseInt(s);
      }catch(Exception e){e.printStackTrace();}
    }
    switch (i)
    {
      case 1: int niveau = 1;
              Moteur m = new Moteur(niveau);
              Serveur serveur = new Serveur(m);
              String nom = selectionneNom();
              serveur.start();


    }
  }

  public static String selectionneNom()
  {
    System.out.println("Saisissez votre nom");
    String nom = "";
    try
    {
      BufferedReader saisie = new BufferedReader(new InputStreamReader(System.in));
      nom =saisie.readLine();
    }catch(Exception e){e.printStackTrace();}
    return nom;
  }

  public static void main(String[] args)
  {

    if(ecranTitre().equals("demo"))
    {
      Moteur m = new Moteur();
      //m.ajoutCuisinier("Michel");
      m.demo();
      m.start();
      //m.visualisation();
      Moteur affichagecourant = new Moteur();
      while(!m.fin())
      {
        if(!(affichagecourant.equals(m)))
        {
          affichagecourant = new Moteur(m);
          affichagecourant.visualisation();
        }
      }
    }
    else
    {
      switch(modeDeJeu())
      {
        case 1: solo(); break;
        case 3: //local(); break;
        case 4: ligne(); break;
      }
      /*
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

        m.ajoutCuisinier("Michel");
        m.getCreature(0).setPlace(4*m.getPlateau().getNbColonne()+15);
        m.visualisation();

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
        Moteur affichagecourant = new Moteur();
        while(true)
          {
            if(!(affichagecourant.equals(m)))
            {
              System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
              affichagecourant = m;
              m.visualisation();
              try
              {
                //efface la console

              }catch(Exception e){e.printStackTrace();}
            }
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
        m.start();
        while (true)
        {
          Moteur mot = c.getMoteur();
          if(!mot.equals(m))
          {
            m = mot;
            m.visualisation();
          }
        }

      }
      */
    }
  }

}
