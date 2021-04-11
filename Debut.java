import java.io.*;
import java.util.*;
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
      m.start();
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
    String nom;
    switch (i)
    {
      case 1 : int niveau = 1;
               Moteur m = new Moteur(niveau);
               Serveur serveur = new Serveur(m);
               nom = selectionne("Saisissez votre nom : ");
               serveur.start();
               boolean jeu = false;
               ArrayList<Creature> creatures = new ArrayList<Creature>();
               while(niveau < 2)
               {
                 for(int j = 0; j < m.getNbCreature(); j++)
                 {
                   if(!creatures.contains(m.getCreature(j)))
                   {
                     creatures.add(m.getCreature(j));
                   }
                 }
                 m.ajoutCuisinier(nom);
                 m.start();
                 serveur.setMoteur(m);
                 Moteur affichagecourant = new Moteur();
                 while(!m.fin())
                 {
                   if(!(affichagecourant.equals(m)))
                   {
                     affichagecourant = new Moteur(m);
                     affichagecourant.visualisation();
                   }
                 }
                 niveau++;
               }
               break;
      case 2 : Client c = new Client();
               c.start();
               System.out.println("1. Ajouter un Ennemi");
               System.out.println("2. Ajouter un Cuisinier");
               int type = 0;
               try
               {
                 BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
                 String s = saisie.readLine();
                 type = Integer.parseInt(s);
               }catch(Exception e){e.printStackTrace();}
               switch(type)
               {
                 case 1 : nom = selectionne("Saisissez votre nom :");
                          char Symbole = selectionne("Saisissez votre symbole :").charAt(0);
                          Ennemi e = new Ennemi(c.getMoteur(), nom, Symbole);
                          c.transmetJoueur((Joueur) e);
                          break;
                 case 2 : nom = selectionne("Saisissez votre nom :");
                          Cuisinier cuisinier = new Cuisinier(c.getMoteur(), nom);
                          c.transmetJoueur((Joueur) cuisinier);
                          break;
               }
               Moteur affichagecourant = new Moteur(c.getMoteur());
               while(!affichagecourant.fin())
               {
                 if(!affichagecourant.equals(c.getMoteur()))
                 {
                   affichagecourant = new Moteur(c.getMoteur());
                   affichagecourant.visualisation();
                 }
               }
               break;

    }
  }

  public static String selectionne(String S)
  {
    System.out.println(S);
    String result = null;
    try
    {
      BufferedReader saisie = new BufferedReader(new InputStreamReader(System.in));
      result =saisie.readLine();
    }
    catch(Exception e){e.printStackTrace();}
    return result;
  }

  public static void local()
  {
    int i=-1;
    Moteur moteur = new Moteur(1);
    do
    {
      System.out.println("1. Ajouter un cuisinier");
      System.out.println("2. Ajouter un ennemi");
      System.out.println("3. Demarrer");
      String result = null;
      try
      {
        BufferedReader saisie = new BufferedReader(new InputStreamReader(System.in));
        result =saisie.readLine();
      }
      catch(Exception e){e.printStackTrace();}
      i = Integer.parseInt(result);
      String nom = null;
      switch (i)
      {
        case 1 : nom = selectionne("Saisissez votre nom");
                 Cuisinier c = new Cuisinier(moteur, nom);
                 c.setCommandes(selectionneCommandes('C'));
                 moteur.ajoutCreature((Creature) c);
                 break;
        case 2 : nom = selectionne("Saisissez votre nom");
                 char Symbole = selectionne("Saisissez votre symbole :").charAt(0);
                 Ennemi e = new Ennemi(moteur, nom, Symbole);
                 e.setCommandes(selectionneCommandes(Symbole));
                 moteur.ajoutCreature((Creature) e);
      }
    }
    while(i==1 || i == 2);
    if(!moteur.haveEnnemi())
      moteur.ajoutEnnemis();
    Moteur affichagecourant = new Moteur();
    while(!moteur.fin())
    {
      if(!(affichagecourant.equals(moteur)))
      {
        affichagecourant = new Moteur(moteur);
        affichagecourant.visualisation();
      }
    }
  }

  public static char[] selectionneCommandes(char symbole)
  {
    char [] result;
    if(symbole == 'C')
      result = new char[5];
    else
      result = new char[4];
    result[0] = selectionne("Quelle touche pour aller en haut ?").charAt(0);
    result[1] = selectionne("Quelle touche pour aller a gauche ?").charAt(0);
    result[2] = selectionne("Quelle touche pour aller en bas ?").charAt(0);
    result[3] = selectionne("Quelle touche pour aller a droite ?").charAt(0);
    if(symbole == 'C')
      result[4] = selectionne("Quelle touche pour poivrer ?").charAt(0);
    return result;
  }

  public static void main(String[] args)
  {

    if(ecranTitre().equals("demo"))
    {
      Moteur m = new Moteur();
      m.ajoutCuisinier("Michel");
      m.demo();
      m.start();
      m.visualisation();
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
        case 3: local(); break;
        case 4: ligne(); break;
      }
    }
  }

}
