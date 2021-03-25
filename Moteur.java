import java.util.*;

public class Moteur
{
  private Plateau plateau;
  public ArrayList<Creature> creature;
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
    Joueur j=new Joueur(plateau, Nom, getNbJoueur());
    creature.add((Creature)j);
  }

  public Creature getJoueur(int i)
  {
    return creature.get(i);
  }

  public Joueur getJoueurPlace(int place)
  {
    int i=0;
    boolean flag = false;
    Joueur r =null;
    while(i<getNbJoueur() && !flag)
    {
      if(getJoueur(i).getPlace()==place)
        flag=true;
    }
    return r;
  }

  public void visualisation()
  {
    for (int i=0; i<plateau.getTaille(); i++)
    {
      if(i%plateau.getNbColonne()==0)
        System.out.print("\n");
      Joueur j = getJoueurPlace(i);
      if(j!=null)
        System.out.print(j.getSymbole());
      else
        System.out.print(plateau.getChar(i));
    }
  }

  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutJoueur("Michel");
    m.creature.get(0).setChar('C');
    m.creature.get(0).setPlace(50);
    System.out.println("Bonjour");
    m.visualisation();

  }

}
