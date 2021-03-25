public class Joueur extends Creature
{
 int score ;
 int vies ;
 boolean poivre ;

 public Joueur(Plateau I1,String nom, int id)
 {
   super(nom, id,I1);
   vies=3;
   poivre=true;
   score = 0;
 }

  public String toString()
  {
    return "Joueur: "+super.getNom()+"Score: "+this.score;
  }


  public void deplacement(int i1,int i2){super.getPlateau().bouge(i1,i2);}

  public void score (int s ){ this.score=s;}

  public int getscore(){return score;}

  public void augmenteScore(int s){this.score=score+1;}

  public void dimunieScore(int s){this.score=score-1;}

  public void poivrer()
  {

  }

  @Override
  public void run()
  {
    System.out.println("Je suis "+toString());
  }

}
