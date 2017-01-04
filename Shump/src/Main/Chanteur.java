package Main;

import MG2D.geometrie.*;

public class Chanteur extends Texture 
{
	
	private int vie=5;
	boolean touche = false;


	public boolean getTouche()
	{
		return touche;
	}


	public void setTouche(boolean touche) 
	{
		this.touche = touche;
	}


	public void setVie(int vie)
	{
		this.vie = vie;
	}


	public int getVie() 
	{
		return vie;
	}


	public Chanteur()
	{
		super();
	}


	public Chanteur(Couleur couleur, String chemin, Point a, int larg, int haut)
	{
		super(couleur, chemin, a, larg, haut);
	}


	public Chanteur(Couleur couleur, String chemin, Point a) 
	{
		super(couleur, chemin, a);
	}


	public Chanteur(String chemin, Point a, int larg, int haut)
	{
		super(chemin, a, larg, haut);
	}


	public Chanteur(String chemin, Point a)
	{
		super(chemin, a);
	}


	public Chanteur(Texture t) 
	{
		super(t);
	}
}
