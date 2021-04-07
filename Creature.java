import java.io.*;
public abstract class Creature extends Thread implements Serializable
{
  private String nom;
  private int identifiant;
  private Moteur moteur;
  private int place;
  private char symbole;

  public int getIdentifiant()
  {
    return this.identifiant;
  }

  public void setIdentifiant(int id)
  {
    this.identifiant=id;
  }

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
    this.moteur = m;;
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

  public Creature(String s, int id, Moteur m)
  {
    nom=s;
    setIdentifiant(id);
    setMoteur(m);
    setPlace(19*getPlateau().getNbColonne()+2);
  }

  public abstract void run();
  public abstract void mort();

  public void deplaceHaut()
  {
    if (getPlateau().testMonte(getPlace()))
    {
    setPlace(getPlateau().getNbColonne()-getPlace());
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

}
