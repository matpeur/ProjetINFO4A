import java.io.*;
public abstract class Creature extends Thread implements Serializable
{
  private String nom;
  private Moteur moteur;
  private int place;
  private char symbole;

  public char getSymbole()
  {
    return this.symbole;
  }

  public void setSymbole(char c)
  {
    this.symbole=c;
  }

  public Plateau getPlateau()
  {
    return this.moteur.getPlateau();
  }

  public void setMoteur(Moteur m)
  {
    this.moteur = m;
  }

  public Moteur getMoteur()
  {
    return moteur;
  }

  public void setNom(String nom)
  {
    this.nom=nom;
  }

  public String getNom()
  {
    return this.nom;
  }

  public int getPlace()
  {
    return this.place;
  }

  public void setPlace(int i)
  {
    this.place = i;
  }

  public Creature(String s, Moteur m)
  {
    nom=s;
    setMoteur(m);
  }

  public abstract void run();
  public abstract void mort();
  public abstract void Assomme();
  public abstract boolean getAssomme();
  public abstract char[] getCommandes();

  public void deplaceHaut()
  {
    if (getPlateau().testMonte(getPlace()))
    {
    setPlace(getPlace()-getPlateau().getNbColonne());
    }
  }

  public void deplaceDroite()
  {
    if (getPlateau().testDroite(getPlace()))
    {
    setPlace(1+getPlace());
    }
  }

  public void deplaceGauche()
  {
    if (getPlateau().testGauche(getPlace()))
    {
    setPlace(getPlace()-1);
    }
  }

  public void deplaceBas()
  {
    if (getPlateau().testDescend(getPlace()))
    {
    setPlace(getPlateau().getNbColonne()+getPlace());
    }
  }

  public boolean equals(Creature c)
  {
    if(c.getClass() != this.getClass())
      return false;
    if(this.getSymbole() != c.getSymbole())
      return false;
    return this.getPlace() == c.getPlace();
  }

}
