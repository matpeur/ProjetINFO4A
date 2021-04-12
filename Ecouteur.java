import java.io.*;

public class Ecouteur extends Thread implements Serializable
{
  Moteur moteur;
  TuyauSortie [] flux;
  Client client;

  public Ecouteur(Moteur m)
  {
    this.moteur=m;
    flux = new TuyauSortie[moteur.getNbCreature()];
    for(int t =0; t<moteur.getNbCreature(); t++)
    {
        if(moteur.getCreature(t).getCommandes() != null)
        {
          try
          {
          Joueur j=(Joueur) moteur.getCreature(t);
          flux[t] = new TuyauSortie();
          flux[t].connect(j.getFlux());
          }catch(Exception e){}
        }
    }
    client = null;
  }

  public Ecouteur(Client c, int i)
  {
    this.moteur=c.getMoteur();
    flux = new TuyauSortie[1];
    try
    {
      Joueur j=(Joueur) moteur.getCreature(i);
      flux[0] = new TuyauSortie();
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
    }
    catch(Exception e){e.printStackTrace();}
  }

}
