import java.io.*;

public class Scores
{
   int scoreCourant ;
   int[] MeilleursScore;
   String[] NomMeilleurjoueur;

    public Scores()
    {
      int i=0;
      MeilleursScore = new int[11];
      NomMeilleurjoueur = new String [11];
      scoreCourant = 0;
      try
      {
        File fichier = new File("Score.txt");
        BufferedReader bufferedreader= new BufferedReader(new FileReader(fichier));
        while(i < 10)
        {
          String nom = bufferedreader.readLine();
          int score = Integer.parseInt(bufferedreader.readLine());
          MeilleursScore[i]=score;
          NomMeilleurjoueur[i] = nom;
        }
      }
      catch(Exception e){}
    }



  public void addScore(int i)
  {
	   scoreCourant += i;
  }

  public void Sauvegarder()
  {
    try
    {
      File file = new File("Score.txt");
      MeilleursScore[10] = scoreCourant;
      System.out.println("Entrez un nom");
      BufferedReader saisie = new BufferedReader(new InputStreamReader(System.in));
      NomMeilleurjoueur[10] = saisie.readLine();
      classement();
      try
      {
        BufferedWriter EcritureAvecBuffer = new  BufferedWriter (new FileWriter(file, false));
        for(int i=0;i<10;i++)
        {
          EcritureAvecBuffer.write(NomMeilleurjoueur[i]);
          EcritureAvecBuffer.newLine();
          EcritureAvecBuffer.write(MeilleursScore[i]);
          EcritureAvecBuffer.newLine();
        }
      }
      catch(FileNotFoundException exc)
      {
        System.out.println("Erreur d'ouverture");
      }
    }catch(Exception e){}
  }

  public void afficheScoreCourant()
  {
	   System.out.print("Score courant :");
	    System.out.println(scoreCourant);
  }
  public void afficheScores()
  {  System.out.println("Records:");
  	for(int i=0;i< 9;i++)
     {
        System.out.println(NomMeilleurjoueur[i]);
        System.out.println(MeilleursScore[i]);
     }
  }

  public boolean trier()
  {
    boolean result = true;
    int i=0;
    while(result && i<10)
    {
      if(MeilleursScore[i]<MeilleursScore[i+1])
        result = false;
      i++;
    }
    return result;
  }

  public void classement()
  {
    while(!trier())
    {
      for(int i=0;i<10;i++)
      {
        if(MeilleursScore[i]<MeilleursScore[i+1])
        {
          int temps=MeilleursScore[i+1];
          MeilleursScore[i+1]=MeilleursScore[i];
          MeilleursScore[i]=temps;
          String temp=NomMeilleurjoueur[i+1];
          NomMeilleurjoueur[i+1]=NomMeilleurjoueur[i];
          NomMeilleurjoueur[i]=temp;
        }
      }
    }
  }
}
