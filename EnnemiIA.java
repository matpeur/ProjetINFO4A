public class EnnemiIA extends Creature
{
    private boolean assomme;
    private boolean tue;

    public String getNom()
    {
      return super.getNom();
    }

    public char[] getCommandes()
    {
      return new char[0];
    }

    public boolean getTue(){return tue;}

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
      while(super.getMoteur().getCreaturePlace(super.getMoteur().getSpawnEnnemi()-i) != null)
         i++;
      setPlace(m.getSpawnEnnemi()+i);
      assomme=false;
      tue = false;
    }

    public EnnemiIA()
    {
      super("", null);
    }

    public EnnemiIA(EnnemiIA e, Moteur m)
    {
      super(e.getNom(), m);
      setPlace(e.getPlace());
      setSymbole(e.getSymbole());
      assomme = e.getAssomme();
      tue = e.getTue();
    }


    public void Assomme()
    {
      this.assomme = true;
	  }

    public boolean getAssomme(){return this.assomme;}

    public void mort()
    {
      super.getMoteur().addScore(100);
      assomme = false;
      while(super.getMoteur().getCreaturePlace(super.getMoteur().getSpawnEnnemi()) != null)
      {
        try
        {
          sleep((int)(Math.random()*100)+100);
        }catch(Exception e){e.printStackTrace();}
      }
      setPlace(super.getMoteur().getSpawnEnnemi());
      this.tue = true;
    }


    public int deplacement(int idcible)
    {
      int direction=0;
      Plateau P = super.getMoteur().getPlateau();
      if(P.getLigne(getPlace())>P.getLigne(idcible))
          direction = rechercheEchelle(P.getLigne(getPlace())-1);
      else if(P.getLigne(getPlace())<P.getLigne(idcible))
          direction = rechercheEchelle(P.getLigne(getPlace())+1);
      else if(P.getColonne(getPlace())>P.getColonne(idcible))
          direction = 4;
      else
          direction = 2;
      return direction;
    }

    public Cuisinier choisicible()
    {
      int i;
      do
      {
        i = (int) Math.random()*getMoteur().getNbCreature();
      } while (getMoteur().getCreature(i).getSymbole() != 'C');
      return (Cuisinier)getMoteur().getCreature(i);
    }

    private int rechercheEchelle(int ligneRecherche)
    {
      Plateau P = super.getMoteur().getPlateau();
      int identifiant = getPlace();
      int colonne = P.getColonne(identifiant);
      int ligne = P.getLigne(identifiant);
      int gauche = 1;
      int droite = 1;
      if(P.getIndice(ligneRecherche, colonne) != 0)
        if(ligneRecherche<ligne)
          return 1;
        else
          return 3;
      while(P.getIndice(ligne, colonne-gauche) != 0 || P.getIndice(ligne, colonne+droite) != 0)
      {
        if(P.getIndice(ligne, colonne-gauche) != 0)
          if(P.getIndice(ligneRecherche, colonne-gauche) != 0)
            return 4;
          else
            gauche++;
        if(P.getIndice(ligne, colonne+droite) != 0)
          if(P.getIndice(ligneRecherche, colonne+droite) != 0)
            return 2;
          else
            droite++;
      }
      return 0;
    }

    public void run()
    {
      Moteur m = getMoteur();
      while(!m.fin())
      {
        if(getTue())
        {
          try
          {
            sleep(2000);
            tue=false;
          }
          catch(Exception e){e.printStackTrace();}
        }
        Cuisinier cible = choisicible();
        int i = 0;
        while(i< 10 && !m.fin() && !assomme)
        {
          m = getMoteur();
          int deplacement = deplacement(cible.getPlace());
          Creature c = null;
          int place = getPlace();
          int arrivee = place;
          switch(deplacement)
          {
            case 1 : arrivee = getPlace()-m.getPlateau().getNbColonne();
                     c=m.getCreaturePlace(arrivee);
                     deplaceHaut();
                     break;
            case 2 : arrivee = getPlace()+1;
                     c=m.getCreaturePlace(arrivee);
                     deplaceDroite();
                     break;
            case 3 : arrivee = getPlace()+m.getPlateau().getNbColonne();
                     c=m.getCreaturePlace(arrivee);
                     deplaceBas();
                     break;
            case 4 : arrivee = getPlace()-1;
                     c=m.getCreaturePlace(arrivee);
                     deplaceGauche();
                     break;
          }
          if( c != null && arrivee == getPlace())
          {
            if(c.getSymbole() != 'C')
            {
              setPlace(place);
            }
            else
            {
              c.mort();
              System.out.println(c.getNom()+" perd une vie.");
            }
          }
          i++;
          try
          {
            sleep(500);
          }
          catch(Exception e){}
        }
      }
    }
}
