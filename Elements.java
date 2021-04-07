import java.io.*;
class Elements extends Thread implements Serializable
{


  Moteur m;
  int identifiant;
  Burger burger;
  char symbole;
  boolean pose;

  public Elements(Burger B1,Moteur moteur, int identifiant, char Symbole)
  {
	  burger = B1;
	  m = moteur;
    this.identifiant = identifiant;
    this.symbole = Symbole;
    pose = false;
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
    System.out.println(identifiant);
    while(!pose)
    {
      Creature c =m.getCreaturePlace(getIdentifiant()-getPlateau().getNbColonne());
      if(c != null)
        if(c.getSymbole() == 'C')
        {
          setIdentifiant(getIdentifiant()+getPlateau().getNbColonne());
        }
        if(getPlateau().getIndice(getPlateau().getLigne(identifiant), getPlateau().getLigne(identifiant)) != 1)
        {
          if(possibliliteDeChute())
          {
            chute();
          }
        }
        c = m.getCreaturePlace(getIdentifiant()+getPlateau().getNbColonne());
        if(c != null)
        {
          if(c.getSymbole() != 'C')
            c.mort();
        }
    }
  }

  public void chute()
  {
    int l;
    int c;
    do
    {
	     l = getPlateau().getLigne(getIdentifiant());
	     c = getPlateau().getColonne(getIdentifiant());
	     setIdentifiant(l+m.getPlateau().getNbColonne()*c);
       if(burger.getElement(l+1, c) != null)
       {
         if(burger.getElement(l+1, c).getPose())
          this.pose = true;
         else
         {
           burger.getElement(l+1, c).chute();
         }
      }
    }
    while(getPlateau().getIndice(l, c) != 1&& getPlateau().getIndice(l, c)!=4 && !getPose());
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
        chute = false;
      i++;
    }
    return chute;
  }

  public boolean equals(Elements e)
  {
    if(this.getSymbole() != e.getSymbole())
      return false;
    return this.getIdentifiant() == e.getIdentifiant();
  }
}
