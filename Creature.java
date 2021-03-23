public abstract class Creature extends Thread
{
  private String nom;
  private int identifiant;
  private Interface plateau;

  public int getIdentifiant()
  {
    return this.identifiant;
  }

  public void setIdentifiant(int id)
  {
    this.identifiant=id;
  }

  public Interface getInterface()
  {
    return this.plateau;
  }

  public void setInterface(Interface it)
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

  public Creature(String s, int id, Interface it)
  {
    nom=s;
    setIdentifiant(id);
    setInterface(it);
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
