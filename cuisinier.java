import java.io.*;

public class Cuisinier extends Joueur
{
  boolean poivre ;
  int vie;

  public Cuisinier (Moteur m, String nom)
  {
   super(m, nom, 'C');
   this.poivre = false;
   this.vie=3;
   int i = 0;
   while(super.getMoteur().getCreaturePlace(super.getMoteur().getPlateau().getApparitionJoueur()+i) != null)
      i++;
   super.setPlace(super.getMoteur().getPlateau().getApparitionJoueur()+i);
   super.setCommandes(new char[]{'z', 'q', 's', 'd', ' '});
  }

  public Cuisinier (Cuisinier c, Moteur m)
  {
    super(m, c.getNom(), c.getSymbole());
    this.poivre = c.getPoivre();
    this.vie = c.getVie();
    super.setPlace(c.getPlace());
  }

  public int getVie(){ return vie;}
  public boolean getPoivre(){return poivre;}
  public int getPlace(){return super.getPlace();}
  public char getSymbole(){return super.getSymbole();}
  public boolean getAssomme(){return false;}


  public void poivrer()
  {   Plateau I=super.getMoteur().getPlateau();
      int L=I.getLigne(super.getPlace());
      int C=I.getColonne(super.getPlace());
      if(super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)) != null)
		      super.getMoteur().getCreaturePlace(I.getIdentifiant(L+1,C)).Assomme();
	    if((super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C))) != null)
		      super.getMoteur().getCreaturePlace(I.getIdentifiant(L-1,C)).Assomme();
	    if(super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)) != null)
		      super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C-1)).Assomme();
	    if((super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1))) != null)
		      super.getMoteur().getCreaturePlace(I.getIdentifiant(L,C+1)).Assomme();
  }

  public void mort()
  {
    int i=0;
    while(super.getMoteur().getCreaturePlace(super.getMoteur().getPlateau().getApparitionJoueur()+i) != null)
       i++;
    setPlace(super.getMoteur().getPlateau().getApparitionJoueur()+i);
    vie--;
  }

  @Override
  public void run()
  {
    while(!super.getMoteur().fin())
    {
      int place = getPlace();
      try
      {
        BufferedReader saisie=new BufferedReader(getFlux());
        if(saisie.ready())
        {
          char commande =(char)saisie.read();
          Creature c = null;
          if(commande==commandes[0])
          {
            c = getMoteur().getCreaturePlace(getPlace()-getPlateau().getNbColonne());
            deplaceHaut();
          }
          else if(commande==commandes[1])
          {
            c = getMoteur().getCreaturePlace(getPlace()-1);
            deplaceGauche();
          }
          else if(commande==commandes[2])
          {
            c = getMoteur().getCreaturePlace(getPlace()+getPlateau().getNbColonne());
            deplaceBas();
          }
          else if(commande==commandes[3])
          {
            c = getMoteur().getCreaturePlace(getPlace()+1);
            deplaceDroite();
          }
          else if(commande==commandes[4])
          {
            poivrer();
            System.out.println("Poivrer!");
          }
          if( c != null && place != getPlace())
          {

            if(c.getSymbole() == 'C')
            {
              setPlace(place);
            }
            else
            {

              if(c.getAssomme())
              {
                c.mort();
                System.out.println("Ennemi tue");
              }
              else
              {
                mort();
                System.out.println("Je suis mort");
              }
            }
          }
        }
      }
      catch(IOException e){e.printStackTrace();}
    }
  }
}
