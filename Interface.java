public class Interface{

  private int niveau[][];

  public Interface()
  {
    niveau=new int[20][20];//initialisation d'un niveau vierge
    for(int i=0;i<niveau.length;i++)
      for(int j=0;j<niveau[0].length;j++)
        niveau[i][j]=0;
    setIndice(15,0,1);
    setIndice(15,1,2);
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

  public synchronized int bouge(int i, int id)
  {
    switch(i)
    {
      case 1: return monte(id);
      case 2: return descend(id);
      case 3: return gauche(id);
      case 4: return droite(id);
    }
    return 1;
  }

  private int descend(int id)
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
    return 0;
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
    Interface i=new Interface();
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
