import java.io.File;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Score
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
      
   if(indice==0)
   { try {
      File file = new File("c:\\Moussa.txt");
      BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file)); 
      int somme=0;
      for(int i=0;i<indice;i++)
      {     
      somme=somme+tabScore[i]; 
      } 
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
   try{ FileWriter fw =new FileWriter("c:\\Moussa.txt",false);
	  int somme=0;
      for(int i=0;i<indice;i++)
      {     
      somme=somme+tabScore[i]; 
      } 
      String s=String.valueOf(somme);
      fw.write(NomGrp+" ");
      //fw.newLine(); 
      fw.write(s+" ");
      fw.close();  
	  } catch (IOException e) {
       e.printStackTrace();}
    }

  
 }
 public   void classement()
    {   if(indice==0)
		{
				
			  MeilleursScore[id]=tabScore[0];
               NoMmeilleurjoueur[id]=tabNom[0];
              id++;	
		}
		else
		 { for(int i=0;i<indice-1;i++)
             {
              if(tabScore[i]<tabScore[i+1])
               {
                int temps=tabScore[i+1];
                tabScore[i+1]=tabScore[i];
                tabScore[i]=temps;
                String temp=tabNom[i+1];
                tabNom[i+1]=tabNom[i];
                tabNom[i]=temp;
                }
              MeilleursScore[id]=tabScore[0];
              NoMmeilleurjoueur[id]=tabNom[0];
              id++;
           }
      }
    }

public void CreerfichierMeilleusrJoueurs()
 {
   if(id==0)
   { 
     classement();
         
     try {
       
       File file = new File("c:\\Record.txt");
       
       if (file.createNewFile()){
         System.out.println("Fichier créé!");
       }else{
         System.out.println("Fichier existe déjà.");
       }
       
    BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file));
     for(int i=0;i<id;i++)
    {
      bufferedwriter.write(NoMmeilleurjoueur[i]);
      bufferedwriter.newLine();
      bufferedwriter.write(MeilleursScore[i]);
      bufferedwriter.newLine();
    }
  } catch(IOException e){ e.printStackTrace();}

     
       
 }else 
  {
	   try{ 
		   FileWriter fw =new FileWriter("c:\\Record.txt",false);
	       
	  for(int i=0;i<id;i++)
       {  
		      String p=String.valueOf(MeilleursScore[i]);
        fw.write(NoMmeilleurjoueur[i]);
        fw.write(" "+MeilleursScore[i]);
       
      }
	  
	  
   } catch(IOException e){ e.printStackTrace();}
 
  }
 }
 public void scoreJOueur(String Nom ,int sc )
 {
	 tabScore[indice]=sc;
	 tabNom[indice]=Nom;
     indice++;
     
 
 }


  
  
 
  
}
}

 public class Scores{

 public static void main (String[] args)
  { 
     Score s= new Score(4);
     s.scoreJOueur("Moussa",3);
     s.scoreJOueur("Mathieu",3);
     s.scoreJOueur("Eric",4);
     s.Scoretotal("grp1");  
     s.scoreJOueur("Eric",6);
     s.CreerfichierMeilleusrJoueurs();   
  } 
}
  
