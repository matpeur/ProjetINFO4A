import java.io.*;

public class Ecouteur extends Thread
{
  Moteur moteur;
  PipedWriter [] flux;
  Client client;

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
          flux[t] = new PipedWriter();
          flux[t].connect(j.getFlux());
          }catch(Exception e){}
        }
    }
    client = null;
  }

  public Ecouteur(Client c, int i)
  {
    flux = new PipedWriter[1];
    try
    {
      Joueur j=c.getJoueur(i);
      flux[0] = new PipedWriter();
      flux[0].connect(j.getFlux());
    }catch(Exception e){}
      this.client = c;
  }

  public void run()
  {
    try
    {

      BufferedReader tampon = new BufferedReader(new InputStreamReader(System.in));
      int i=0;

      boolean envoye;
      if(moteur != null)
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
              if(client == null)
              flux[boucle].write(commande);
              else
              client.transmetCommande(commande);
            }
            boucle = (boucle+1)%flux.length;
          }while(boucle != i && !envoye);
          i = boucle;
        }
      else
      {
        while(!client.fin())
        {
          char commande = (char)tampon.read();
          client.transmetCommande(commande);
        }
      }
    }
    catch(Exception e){e.printStackTrace();}
  }

}
