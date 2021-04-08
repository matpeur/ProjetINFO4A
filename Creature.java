public class Cuisinier extends Joueur
{
  boolean poivre ;
  int vie;
   
  public Cuisinier (Moteur m, String nom, int id)
  {
   super(m, nom, id, 'C');
   this.poivre = false;
   this.vie=3;
    
  }


  public void  poivrer()
  {   Plateau I=super.getMoteur().getPlateau();
      int L=super.getMoteur().I.getLigne(super.getPlace());
      int C=super.getMoteur().I.getColonne(super.getPlace());
      if(super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).getClass()==EnnemiIA)
       {
		   
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).setAsome();
	   }
	   if((super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C))).getClass()==EnnemiIA)
       {
		   
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).setAsome();
	   }
	   if(super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).getClass()==EnnemiIA)
       {
		  
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).setAsome();
	   }
	   if((super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1))).getClass()==EnnemiIA)
       {
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1)).setAsome();
		   super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).setAsome();
	   }
  
  }

  public void mort()
  {
    setPlace(19*super.getPlateau().getNbColonne()+2);
    vie--;
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
          }
          else if(commande==commandes[1])
          {
            deplaceGauche();
          }
          else if(commande==commandes[2])
          {
            deplaceBas();
          
          }
          else if(commande==commandes[3])
          {
            deplaceDroite();
          }else if(commmande==commandes[4])
          {   poivrer();  }
        }
        catch(IOException e){e.printStackTrace();}
    }
  }
}

