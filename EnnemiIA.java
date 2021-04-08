public class EnnemiIA extends Creature
{
    private boolean assomme;

    public String getNom()
    {
      return super.getNom();
    }

    public void setPlace(int i )
    {
      super.setPlace(i);
    }

    public int getPlace()
    {
      return super.getPlace();
    }

    public EnnemiIA(Moteur m, String nom)
    {
      super(nom, m);
      int i=0;
      while(super.getMoteur().getCreaturePlace(super.getMoteur().getPlateau().getApparitionJoueur()+i) != null)
         i++;
      setPlace(m.getSpawnEnnemi()+i);
      assomme=false;
    }

    public EnnemiIA()
    {
      super("", null);
    }

    public EnnemiIA(EnnemiIA e, Moteur m)
    {
      super(e.getNom(), m);
      setPlace(e.getPlace());
      assomme = e.getAssomme();
    }


    public void Assomme()
    {
      this.assomme = true;
	  }

    public boolean getAssomme(){return this.assomme;}

    public void mort()
    {
      super.getMoteur().addScore(100);
      try
      {
      sleep((int)(Math.random()*100)+100);
      }catch(Exception e){}
      while(super.getMoteur().getCreaturePlace(super.getMoteur().getSpawnEnnemi()) != null)
      {
        try
        {
        sleep(100);
        }catch(Exception e){}
      }
      setPlace(super.getMoteur().getSpawnEnnemi());
    }


public int distmin(int id1, int id2)
{

      int distance=0;
      Plateau P = super.getMoteur().getPlateau();
      int place;
      do
      {
        if(P.getLigne(id2)>P.getLigne(id1)&&(P.testDescend(id1)))
        {
         place=P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1));
          distance++;
          if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
            {
              place=P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1);
              distance++;

            }
          else
            {
              if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
              {
               place=P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1);
                distance++;
              }

            }

       }
    else
    {
       if(P.getLigne(id1)>P.getLigne(id2)&&(P.testMonte(id1)))
       { setPlace(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)));
               distance++;
          if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
            {
              distance++;
            }
            else
              {
                  if(P.getColonne(id2)>P.getColonne(id1)&&P.testGauche(id1))
                  {

                   distance++;
                  }


            }

        }
        else
         {
           if(P.getLigne(id1)>P.getLigne(id2)&&(P.testMonte(id1)))
           {

              distance++;
              if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
              {


                distance++;
              }
              else
              {
                if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
                {

                  distance++;
                }else
                 {
                  if(P.getColonne(id2)>P.getColonne(id1)&&P.testGauche(id1))
                  {

                   distance++;
                  }
                }
              }
            }
            else
             {
              if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
               {
                   distance++;
                if(P.getLigne(id1)==P.getLigne(id2)||P.getLigne(id1)==P.getLigne(P.getTaille())||P.getLigne(id1)==P.getLigne(0))
                {
                 if(P.getColonne(id2)>P.getColonne(id1)&&P.testDroite(id1))
                 {

                  distance++;
                 }
                 else
                 {
                  if(P.getColonne(id1)>P.getColonne(id2)&&P.testGauche(id1))
                  {

                    distance++;
                  }
                }

              }
            }

          }
      }

    }

 }while(id1!=id2);

      return distance;
}

    void deplaceEnnemi(int id1,int id2)
    {
      int icteur=1000000000;
      int place=0;
      Plateau P=super.getPlateau();
      do
      {

        if(P.testMonte(id1)&&icteur>distmin(id1,id2))
        {
          place=P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1));
          icteur=distmin(P.getIdentifiant(P.getLigne(id1)-1,P.getColonne(id1)),id2);
        }
       if(P.testDescend(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1)),id2))
       {
          place=P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1));
          icteur=distmin(P.getIdentifiant(P.getLigne(id1)+1,P.getColonne(id1)),id2);
       }
       if(P.testDroite(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1),id2))
       {
          place=P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1);
          icteur=distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)+1),id2);
       }
       if(P.testGauche(id1)&&icteur>distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1),id2))
       {
          place=P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1);
          icteur=distmin(P.getIdentifiant(P.getLigne(id1),P.getColonne(id1)-1),id2);
       }
     }
     while(id1!=id2);
     id1=place;
    }

 public static void main (String[] args)
  {
	Moteur m=new Moteur();
	Thread t1=new EnnemiIA(m,"ghjk");
	t1.start();
  }

  public void run()
  {

  }


}
