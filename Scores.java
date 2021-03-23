public class Scores
{

    ArrayList<Joueur> lst ;
 


    public Scores(int n, ArrayList<Joueur> lst )
    {
      this.lst=lst;
      
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
}
