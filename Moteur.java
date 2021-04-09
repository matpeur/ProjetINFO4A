import java.util.*;
import java.io.*;

public class Moteur implements Serializable
{
  private Plateau plateau;
  private ArrayList<Creature> creature;
  private ArrayList<Burger> Burgers;
  public int spawnEnnemi;
  public int spawnJoueur;
  //public Scores score;
  private Ecouteur ecoute;

  public void addScore(int i)
  {
    //score.addScore(i);
  }

  public int getSpawnEnnemi()
  {
    return spawnEnnemi;
  }

  public int getNbCreature()
  {
    return creature.size();
  }

  public int getNbBurgers()
  {
    return Burgers.size();
  }

  public void setPlateau(Plateau p){ this.plateau=p;}
  public Plateau getPlateau(){ return this.plateau;}
  public boolean fin(){ return getFin();}
  private boolean getFin()
  {
    int i = 0;
    while(i<Burgers.size())
    {
      if(!getBurger(i).complet())
        return false;
      i++;
    }
    i=0;
    int somme = 0;
    while(i < getNbCreature())
    {
      if(getCreature(i).getSymbole() == 'C')
      {
        Cuisinier c =(Cuisinier)(getCreature(i));
        somme += c.getVie();
      }
    }
    return somme <= 0;
  }

  public Moteur()
  {
    plateau = new Plateau();
    creature = new ArrayList<Creature>();
    Burgers = new ArrayList<Burger>();
  }

  public Moteur(int i)
  {
    plateau = new Plateau(i);
    creature = new ArrayList<Creature>();
    Burgers = new ArrayList<Burger>();
    switch(i)
    {
      case 1 : spawnEnnemi = 19*plateau.getNbColonne()+97;
               spawnJoueur = plateau.getApparitionJoueur();
               Burgers.add(new Burger(this, 16));
               Burgers.add(new Burger(this, 40));
               Burgers.add(new Burger(this, 54));
               Burgers.add(new Burger(this, 78));
    }
  }

  public Moteur(Moteur m)
  {
    plateau = new Plateau(m.getPlateau());
    creature = new ArrayList<Creature>();
    for(int i = 0; i<m.getNbCreature(); i++)
    {
      if(m.getCreature(i).getSymbole() == 'C')
        creature.add((Creature)new Cuisinier((Cuisinier)m.getCreature(i), this));
      else if(m.getCreature(i).getClass() == new EnnemiIA().getClass())
        creature.add((Creature)new EnnemiIA((EnnemiIA)m.getCreature(i), this));
      else
      {
        creature.add((Creature)new Ennemi((Ennemi)m.getCreature(i), this));
      }
    }
    Burgers = new ArrayList<Burger>();
    for(int i = 0; i<m.getNbBurgers(); i++)
    {
      Burgers.add(new Burger(m.getBurger(i), this));
    }
    spawnEnnemi = m.getSpawnEnnemi();
    spawnJoueur = m.getPlateau().getApparitionJoueur();
  }

  public synchronized void ajoutCuisinier(String Nom)
  {
    Cuisinier c=new Cuisinier(this, Nom);
    creature.add((Creature)c);
  }

  public synchronized void ajoutEnnemi(String Nom, char Symbole)
  {
    Ennemi e=new Ennemi(this, Nom, Symbole);
    creature.add((Creature)e);
  }

  public synchronized void ajoutEnnemiIA(EnnemiIA e)
  {
    creature.add((Creature)e);
  }

  public void ajoutEnnemis()
  {
    EnnemiIA a = new EnnemiIA(this, "Pepper");
    a.setSymbole('P');
    ajoutEnnemiIA(a);
    EnnemiIA b = new EnnemiIA(this, "Egg");
    a.setSymbole('O');
    ajoutEnnemiIA(b);
    EnnemiIA c = new EnnemiIA(this, "Sausage");
    a.setSymbole('S');
    ajoutEnnemiIA(c);
  }

  public void ajoutCreature(Creature c)
  {
    creature.add(c);
  }

  public Creature getCreature(int i)
  {
    return creature.get(i);
  }

  public Creature getCreaturePlace(int place)
  {
    int i=0;
    boolean flag = false;
    Creature r = null;
    while(i<getNbCreature() && !flag)
    {
      if(getCreature(i).getPlace()==place)
        {
          flag=true;
          r=getCreature(i);
        }
      i++;
    }
    return r;
  }

  public Elements getElementsPlace(int place)
  {
    int i = 0;
    Elements resultat = null;
    while(resultat == null && i<Burgers.size())
    {
      resultat = Burgers.get(i).getElement(plateau.getLigne(place), plateau.getColonne(place));
      i++;
    }
    return resultat;
  }

  public Burger getBurger(int i)
  {
    return Burgers.get(i);
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
      Creature j = getCreaturePlace(i);
      Elements e = getElementsPlace(i);
      if(j!=null)
        {
          System.out.print(j.getSymbole());
        }
      else if (e != null)
      {
        System.out.print(e.getSymbole());
      }
      else
      {
        System.out.print(plateau.getChar(i));
      }
    }
  }

  public void start()
  {
    for (int i = 0; i < getNbCreature(); i++)
      getCreature(i).start();
    for (int i = 0; i < Burgers.size(); i++)
      Burgers.get(i).debut();
    ecoute = new Ecouteur(this);
    ecoute.start();
  }

  public boolean equals(Moteur m)
  {
    if(!this.plateau.equals(m.getPlateau()))
    {
      System.out.println("Plateau");
      return false;
    }
    for(int i = 0; i<creature.size(); i++)
    {
      try
      {
        if(!creature.get(i).equals(m.getCreature(i)))
        {
          System.out.println("Creature");
          return false;
        }
      }
      catch (Exception e) {return false;}
    }
    for (int i = 0; i<Burgers.size(); i++)
    {
      try
      {
        if(!Burgers.get(i).equals(m.getBurger(i)))
        {
          System.out.println("Burger");
          return false;
        }
      }
      catch (Exception e) {return false;}
    }
    return true;
  }

  public void demo()
  {
    plateau = new Plateau(1);
    creature = new ArrayList<Creature>();
    Burgers = new ArrayList<Burger>();
    Burgers.add(new Burger(this, 16));
    Burgers.add(new Burger(this, 40));
    Burgers.add(new Burger(this, 54));
    Burgers.add(new Burger(this, 78));
    spawnEnnemi = 19*plateau.getNbColonne()+97;
    spawnJoueur = plateau.getApparitionJoueur();
    ajoutEnnemi("Didier" , 'P');
    creature.get(0).setPlace( 19*plateau.getNbColonne()+4);
    ajoutCuisinier("Michel");
  }
}
