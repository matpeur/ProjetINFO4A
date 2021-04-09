import java.io.*;


public abstract class Joueur extends Creature
{
  char[] commandes;


 public Joueur(Moteur m,String nom, char symbole)
 {
   super(nom, m);
   commandes = new char[]{'z', 'q', 's', 'd'};

   super.setSymbole(symbole);
 }

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

  public String toString()
  {
    return "Joueur: "+super.getNom();
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

  public abstract void mort();
  public abstract boolean getAssomme();

  @Override
  public void Assomme(){}
}
