import java.io.*;

public class Ecouteur extends Thread
{
  Moteur moteur;
  PipedWriter [] flux;

  public Ecouteur(Moteur m)
  {
    this.moteur=m;
    flux = new PipedWriter[moteur.getNbCreature()];
    for(int t =0; t<moteur.getNbCreature(); t++)
    {
        if(moteur.getCreature(t).getCommandes() != null)
        {
          try
          {
          Joueur j=(Joueur) moteur.getCreature(t);
          flux[t].connect(j.getFlux());
          }catch(Exception e){}
        }
    }
  }

  public void run()
  {
    try
    {

      BufferedReader tampon = new BufferedReader(new InputStreamReader(System.in));
      int i=0;

      boolean envoye;
      while(!moteur.fin())
      {
        char commande = (char)tampon.read();
        int boucle = i;
        envoye = false;
        do
        {
          Creature c=moteur.getCreature(boucle);
          int j = 0;
          while( !envoye && j < c.getCommandes().length)
          {
            if(c.getCommandes()[j] == commande)
              envoye = true;
            j++;
          }
          if(envoye)
          {
            flux[boucle].write(commande);
          }
          boucle = (boucle+1)%moteur.getNbCreature();
        }while(boucle != i && !envoye);
        i = boucle;
      }
    }
    catch(Exception e){e.printStackTrace();}
  }

}
