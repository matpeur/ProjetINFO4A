 class Elements extends Thread {
    int n;
    String nom ;
    Burger B;
    Plateau P;
   public Elements(String nom1, int n1,Burger B1,Plateau P1)
   {
	   this.n=n1;
	   this.nom=nom1;
	   B=B1;
	   P=P1;
   }  
    
   public int getId(){ return this.identifiant;}
    



}







 

