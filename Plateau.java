public class Plateau{

  /*
  Defini un plateau de jeu
  Identifiants réservés : "0" case vide
                          "1" Sol
                          "2" Elements de burger
                          "3" Echelle
                          "4-12" Definis pour les joueurs

  */
  private int niveau[][];

  public Plateau()
  {
    niveau=new int[10][9];//initialisation d'un niveau vierge
    for(int i=0;i<niveau.length;i++)
      for(int j=0;j<niveau[0].length;j++)
        niveau[i][j]=0;
    for(int i = 0; i<getNbColonne(); i++)
      niveau[3][i] = 1;
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
    return identifiant/getNbColonne();
  }

  public int getColonne(int identifiant)
  {
    return identifiant%getNbColonne();
  }

  public int getIndice(int ligne, int colonne)
  {
    return niveau[ligne][colonne];
  }

  private void setIndice(int i, int j, int id)
  {
    niveau[i][j]=id;
  }

  public char getChar(int id)
  {
      switch(getIndice(getLigne(id),getColonne(id)))
      {
        case 1 : return '_';
        case 3 : return '=';
      }
      return ' ';
  }

  private boolean testDescend(int id)
  {
    if(id+getNbColonne()<getTaille())
    {
      int ligne = getLigne(id);
      int colonne = getColonne(id);
      return getIndice(ligne+1, colonne)!=0;
    }
    return false;
  }

  private boolean testGauche(int id)
  {
    if(id-1>=0)
    {
      int ligne = getLigne(id);
      int colonne = getColonne(id);
      if(colonne>0)
        return getIndice(ligne, colonne-1)!=0;
    }
    return false;
  }

  private boolean testDroite(int id)
  {
    if(id+1 < getTaille())
    {
      int ligne = getLigne(id);
      int colonne = getColonne(id);
      if(colonne+1 < getNbColonne())
        return getIndice(ligne, colonne+1)!=0;
    }
    return false;
  }

  private boolean testMonte(int id)
  {
    if(id-getNbColonne() >= 0)
    {
      int ligne = getLigne(id);
      int colonne = getColonne(id);
      return getIndice(ligne-1, colonne)!=0;
    }
    return false;
  }

  //main de test
  public static void main(String[] args) {
    Plateau i=new Plateau();
  }
}
