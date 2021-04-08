import java.io.*;
public class Ennemi extends Joueur
{
  private char[] commandes;
  private boolean assomme;

 public Ennemi(Moteur m, String nom, char Symbole)
 {
   super(m, nom, Symbole);
   commandes = new char[]{'z', 'q', 's', 'd'};
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
    while(true)
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        char commande =(char)saisie.read();
        if(commande==commandes[0])
          {
            deplaceHaut();
          }
          else if(commande==commandes[1])
          {
            deplaceGauche();
          }
          else if(commande==commandes[2])
          {
            deplaceBas();

          }
          else if(commande==commandes[3])
          {
            deplaceDroite();
          }
        }
        catch(IOException e){e.printStackTrace();}
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
