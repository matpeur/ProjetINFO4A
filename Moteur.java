import java.util.*;

public class Moteur
{
  public Plateau plateau;
  private ArrayList<Creature> creature;
  //public ArrayListe<Burger> burger;

  public int getNbJoueur()
  {
    return creature.size();
  }

  public Moteur()
  {
    plateau=new Plateau();
    creature = new ArrayList<Creature>();
    //burger = new ArrayList<Burger>();
  }

  public void ajoutJoueur(String Nom)
  {
    Joueur j=new Joueur(plateau, Nom, getNbJoueur(), ' ');
    creature.add((Creature)j);
  }

  public void ajoutCuisinier(String Nom)
  {
    Cuisinier c=new Cuisinier(plateau, Nom, getNbJoueur());
    creature.add((Creature)c);
  }

  public Creature getJoueur(int i)
  {
    return creature.get(i);
  }

  public Creature getJoueurPlace(int place)
  {
    int i=0;
    boolean flag = false;
    Creature r = null;
    while(i<getNbJoueur() && !flag)
    {
      if(getJoueur(i).getPlace()==place)
        {
          flag=true;
          r=getJoueur(i);
        }
      i++;
    }
    return r;
  }

  public void visualisation()
  {
    for (int i=0; i<plateau.getTaille(); i++)
    {
      if(i!=0)
        {
          if(i%plateau.getNbColonne()==0)
            System.out.print("\n");
        }
      Joueur j = (Joueur)getJoueurPlace(i);
      if(j!=null)
        {
          System.out.print(j.getSymbole());
        }
      else
      {
        System.out.print(plateau.getChar(i));
      }
    }
  }

  public void start()
  {
    for (int i=0; i<getNbJoueur(); i++)
      getJoueur(i).start();
  }

  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutCuisinier("Michel");
    m.visualisation();
    boolean arret=false; //fin du jeu
    while(!arret)
      {
        m.visualisation();
      }


  }

}
