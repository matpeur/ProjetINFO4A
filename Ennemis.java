public class Ennemis extends Creature
{

public Ennemis(Plateau I1,String nom, int id)
{

super(I1,nom,id);



}

void capturer(){}

void setIndice(int i )
{
   this.id=i;
}
/*int distmin(int id1 ,int id2 )
{ int p=id1;
    int distance=0;
   do{
  
    if(getLigne(id2)>getLigne(id1)&&(testDescend(id1)))
      {
         setIndice(getID(getLigne(id1)+1,getColonne(id1));
         distance++;
        if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
             setIndice(getID(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getID(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }

       }
    else
    {
        if(getLigne(id1)>getLigne(id2)&&(testMonte(id1)))
       { setIndice(getID(getLigne(id1)-1,getColonne(id1));
               distance++;
          if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
            setIndice(getID(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getID(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }

       }else
       {



          if(getLigne(id1)==getLigne(id2||getligne(id1)==getLigne(this.i.getTaille())||getLigne(id1)==getLigne(0))
          {
           if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
            setIndice(getID(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getID(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }
         }


       }

    }
 }while(id1!=id2);
 setIndice(p);
 return distance;

}*/
int distmin(inti1,inti2)
{​​​​​​​​    int col=I1.getColonne(i1);
     int ligne=I1.getLigne(i1);
     int col2=I1.getColonne(i2); 
     int ligne2=I1.getLigne(i2);
     int distance=0;
do{​​​​​​​​
if(Grille[getID(ligne+1,col)]==0)
      {​​​​​​​​
         distance=distance+1;
         ligne=ligne+1;  
 
      }​​​​​​​​  
else
    {​​​​​​​​  //printf("hello ");
      if(Grille[getID(ligne,col+1)]==0)
       {​​​​​​​​  
         distance=distance+1;
         col=col+1;  
       }​​​​​​​​
      else
     {​​​​​​​​
       if(0<ligne)
         {​​​​​​​​
           if(Grille[getID(ligne-1,col)]==0)
              {​​​​​​​​  Grille[getID(ligne,col)]=2;
                  distance=distance-1;
                  ligne=ligne-1;  
              }​​​​​​​​
 
         }​​​​​​​​
       else
              {​​​​​​​​
               if(0<col)
                  {​​​​​​​​  if(Grille[getID(ligne,col-1)]==0)
                     {​​​​​​​​
                      Grille[getID(ligne,col)]=2;  
                      col=col-1;
                      distance=distance-1;
                      Systeme.out.println("je vais marche arriere ");
                     System.out.println(getID(ligne,col));
                     }​​​​​​​​
 
                  }​​​​​​​​
               else
                  {​​​​​​​​
                      System.out.println("le labyrinthe n'est pas connexe");
                  }​​​​​​​​
 
              }​​​​​​​​


 
      }​​​​​​​​



 
    }​​​​​​​​

 
  }​​​​​​​​ while(getID(ligne,col)!=i2);
return distance;
}​​​​​​​​

void deplaceEnnemi(int id1,int id2)
{    int p=id1;
     int icteur=100000000000;
      if(testMonte(id1)&&icteur>distmin(id1,id2))
      {
         setIndice(getID(getLigne(id1)+1,getColonne(id1)));
         icteur=distmin(p,id2); 
      }
       if(testDescend(id1)&&icteur>distmin(getID((getLigne(id1)-1,getColonne(id1)),id2))
      { 
        
        icteur=distmin(getID((getLigne(id1)-1,getColonne(id1)),id2);
        setIndice(getID(getLigne(id1)-1,getColonne(id1)));
        setIndice(p);
         
      }
      if(testDroite(id1)&&icteur>distmin(getID(getLigne(id1),getColonne(id1)+1),id2))
      { 
        icteur=distmin(getID((getLigne(id1),getColonne(id1)+1),id2),id2);
        setIndice(p) ;
        setIndice(getID(getLigne(id1),getColonne(id1)+1));
         
      }
       if(testGauche(id1)&&icteur>distmin(getID(getLigne(id1),getColonne(id1)-1),id2))
      {
        icteur=distmin(getID(getLigne(id1),getColonne(id1)-1),id2);
        setIndice(p) ;
        setIndice(getID(getLigne(id1),getColonne(id1)-1));
       
      }
}





















}
