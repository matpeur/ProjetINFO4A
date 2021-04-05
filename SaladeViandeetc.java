public class  SaladeViandeetc extends Elements
{
   
  Plateau P;
   
	
   public SaladeViandeetc(String nom1,int identifiant1,Plateau P1,Burger B1)
   {
	 super(nom1,identifiant1,B1); 
	 P=P1;  
	  
	}
   		
   public  int getPlace(){return this.identifiant;}
   public void setPlace(int p){this.identifiant=p;}
    
   public void depalce()
    {  
	 
	 do{
	   
	    int l= this.P.getLigne(this.getPlace());
	    int c=this.P.getColonne(this.getPlace());
	    setPlace(I.getIdentifiant(l+1,c));
       }while(I.getIndice(l+1,c)!=1&&I.getIndice(l+1,c)!=4);
       
       if(I.getIndice(l+1,c)==4)
       {   
		   for(int i=0;i<P.getNbColonne();i++){P.setIndice(l-1,i,4)}
		      B.ajoutComposant(this.nom,super.getId()); 
	   }
 	   
    }
     	
	public void run()
	{
	   deplace();	
	}
	
	
} 
