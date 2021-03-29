import java.io.*;

public class Joueur extends Creature
{
  char[] commandes;

 public Joueur(Plateau I1,String nom, int id, char symbole)
 {
   super(nom, id, I1);
   commandes = new char[]{'z', 'q', 's', 'd'};
   arret=false;
   super.setSymbole(symbole);
 }

  public String toString()
  {
    return "Joueur: "+super.getNom();
  }

  @Override
  public void run()
  {
    while(!super.getFin())
    {
      try
      {
        BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
        char commande =(char)saisie.read();
        if(commande==commandes[0])
          {
            deplaceHaut();
          }
          else if(commande==commandes[1])
          {
            deplaceDroite();
          }
          else if(commande==commandes[2])
          {
            deplaceBas();
          }
          else if(commande==commandes[3])
          {
            deplaceDroite();
          }
        }
        catch(IOException e){e.printStackTrace();}
    }
  }

}
