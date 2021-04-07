 
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Scores
{

    ArrayList<Joueur> lst ;
 

   
   int n;
   int tabScore;
   int tabNom;
   int indice;
   int id;
   int MeilleursScore;
   String NoMmeilleurjoueur;
    public Scores(int NbJOUeur)
    {
    
      n=NbJOUeur;
      tabScore=new int[n];
      tabNom=new String[n];
      MeilleursScore=new int[50];
      id=0;
      NoMmeilleurjoueur=new int[50];
     
      indice=0;
    }


  
 public void ScoreJoueur(String nomJoueur,int score)
  {
    
      tabNom[p]=nomJoueur;
      tabScor[p]=score ;
        indice++;
  /*  File file=new File("score+"nomJoueur+".text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
      bufferedwriter.write(nomJoueur);
      bufferedwriter.newLine();
      bufferedwriter.write(score);
  
    }  catch(IOException e){ e.printStackTrace();}*/

   }

public void Scoretotal(String NomGrp)
 {
    classement();
    File file=new File("score+"ScoreGrp+".text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
    
   /*  for(int i=0;i<lst.size()-1;i++)
    {
      bufferedwriter.write(tabNom[i]);
      bufferedwriter.newLine();
      bufferedwriter.write(tabScore[i]);
      bufferedwriter.newLine();
    }
  } catch(IOException e){ e.printStackTrace();}*/
    int somme=0;
     for(int i=0;i<n;i++)
     {     
      somme=somme+tabScore[i]; 
     } 
  bufferedwriter.write(NomGrp);
  bufferedwriter.newLine(); 
  bufferedwriter.write(somme);
  
 } 

public void CreerfichierMeilleusrJoueurs()
 {
    classement();
    File file=new File("score+"Joueurs+".text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
    
     for(int i=0;i<lst.size()-1;i++)
    {
      bufferedwriter.write(NoMmeilleurjoueur[i]);
      bufferedwriter.newLine();
      bufferedwriter.write(MeilleursScore[i]);
      bufferedwriter.newLine();
    }
  } catch(IOException e){ e.printStackTrace();}

      
  

 } 



    void classement()
    {     for(int i=0;i<n;i++)
        {
            if(tabScore[i+1]<tabScore[i])
              {
                int temp=tabScor[i+1];
                tabScore[i+1]=tabScore[i];
                tabScore[i]=temp;
                String temp=tabNom[i+1];
                tabNom[i+1]=tabNom[i];
                tabNom[i]=temp;
              }
        }
        MeilleursScore[id]=tabScor[0];
        NoMmeilleurjoueur[id]=tabNom[0];
        id++;
    }
  
 
public void run()
  {
     
     moteur m=new moteur();
     joueur j=new joueur(m,"MOussa",1,'+',0);
     joueur p =new joueur(m,"MATHIEU",2,'-',0); 
     Scores s=new Scores(3,new ArrayList<Joueur>()); 
     s.lst.add(j);
     s.lst.add(P);
     s.CreerfichierScoreJoueur("MATHIEU",10); 
     s.CreerfichierScoreJOueurs();  
         
  }



}

