import java.io.*;


public abstract class Joueur extends Creature implements Serializable
{
  char[] commandes;

   int cotechoisi;

 public Joueur(Moteur m,String nom, int id, char symbole)
 {
   super(nom, id, m);
   commandes = new char[]{'z', 'q', 's', 'd'};
   cotechoisi=0;
   super.setSymbole(symbole);
 }




  public String toString()
  {
    return "Joueur: "+super.getNom();
  }

 @Override
  public void run()
  {
    while(true)
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        char commande =(char)saisie.read();
        if(commande==commandes[0])
          {
            deplaceHaut();
            cotechoisi=0;
          }
          else if(commande==commandes[1])
          {
            deplaceGauche();
             cotechoisi=1;
          }
          else if(commande==commandes[2])
          {
            deplaceBas();
             cotechoisi=2;
          }
          else if(commande==commandes[3])
          {
            deplaceDroite();
             cotechoisi=3;
          }
        }
        catch(IOException e){e.printStackTrace();}
    }
  }
  public int Cotechoisi() {return this.cotechoisi;}
  public abstract void mort();

}
