public abstract class Creature extends Thread
{
  private String nom;
  private int identifiant;
  private Plateau plateau;
  private int place;
  private char symbole;
  private boolean arret;

  public void setArret(boolean a)
  {
    arret=a;
  }

  public boolean getArret()
  {
    return this.arret;
  }

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
    return this.plateau;
  }

  public void setPlateau(Plateau it)
  {
    plateau=it;
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

  public Creature(String s, int id, Plateau it)
  {
    nom=s;
    setIdentifiant(id);
    setPlateau(it);
    setPlace(19*getPlateau().getNbColonne()+2);
    setArret(false);
  }

  public abstract void run();

  public synchronized void deplaceHaut()
  {
    if (getPlateau().testMonte(getPlace()))
    {
    setPlace(getPlace()-getPlateau().getNbColonne());
    }
  }

  public synchronized void deplaceDroite()
  {
    if (getPlateau().testDroite(getPlace()))
    {
    setPlace(1+getPlace());
    }
  }

  public synchronized void deplaceGauche()
  {
    if (getPlateau().testGauche(getPlace()))
    {
    setPlace(getPlace()-1);
    }
  }

  public synchronized void deplaceBas()
  {
    if (getPlateau().testDescend(getPlace()))
    {
    setPlace(getPlateau().getNbColonne()+getPlace());
    }
  }
}
