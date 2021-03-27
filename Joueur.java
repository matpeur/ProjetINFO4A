public class Joueur extends Creature
{
  char[] commandes
  boolean arret;

 public Joueur(Plateau I1,String nom, int id)
 {
   super(nom, id, I1);
   commandes= {'z', 'q', 's', 'd'};
   arret=false;
 }

  public String toString()
  {
    return "Joueur: "+super.getNom();
  }

  @Override
  public void run()
  {
    while(!arret)
    {
      BufferedReader saisie=new BufferedReader(new InputStreamReader(System.in));
      char commande =saisie.read()
      switch(commande)
      {
        case comandes[0] :
                          if (super.getPlateau().testMonte())
                          {
                            super.setPlace(supêr.getPlateau().getNbColonne()+super.getPlace());
                          }
        case comandes[1] :
        case comandes[2] :
        case comandes[3] :
      }
    }
  }

}
