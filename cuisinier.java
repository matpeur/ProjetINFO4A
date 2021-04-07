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
  {
     Plateau I=m.getplateau();
     int L=I.getLigne(this.id);
     int C=I.getColonne(this.id);
     boolean a=(super.getCotechoisi()==0&&(I.getIndice[L-1,C]==2));
     boolean b=(super.getCotechoisi()==1&&(I.getIndice[L,C-1]==2));
     boolean c=(super.getCotechoisi()==2&&( I.getIndice[L+1,C]==2));
     boolean d=(super.getCotechoisi()==3&&(I.getIndice[L,C-1]==2));// 2  car toutefois  on mettra à 2 la case occupée par un ennemi 
     if(a||b||c||d)    
           poivre=true;
  
  }

  public void mort()
  {
    setPlace(19*super.getPlateau().getNbColonne()+2);
    vie--;
  }
}

