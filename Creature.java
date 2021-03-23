public abstract class Creature extends Thread
{
  private String nom;
  private int identifiant;
  private Plateau plateau;

  public int getIdentifiant()
  {
    return this.identifiant;
  }

  public void setIdentifiant(int id)
  {
    this.identifiant=id;
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
