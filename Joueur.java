import java.io.*;


public abstract class Joueur extends Creature
{
  protected char[] commandes;
  private PipedReader flux;


 public Joueur(Moteur m,String nom, char symbole)
 {
   super(nom, m);
   commandes = new char[]{'z', 'q', 's', 'd'};
   flux = new PipedReader();
   super.setSymbole(symbole);
 }

  public int getPlace(){return super.getPlace();}
  public void setPlace(int i){super.setPlace(i);}
  public Moteur getMoteur(){return super.getMoteur();}
  public PipedReader getFlux(){return flux;}

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

  public abstract void run();
  public abstract void mort();
  public abstract boolean getAssomme();

  @Override
  public void Assomme(){}
}
