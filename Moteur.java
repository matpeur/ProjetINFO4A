import java.util.*;

public class Moteur implements Serializable
{
  public Plateau plateau;
  private ArrayList<Creature> creature;
  public ArrayListe<Burger> Burgers;
  public ArrayListe<Elements> Cmp;
  int n;
  public int getNbJoueur()
  {
    return creature.size();
  }

  public Moteur()
  {
    plateau=new Plateau();
    creature = new ArrayList<Creature>();
    Burgers = new ArrayList<Burger>();
    Cmp=new ArrayList<Elements>();
    n=1;
  }

  public void ajoutJoueur(String Nom)
  {
    Joueur j=new Joueur(plateau, Nom, getNbJoueur(), ' ');
    creature.add((Creature)j);
  }


public void ajoutBurger(Burger B)
{   B=new Burger(Joueur j,10, plateau);//je ne sais pas koi mettre comme premier parametre du constructeur "joueur courant"
	Burgers.add(B);
}
public void ajoutComposants(Elements e)
{
   if(i%3<=1)
   {  if(i==1)
	  {   e= new Elements("Burger1PainDessous",5,Burgers.get(0),plateau) ;
		  cmp.add((PainDessous)e);

	   }
	  if(i==2)
	   {   e= new Elements("Burger1Salade",5,Burgers.get(0),plateau)  ;
		   cmp.add((SaladeViandeetc)e);

	   }
	  if(i==3)
	   {     e= new Elements("Burger1PainDessus",5,Burgers.get(0),plateau);
		     cmp.add((PainDessus)e);
		}
	}
	if(1<i%3<=2)
   {
	    if(i==4)
	  {   e= new Elements("Burger2PainDessous",5,Burgers.get(1),plateau) ;
		  cmp.add((PainDessous)e);

	   }
	  if(i==5)
	   {   e= new Elements("Burger2Salade",5,Burgers.get(1),plateau)  ;
		   cmp.add((SaladeViandeetc)e);

	   }
	  if(i==6)
	   {     e= new Elements("Burger2PainDessus",5,Burgers.get(1),plateau);
		     cmp.add((PainDessus)e);
		}
   }
	if(2<i%3<=3)
	{
	   if(i==7)
	  {   e= new Elements("Burger3PainDessous",5,Burgers.get(2),plateau) ;
		  cmp.add((PainDessous)e);

	   }
	  if(i==8)
	   {   e= new Elements("Burger3Salade",5,Burgers.get(2),plateau)  ;
		   cmp.add((SaladeViandeetc)e);

	   }
	  if(i==9)
	   {     e= new Elements("Burger3PainDessus",5,Burgers.get(2),plateau);
		     cmp.add((PainDessus)e);
		}
	}
	i++;
 //stp pourrais tu placé les composants du burger dans le plateau,en gros remplacé les 5 par leur position initiales
}
  public void ajoutCuisinier(String Nom)
  {
    Cuisinier c=new Cuisinier(plateau, Nom, getNbJoueur());
    creature.add((Creature)c);
  }

  public Creature getJoueur(int i)
  {
    return creature.get(i);
  }

  public Creature getJoueurPlace(int place)
  {
    int i=0;
    boolean flag = false;
    Creature r = null;
    while(i<getNbJoueur() && !flag)
    {
      if(getJoueur(i).getPlace()==place)
        {
          flag=true;
          r=getJoueur(i);
        }
      i++;
    }
    return r;
  }
//pour la visualisation des burgers j'ai fait une fonction affiche() dans Burger mais je pense ke c'est pas suffisant
// car il faudra toute affiché les burgers meme vide et les composants sur le plateau   donc je te laisse l'inserer dans celle ci
  public void visualisation()
  {
    for (int i=0; i<plateau.getTaille(); i++)
    {
      if(i!=0)
        {
          if(i%plateau.getNbColonne()==0)
            System.out.print("\n");
        }
      Joueur j = (Joueur)getJoueurPlace(i);
      if(j!=null)
        {
          System.out.print(j.getSymbole());
        }
      else
      {
        System.out.print(plateau.getChar(i));
      }
    }
  }

  public void start()
  {
    for (int i=0; i<getNbJoueur(); i++)
      getJoueur(i).start();
  }
}
