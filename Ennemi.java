import java.io.*;
public class Ennemi extends Joueur
{
  private char[] commandes;
  private boolean assomme;

 public Ennemi(Moteur m, String nom, char Symbole)
 {
   super(m, nom, Symbole);
   commandes = new char[]{'5', '1', '2', '3'};
   int i=0;
   while(super.getMoteur().getCreaturePlace(super.getMoteur().getPlateau().getApparitionJoueur()+i) != null)
      i++;
   setPlace(m.getSpawnEnnemi()+i);
   assomme=false;
   super.setSymbole(Symbole);
 }
 public Ennemi(Ennemi e, Moteur m)
 {
   super(m, e.getNom(),e.getSymbole());
   setPlace(e.getPlace());
   assomme = e.getAssomme();
   setCommandes(e.getCommandes());
 }


 public void Assomme()
 {
   this.assomme = true;
 }

 public boolean getAssomme(){return this.assomme;}

  public int getPlace(){return super.getPlace();}
  public void setPlace(int i){super.setPlace(i);}
  public Moteur getMoteur(){return super.getMoteur();}

  public void setCommandes(char [] tab)
  {
    commandes = tab;
  }

  public char[] getCommandes()
  {
    return this.commandes;
  }

  @Override
  public void run()
  {
    while(!getMoteur().fin())
    {
      if(!assomme)
      {
        int place = getPlace();
        Creature c = null;
        try
        {
          BufferedReader saisie=new BufferedReader(getFlux());
          if(saisie.ready())
          {
            char commande =(char)saisie.read();
            if(commande==commandes[0])
              {
                c = getMoteur().getCreaturePlace(getPlace()-getPlateau().getNbColonne());

                deplaceHaut();
              }
              else if(commande==commandes[1])
              {
                c = getMoteur().getCreaturePlace(getPlace()-1);
                deplaceGauche();
              }
              else if(commande==commandes[2])
              {
                c = getMoteur().getCreaturePlace(getPlace()+getPlateau().getNbColonne());
                deplaceBas();
              }
              else if(commande==commandes[3])
              {
                c = getMoteur().getCreaturePlace(getPlace()+1);
                deplaceDroite();
              }
              else
              {

              }
            }
        }
        catch(IOException e){}
        if( c != null && place != getPlace())
        {
          if(c.getSymbole() != 'C')
          {
            setPlace(place);
          }
          else
          {
            c.mort();
          }
        }
      }
    }
  }

  public void mort()
  {
    super.getMoteur().addScore(100);
    try
    {
    sleep((int)(Math.random()*100)+100);
    }catch(Exception e){}
    while(super.getMoteur().getCreaturePlace(super.getMoteur().getSpawnEnnemi()) != null)
    {
      try
      {
      sleep(100);
      }catch(Exception e){}
    }
    setPlace(super.getMoteur().getSpawnEnnemi());
  }

  public boolean equals(Ennemi e)
  {
    if(getSymbole() != e.getSymbole())
      return false;
    if(getNom() != e.getNom())
      return false;
    if(getPlace() != e.getPlace())
      return false;
    if(getAssomme() != e.getAssomme())
      return false;
    int i =0;
    while( i < 4)
    {
      if(commandes[i] != e.getCommandes()[i])
        return false;
      i++;
    }
    return true;
  }
}
