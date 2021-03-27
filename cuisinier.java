public class Cuisinier extends Joueur
{
  boolean poivre ;
  int vie;

  public Cuisinier (Plateau i, String nom, int id)
  {
   super(i, nom, id, 'C');
   this.poivre = true;
   this.vie=3;
  }


  public void poivrer()
  {

  }
}
