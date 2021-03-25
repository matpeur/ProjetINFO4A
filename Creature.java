public abstract class Creature extends Thread
{
  private String nom;
  private int identifiant;
  private Plateau plateau;
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

  public void setChar(char c)
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
  }

  public abstract void run();

  public synchronized void deplacement(int i)
  {
    switch(i){
      case 1:
      case 2:
      case 3:
    }
  }

}
