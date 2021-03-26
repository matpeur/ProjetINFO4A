public class Ennemis extends Creature
{

public Elements(Plateau I1,String nom, int id)
{

super(I1,nom,id);



}


void capturer(){}

void setIndice(int i )
{
   this.id=i;
}
int distmin(int id1 ,int id2 )
{   int p=id1;
   do{
     int distance=0;
    if(getLigne(id2)>getLigne(id1)&&(testDescend(id1)))
      {
         setIndice(getIndice(getLigne(id1)+1,getColonne(id1));
         distance++;
        if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
             setIndice(getIndice(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getIndice(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }
       
       }
    else 
    {
        if(getLigne(id1)>getLigne(id2)&&(testMonte(id1)))
       { setIndice(getIndice(getLigne(id1)-1,getColonne(id1));
               distance++;
          if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
            setIndice(getIndice(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getIndice(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }

       }else 
       {



          if(getLigne(id1)==getLigne(id2||getligne(id1)==getLigne(this.i.getTaille())||getLigne(id1)==getLigne(0))
          {
           if(getColonne(id2)>getColonne(id1)&&testDroite(id1))
            {
            setIndice(getIndice(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getIndice(getLigne(id1),getColonne(id1)-1);
                distance++;
              }

            }
         }
    

       }

    }
 }while(id1!=id2);
 setIndice(p);
 return distance;

}

void deplaceEnnemi(){}





















}