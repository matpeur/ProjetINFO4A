public class Ennemis extends Creature
{

    public Ennemis(Plateau I1, String nom, int id)
    {
      super(nom, id, I1);
    }

    public void capturer(){}

    public void setPlace(int i )
    {
      super.setPlace(i);
    }

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
            if(P.getLigne(id1)>P.getLigne(id2)&&(P.testMonte(id1)))
            {
              setPlace(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)));
              distance++;
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
            }
            else
            {
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
              }
            }

          }
      }
      while(id1!=id2);
      setPlace(p);
      return distance;
    }

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
      }
    }

    public void run()
    {
      while (!super.getArret())
        {
          //deplacement
        }
    }
}
