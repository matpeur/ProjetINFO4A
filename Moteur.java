import java.util.*;

public class Moteur
{
  private Plateau i;
  public ArrayList<Creature> creature;

  public int getNbJoueur()
  {
    return creature.size();
  }

  public void ajoutJoueur(String Nom)
  {
    Joueur j=new Joueur(i, Nom, getNbJoueur());
    creature.add((Creature)j);
  }

  public Moteur()
  {
    i=new Plateau();
    creature=new ArrayList<Creature>();
  }

  public static void main(String[] args)
  {
    Moteur m=new Moteur();
    m.ajoutJoueur("Michel");
    m.creature.get(0).start();
  }

}
