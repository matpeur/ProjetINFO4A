import java.io.*;
public class Cuisinier extends Joueur implements Serializable
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

  public void mort()
  {
    setPlace(19*super.getPlateau().getNbColonne()+2);
    vie--;
  }
}
