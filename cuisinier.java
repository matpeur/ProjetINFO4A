public class Cuisinier extends Joueur
{
  boolean poivre ;
  int vie;

  public Cuisinier (Moteur m, String nom, int id)
  {
   super(m, nom, id, 'C');
   this.poivre = true;
   this.vie=3;
  }


  public void poivrer()
  {

  }
}
