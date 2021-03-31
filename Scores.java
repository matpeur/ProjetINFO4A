 
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Scores
{

    ArrayList<Joueur> lst ;
 


    public Scores(int n, ArrayList<Joueur> lst )
    {
      this.lst=lst;
      
    }




 public void CreerfichierScoreJoueur(String nomJoueur,int score)
  {
    File file=new File("score+"nomJoueur+".text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
      bufferedwriter.write(nomJoueur);
      bufferedwriter.newLine();
      bufferedwriter.write(score);
  
    }  catch(IOException e){ e.printStackTrace();}

   }



public void CreerfichierScoreJOueurs()
 {
    classement();
    File file=new File("score+"Joueurs+".text"); 
    try(BufferedWriter bufferedwriter= new BufferedWriter(new FileWriter(file))){
    
     for(int i=0;i<lst.size()-1;i++)
    {
      bufferedwriter.write(lst.get(i).getNom());
      bufferedwriter.newLine();
      bufferedwriter.write(lst.get(i).getscore());
      bufferedwriter.newLine();
    }
  } catch(IOException e){ e.printStackTrace();}

      
  

 } 



    void classement()
    {     for(int i=0;i<lst.size()-1;i++)
        {
            if(lst.get(i+1).getscore()<lst.get(i).getscore())
              {
                int temp=lst.get(i+1);
                lst.get(i+1)=lst.get(i);
                lst.get(i)=temp;
              }
        }
    }


    void affichage()
    {
      for(int i=0;i<lst.size();i++)
      {
        lst.get(i).affiche();
      }
    }
public void run()
  {
     
     moteur m=new moteur();
     joueur j=new joueur(m,"MOussa",1,'+');
     joueur p =new joueur(m,"MATHIEU",2,'-'); 
     Scores s=new Scores(3,new ArrayList<Joueur>()); 
     s.lst.add(j);
     s.lst.add(P);
     s.CreerfichierScoreJoueur("MATHIEU",10); 
     s.CreerfichierScoreJOueurs();  
         
  }



}

