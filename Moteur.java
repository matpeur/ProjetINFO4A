import java.util.*;

public class Moteur
{
  private int Interface;
  private ArrayList<Creature> creature;

  public void ajoutJoueur(String Nom)
  {
    Joueur j=new Joueur(Nom, getNbJoueur())
    creature.add((Creature)j);
  }

}
