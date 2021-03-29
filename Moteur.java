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

  public Plateau getPlateau()
  {
    return plateau;
  }

  public Moteur()
  {
    plateau=new Plateau();
    creature = new ArrayList<Creature>();
    //burger = new ArrayList<Burger>();
  }

  public void ajoutJoueur(String Nom)
  {
    Joueur j=new Joueur(this, Nom, getNbJoueur(), ' ');
    creature.add((Creature)j);
  }

  public void ajoutCuisinier(String Nom)
  {
    Cuisinier c=new Cuisinier(this, Nom, getNbJoueur());
    creature.add((Creature)c);
  }

  public void ajoutEnnemi(char c)
  {
    int indice = getNbJoueur();
    switch(c)
    {
      case 'p':
      case 'P': creature.add(new Ennemis(this, "Piment", indice));
                getJoueur(indice).setSymbole('P');
                break;
      case 'o':
      case 'O': creature.add(new Ennemis(this, "Oeuf", indice));
                          getJoueur(indice).setSymbole('O');
                          break;
    }
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
      Creature c = (Creature)getJoueurPlace(i);
      if(c!=null)
        {
          System.out.print(c.getSymbole());
        }
      else
      {
        System.out.print(plateau.getChar(i));
      }
    }
  }

  public void startJeu()
  {
    for (int i=0; i<getNbJoueur(); i++)
      getJoueur(i).start();
  }
}
