import java.io.File;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Scores
{
   int n;
   int somme ;
   String[] tabNom;
   int indice;
   int id;
   int[] MeilleursScore;
   String[] NoMmeilleurjoueur;
    public Scores(int NbJOUeur)
    {

      n=NbJOUeur;
      MeilleursScore=new int[10];
      id=0;
      NoMmeilleurjoueur=new String[10];

      indice=0;
    }

    public Scores()
    {

    }



  public void addScore(int i)
  {

	somme=somme+1;
  }
  public void Sauvegarde(String Nom)
  {

	NoMmeilleurjoueur[id]=Nom;
	MeilleursScore[id]=somme;
	id++;

  }

  public void afficheScoreCourant()
  {
	System.out.println("Score courant :");
	System.out.println(somme);

  }
  public void afficheScores()
  {  System.out.println("Records:");
         classement();
  	for(int i=0;i<id-1;i++)
     {
        System.out.println(NoMmeilleurjoueur[i]);
        System.out.println(MeilleursScore[i]);

     }
  }
public void FichierScorePartie(String NomGrp)
 {

   if(indice==0)
   { try {
      File file = new File("c:\\Score.txt");
      BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file));

     String s=String.valueOf(somme);
     bufferedwriter.write(NomGrp);
     bufferedwriter.newLine();
     bufferedwriter.write(s);
     bufferedwriter.close();
       if (file.createNewFile()){
         System.out.println("Fichier créé!");
       }else{
         System.out.println("Fichier existe déjà.");
       }

     } catch (IOException e) {
       e.printStackTrace();}


  }else
  {
   try{ FileWriter fw =new FileWriter("c:\\Score.txt",false);
      String s=String.valueOf(somme);
      fw.write(NomGrp+" ");

      fw.write(s+" ");
      fw.close();
	  } catch (IOException e) {
       e.printStackTrace();}
    }


 }
 public   void classement()
    {    for(int i=0;i<id-1;i++)
             {
              if(MeilleursScore[i]<MeilleursScore[i+1])
               {
                int temps=MeilleursScore[i+1];
                MeilleursScore[i+1]=MeilleursScore[i];
                MeilleursScore[i]=temps;
                String temp=NoMmeilleurjoueur[i+1];
                NoMmeilleurjoueur[i+1]=NoMmeilleurjoueur[i];
                NoMmeilleurjoueur[i]=temp;
                }

           }

    }


public void Sauvegarder()
 { 

   try{
       File file = new File("c:\\Record.txt");
     if (file.createNewFile()){
     {     
        try
        {
	      BufferedWriter EcritureAvecBuffer = new  BufferedWriter (new FileWriter((file)));
	      for(int i=0;i<id;i++)
           {
            EcritureAvecBuffer.write(NoMmeilleurjoueur[i]);
            EcritureAvecBuffer.newLine();
            EcritureAvecBuffer.write(MeilleursScore[i]);
            EcritureAvecBuffer.newLine();
            }
        }
      catch(FileNotFoundException exc)
      { 
	     System.out.println("Erreur d'ouverture");
      }
    
     }
     else 
     {

      
       
       /*BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file));
       FileWriter fw =new FileWriter("c:\\Record.txt",true);
        bufferedwriter.write("----------------------------------------\n");
        bufferedwriter.newLine();
        bufferedwriter.write("Nouvelle partie");
        bufferedwriter.newLine();
     for(int i=0;i<id;i++)
    {
      bufferedwriter.write(NoMmeilleurjoueur[i]);
      bufferedwriter.newLine();
      bufferedwriter.write(MeilleursScore[i]);
      bufferedwriter.newLine();
    }
  }catch(IOException e){ e.printStackTrace();}*/



 }else
  {
	   try{
		  int i=3;


      while((ligne = lecteurAvecBuffer.readLine()) != null)
       {   if(i%2==0)
		    NoMmeilleurjoueur[id]=ligne ;
		   if(i%2!=0)
		     MeilleursScore[id]=ligne;      
       i++;
       }
   BufferedWriter EcritureAvecBuffer = new  BufferedWriter (new FileWriter((file)));
	    classement();
	      for(int i=0;i<id;i++)
           {
            EcritureAvecBuffer.write(NoMmeilleurjoueur[i]);
            EcritureAvecBuffer.newLine();
            EcritureAvecBuffer.write(MeilleursScore[i]);
            EcritureAvecBuffer.newLine();
            }


   } catch(IOException e){ e.printStackTrace();}

  }
 }
  
 

}
public class Scores{
 public static void main (String[] args)
  {
	Thread t1=new Scores(4);
    t1.addScore(5);
    t1.addScore(6);
    t1.addScore(7);
    t1.cree
  }
} 
