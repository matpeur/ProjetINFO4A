public class Cuisinier extends Joueur
{
  boolean poivre ;
  int vie;

  public Cuisinier (Plateau i, String nom, int id )
  {
   super(i, nom, id);
   this.poivre = true;
   this.vie=3;
   super.super.setSymbole('C');
  }


  public void poivrer()
  {

  }

  public void deplacement(int i1, int i2)
  {
    super.getPlateau().bouge(i1,i2);
  }
}
