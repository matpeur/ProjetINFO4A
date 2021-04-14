import java.util.*;
import java.io.*;
public class Burger implements Serializable
{

	private ArrayList<Elements> composants;
	private Moteur moteur;

	public Burger(Moteur m, int colonne)
	{
		this.moteur = m;
		this.composants = new ArrayList<Elements>();
		creerBurger(colonne);
	}

	public Burger(Burger b, Moteur m)
	{
		moteur = m;
		composants = new ArrayList<Elements>();
		for (int i = 0; i<b.getNbComposants(); i++)
			composants.add(new Elements(b.getElement(i), this));
	}

	public Elements getElement(int ligne, int colonne)
	{
		for(int i = 0; i<composants.size(); i++)
			if(composants.get(i).getIdentifiant() == ligne*moteur.getPlateau().getNbColonne()+colonne)
				return composants.get(i);
		return null;
	}

	public Moteur getMoteur()
	{
		return moteur;
	}

	public Elements getElement(int id)
	{
		return composants.get(id);
	}

	public int getNbComposants()
	{
		return composants.size();
	}

	private void creerBurger(int colonne)
	{
		if(compatible(colonne))
		{
			int indice[] = new int[moteur.getPlateau().getNbLigne()];
			int compteur = 0; //compte le nombre de sol sur la colonne
			for(int i = 0; i<moteur.getPlateau().getNbLigne(); i++)
				if(moteur.getPlateau().getIndice(i,colonne)==1)
					{
						indice[compteur] = i;
						compteur++;
					}
			for(int i=0; i<compteur; i++)
			{
				if(i == 0)
					for(int j = 0; j < 4; j++)
						composants.add(new PainDessus(this.moteur.getPlateau().getNbColonne()*indice[i]+colonne+j, this));
				else if(i == (compteur-1))
					for(int j = 0; j < 4; j++)
						composants.add(new PainDessous(this.moteur.getPlateau().getNbColonne()*indice[i]+colonne+j, this));
				else
					for(int j = 0; j < 4; j++)
						composants.add(new SaladeViandeetc(this.moteur.getPlateau().getNbColonne()*indice[i]+colonne+j, this));
			}
			for(int j = 0; j < 4; j++)
				moteur.getPlateau().setIndice(moteur.getPlateau().getNbLigne()-1, colonne+j, 4);
		}
	}


	//vérifie si une colonne est compatible avec la création d'un burger, c'est a dire que les 3 colonnes suivantes sont identique à celle testée
	public boolean compatible(int colonne)
	{
		boolean compatible = true; //resultat du test
		int i=0;
		while(compatible && i<moteur.getPlateau().getNbLigne())
		{
			if((moteur.getPlateau().getIndice(i, colonne) != moteur.getPlateau().getIndice(i, colonne+1))
					||(moteur.getPlateau().getIndice(i, colonne) != moteur.getPlateau().getIndice(i, colonne+2))
				  ||(moteur.getPlateau().getIndice(i, colonne) != moteur.getPlateau().getIndice(i, colonne+3)))
					compatible = false;
			i++;
		}
		return compatible;
	}

	//vérifie si le burger est complet
	public boolean complet()
	{
		boolean complet = true;
		int i = 0;
		while(complet && i < composants.size())
		{
			if(!(composants.get(i).getPose()))
				complet = false;
			i++;
		}
		return complet;
	}

	public void debut()
	{
		for(int i = 0; i < composants.size(); i++)
			composants.get(i).start();
	}

	public boolean equals(Burger b)
	{
		if(composants.size() != b.getNbComposants())
			return false;
		for(int i = 0; i<composants.size(); i++)
			if(!(b.getElement(i).equals(composants.get(i))))
				return false;
		return true;
	}
}
