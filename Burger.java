public class Burger{
	
String tab;
Joueur joueurCourant 
Plateau I;
int n;int m;int tb;
   public Burger(Joueur j,int valeurBurger),Plateau B)
   { n=0;
	 m=0;
	 I=B;
	 tab=new String[3];
	 tb=new int[3];
     JoueurCourant=j;    	
   }
   
  void push(String nom)  
  {
	  tab[n]=nom;n++;
   }-
   void pushid(int i)  
  {
	  tb[m]=i;m++;
   }
void affichage()
{ for(int J=0;j<3)
  { for (int i=0; i<plateau.getTaille(); i++)
    {	
	 if(tb[j]==I.getIndice(I.getLigne(i),I.getColonne(i)))
	   {
	     if(j==0)
	      System.out.print("****");
	     if(j==1)
	       System.out.print("++++");
	     if(J==2)
	      System.out.print("-----")
	   }
	} 
   }
}
 
public void ajoutComposant(String nom,int IdPlateau)
{
   if(n<3)
    { 
		push(nom);   
        pushid(IdPlateau);
    }
     if(n==3)
      { 
		   joueurCourant.setScore(joueurCourant.getScore()+this.valeurBurger);
      
       }
 }   
    
}


}
