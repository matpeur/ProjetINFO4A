import java.io.*;
class Elements extends Thread implements Serializable
{


  Moteur m;
  int identifiant;
  Burger burger;
  char symbole;
  boolean pose;

  public Elements(Burger B1, int identifiant, char Symbole)
  {
	  burger = B1;
	  m = B1.getMoteur();
    this.identifiant = identifiant;
    this.symbole = Symbole;
    pose = false;
  }

  public Elements(Elements e, Burger b)
  {
    burger = b;
    m = b.getMoteur();
    identifiant = e.getIdentifiant();
    setSymbole(e.getSymbole());
  }

  public int getIdentifiant(){ return this.identifiant;}

  public void setIdentifiant( int id){ this.identifiant = id;}

  public Plateau getPlateau() { return m.getPlateau();}

  public char getSymbole()
  {
    return this.symbole;
  }

  public void setSymbole(char c)
  {
    this.symbole=c;
  }

  public boolean getPose(){ return pose;}

  public void run()
  {
    while(!pose && !m.fin())
    {
      Creature c =m.getCreaturePlace(getIdentifiant());
      if(c != null)
        if(c.getSymbole() == 'C')
        {
          setIdentifiant(getIdentifiant()+getPlateau().getNbColonne());
        }
      if(getPlateau().getIndice(getPlateau().getLigne(identifiant), getPlateau().getColonne(identifiant)) != 1)
      {
        if(possibliliteDeChute())
        {
          chute();
        }
      }
      try
      {
        sleep(100);
      }
      catch(Exception e){}
    }
  }

  public void chute()
  {
    int l = getPlateau().getLigne(getIdentifiant());;
    int c = getPlateau().getColonne(getIdentifiant());;
    while(getPlateau().getIndice(l, c) != 1&& getPlateau().getIndice(l, c) !=4 &&!getPose())
    {
	     setIdentifiant(getIdentifiant()+m.getPlateau().getNbColonne());
       l = getPlateau().getLigne(getIdentifiant());
       c = getPlateau().getColonne(getIdentifiant());
       Elements dessous = burger.getElement(l+1, c);
       if(dessous != null)
       {
         if(dessous.getPose())
          this.pose = true;
         else
         {
           dessous.setIdentifiant(dessous.getIdentifiant()+(m.getPlateau().getNbColonne())*2);
         }
      }
      Creature creature = m.getCreaturePlace(getIdentifiant()+getPlateau().getNbColonne());
      if(creature != null)
      {
        if(creature.getSymbole() != 'C')
          creature.mort();
      }
      try
      {
        sleep(200);
      }
      catch(Exception e){}
    }
    if(getPlateau().getIndice(l, c) == 4)
    {
      pose=true;
	  }
  }

  public boolean possibliliteDeChute()
  {
    boolean chute = true;
    int ligne = getPlateau().getLigne(getIdentifiant())-1;
    int colonne = getPlateau().getColonne(getIdentifiant());
    int i=-3;
    while(chute && i<4)
    {
      if(burger.getElement(ligne,colonne+i) != null)
        {
          chute = false;
        }
      i++;
    }
    return chute;
  }

  public boolean equals(Elements e)
  {
    if(this.getSymbole() != e.getSymbole())
    {
      return false;
    }
    return this.getIdentifiant() == e.getIdentifiant();
  }
}
