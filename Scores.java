 
import java.io.File;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Score
{
   int n;
   int[] tabScore;
   String[] tabNom;
   int indice;
   int id;
   int[] MeilleursScore;
   String[] NoMmeilleurjoueur;
    public Score(int NbJOUeur)
    {
    
      n=NbJOUeur;
      tabScore=new int[n];
      tabNom=new String[n];
      MeilleursScore=new int[10];
      id=0;
      NoMmeilleurjoueur=new String[10];
     
      indice=0;
    }


  
  

public void Scoretotal(String NomGrp)
 {
    classement();
    File file=new File("score.text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
    int somme=0;
     for(int i=0;i<n;i++)
     {     
      somme=somme+tabScore[i]; 
     } 
  bufferedwriter.write(NomGrp);
  bufferedwriter.newLine(); 
  bufferedwriter.write(somme);
  
 } 
}

public void CreerfichierMeilleusrJoueurs()
 {
    classement();
    File file=new File("Meilleurjoueurs.text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
    
     for(int i=0;i<n;i++)
    {
      bufferedwriter.write(NoMmeilleurjoueur[i]);
      bufferedwriter.newLine();
      bufferedwriter.write(MeilleursScore[i]);
      bufferedwriter.newLine();
    }
  } catch(IOException e){ e.printStackTrace();}

      
 }
 
 public void scoreJOueur(String Nom ,int sc )
 {
	 tabScore[indice]=sc;
	 tabNom[indice]=Nom;
     indice++;
 
 
 }


    void classement()
    {     for(int i=0;i<n;i++)
        {
            if(tabScore[i+1]<tabScore[i])
              {
                int temps=tabScore[i+1];
                tabScore[i+1]=tabScore[i];
                tabScore[i]=temps;
                String temp=tabNom[i+1];
                tabNom[i+1]=tabNom[i];
                tabNom[i]=temp;
              }
        }
        MeilleursScore[id]=tabScore[0];
        NoMmeilleurjoueur[id]=tabNom[0];
        id++;
    }
  
 
  

}
 public class Scores{

 public static void main (String[] args)
  { 
     Score s= new Score(3);
     s.scoreJOueur("Moussa",3);
     s.scoreJOueur("Mathieu",3);
     s.scoreJOueur("Eric",4);
     s.scoretotal("grp1");
      
  }
}
