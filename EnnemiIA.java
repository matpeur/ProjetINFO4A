public class EnnemiIA extends Creature
{
 boolean b ;
    public EnnemiIA(Moteur m, String nom, int id)
    {
      super(nom, id, m);
      setPlace(19*getPlateau().getNbColonne()+48);
      b=false ;
      
    }

    
   public setAsome()
   {
	    int i=0;
	    while(i!=15)
	    { this.b=true;
	     i++;
	    }
	}
   public getAsomme(){return this.b;}
    public void mort(){ }

    public void setPlace(int i )
    {
      super.setPlace(i);
    }

<<<<<<< HEAD
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
=======
    public int distmin(int id1, int id2)
    {
      int p=id1;
      int distance=0;
      Plateau P = super.getPlateau();
      do
      {
        if(P.getLigne(id2)>P.getLigne(id1)&&(P.testDescend(id1)))
        {
          setPlace(P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1)));
          distance++;
          if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
            {
              setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1));
              distance++;
>>>>>>> 32a4fecda68218d103522e5fbc0d97a37607061f
            }
          else
            {
              if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
              {
<<<<<<< HEAD
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
=======
                setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1));
                distance++;
              }
>>>>>>> 32a4fecda68218d103522e5fbc0d97a37607061f
            }
          }
          else
          {
            if(P.getLigne(id1)>P.getLigne(id2)&&(P.testMonte(id1)))
            {
              setPlace(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)));
              distance++;
              if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
              {
<<<<<<< HEAD
                setIndice(getID(getLigne(id1),getColonne(id1)-1);
=======
                setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1));
>>>>>>> 32a4fecda68218d103522e5fbc0d97a37607061f
                distance++;
              }
              else
              {
                if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
                {
                  setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1));
                  distance++;
                }
              }
            }
            else
            {
<<<<<<< HEAD
            setIndice(getID(getLigne(id1),getColonne(id1)+1);
                distance++;
            }
          else
            { if(getColonne(id1)>getColonne(id2)&&testGauche(id1))
              {
                setIndice(getID(getLigne(id1),getColonne(id1)-1);
                distance++;
=======
              if(P.getLigne(id1)==P.getLigne(id2)||P.getLigne(id1)==P.getLigne(P.getTaille())||P.getLigne(id1)==P.getLigne(0))
              {
                if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
                {
                  setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1));
                  distance++;
                }
                else
                {
                  if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
                  {
                    setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1));
                    distance++;
                  }
                }
>>>>>>> 32a4fecda68218d103522e5fbc0d97a37607061f
              }
            }

          }
      }
      while(id1!=id2);
      setPlace(p);
      return distance;
    }

<<<<<<< HEAD
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

=======
    void deplaceEnnemi(int id1,int id2)
    {
      int p=id1;
      int icteur=1000000000;
      Plateau P=super.getPlateau();
      if(P.testMonte(id1)&&icteur>distmin(id1,id2))
      {
        setPlace(P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1)));
         icteur=distmin(p,id2);
      }
       if(P.testDescend(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)),id2))
      {

        setPlace(p) ;
        setPlace(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)));
        icteur=distmin(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)),id2);
      }
      if(P.testDroite(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1),id2))
      {
        setPlace(p);
        setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1));
        icteur=distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1),id2);
      }
      if(P.testGauche(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1),id2))
      {
        setPlace(p) ;
        setPlace(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1));
        icteur=distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1),id2);
>>>>>>> 32a4fecda68218d103522e5fbc0d97a37607061f
      }
    }

    public void run()
    {
      while (!super.getArret())
        {
          deplaceGauche();
          
        }
    }
}

