public abstract class Creature extends Thread
{
  private String nom;
  private int identifiant;
  private Moteur moteur;
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
    return moteur.getPlateau();
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
    moteur=m;
    setPlace(19*getPlateau().getNbColonne()+2);
    setArret(false);
  }

  public abstract void run();

  public synchronized void deplaceHaut()
  {
    if (getPlateau().testMonte(getPlace()) && moteur.getJoueurPlace(getPlace()-getPlateau().getNbColonne())==null)
    {
    setPlace(getPlace()-getPlateau().getNbColonne());
    }
  }

  public synchronized void deplaceDroite()
  {
    if (getPlateau().testDroite(getPlace()) && moteur.getJoueurPlace(1+getPlace())==null)
    {
    setPlace(1+getPlace());
    }
  }

  public synchronized void deplaceGauche()
  {
    if (getPlateau().testGauche(getPlace()) && moteur.getJoueurPlace(getPlace()-1)==null)
    {
    setPlace(getPlace()-1);
    }
  }

  public synchronized void deplaceBas()
  {
    if (getPlateau().testDescend(getPlace()) && moteur.getJoueurPlace(getPlateau().getNbColonne()+getPlace())==null)
    {
    setPlace(getPlateau().getNbColonne()+getPlace());
    }
  }
}
