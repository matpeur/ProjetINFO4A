public class Joueur extends Creature
{
 Interface1 I;
 int score ;
 int vies ;
 int poivres ;
 int position;
 String nom;

 public Joueur(Interface1 I1,int vies1,int poivres1,positionss,String nom)
 {
   this.nom=nom;
   I=I1;
   vies=vies1;
   poivres=poivres1;
   position=positionss;
 }

public void affiche()
{
 System.out.println("Joueur: "+this.nom+"Score: " this.score);
}

  public void deplacement(int i1,int i2){I.bouge(i1,i2);}

  public void score (int s ){ this.score=s;}

  public int getscore(){return score;}

  public void augmenteScore(int s){this.score=score+1;}

  public void dimunieScore(int s){this.score=score-1;}

  public void poivrer(){}
}
