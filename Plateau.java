public class Plateau{

  private int niveau[][];

  public Plateau()
  {
    niveau=new int[100][100];//initialisation d'un niveau vierge
    for(int i=0;i<niveau.length;i++)
      for(int j=0;j<niveau[0].length;j++)
        niveau[i][j]=0;
  }

  private Plateau(int ligne, int colonne)
  {
    niveau=new int[ligne][colonne];//initialisation d'un niveau vierge
    for(int i=0;i<niveau.length;i++)
      for(int j=0;j<niveau[0].length;j++)
        niveau[i][j]=0;
  }
  public int getTaille()
  {
    return niveau.length*niveau[0].length;
  }

  public int getNbColonne()
  {
    return niveau[0].length;
  }

  public int getNbLigne()
  {
    return niveau.length;
  }

  public int getLigne(int identifiant)
  {
    return identifiant/getNbLigne();
  }

  public int getColonne(int identifiant)
  {
    return identifiant%getNbLigne;
  }

  private int getIndice(int i, int j)
  {
    return niveau[i][j];
  }

  private void setIndice(int i, int j, int id)
  {
    niveau[i][j]=id;
  }

  public void affiche()
  {
    for(int i=-1; i<=niveau.length;i++)
    {
      for(int j=-1;j<=niveau[0].length;j++)
      {
        if(i==-1||i==niveau.length)
          System.out.print("_");
        else if(j==-1||j==niveau[0].length)
          System.out.print("|");
        else if(niveau[i][j]!=0)
          System.out.print(niveau[i][j]);
        else
          System.out.print(" ");
        }
      System.out.println();
    }
  }

  private int test_descend(int id)
  {
    boolean flag=false;
    int i=0;
    int j;
    while(!flag&&i<niveau.length)
    {
      j=0;
      while(!flag&&j<niveau[0].length)
      {
        if((niveau[i][j]&id)==id)
        {
          flag=true;
          if((i+1)<niveau.length)
          {
              niveau[i][j]=niveau[i][j]&~id;
              niveau[i+1][j]=niveau[i+1][j]|id;
              return niveau[i][j];
          }
        }
        else
          j++;
      }
        i++;
    }
    return flag;
  }

  private int gauche(int id)
  {
    boolean flag=false;
    int i=0;
    int j;
    while(!flag&&i<niveau.length)
    {
      j=0;
      while(!flag&&j<niveau[0].length)
      {
        if((niveau[i][j]&id)==id)
        {
          flag=true;
          if(j-1>=0)
          {
              niveau[i][j]=niveau[i][j]&~id;
              niveau[i][j-1]=niveau[i][j-1]|id;
              return niveau[i][j];
          }
        }
        else
          j++;
      }
        i++;
    }
    return 0;
  }

  private int droite(int id)
  {
    boolean flag=false;
    int i=0;
    int j;
    while(!flag&&i<niveau.length)
    {
      j=0;
      while(!flag&&j<niveau[0].length)
      {
        if((niveau[i][j]&id)==id)
        {
          flag=true;
          if(j+1<niveau[0].length)
          {
              niveau[i][j]=niveau[i][j]&~id;
              niveau[i][j+1]=niveau[i][j+1]|id;
              return niveau[i][j];
          }
        }
        else
          j++;
      }
        i++;
    }
    return 0;
  }

  private int monte(int id)
  {
    boolean flag=false;
    int i=0;
    int j;
    while(!flag&&i<niveau.length)
    {
      j=0;
      while(!flag&&j<niveau[0].length)
      {
        if((niveau[i][j]&id)==id)
        {
          flag=true;
          if(i-1>=0)
          {
              niveau[i][j]=niveau[i][j]&~id;
              niveau[i-1][j]=niveau[i-1][j]|id;
              return niveau[i][j];
          }
        }
        else
          j++;
      }
        i++;
    }
    return 0;
  }

  //main de test
  public static void main(String[] args) {
    Plateau i=new Plateau();
    i.affiche();
    int j=i.monte(1);
    i.affiche();
    j=i.descend(1);
    i.affiche();
    j=i.droite(1);
    i.affiche();
    j=i.gauche(1);
    i.affiche();
  }
}
