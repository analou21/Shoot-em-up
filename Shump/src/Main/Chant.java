package Main;

import MG2D.geometrie.*;


public class Chant extends Texture
{
	
	private boolean attaque = false;
	private boolean sorti = false;
	
	public boolean getSorti() 
	{
		return sorti;
	}

	public void setSorti(boolean sorti) 
	{
		this.sorti = sorti;
	}

	public boolean getAttaque()
	{
		return attaque;
	}

	public void setAttaque(boolean attaque)
	{
		this.attaque = attaque;
	}

	public Chant()
	{
		super();
	}
	public Chant(Couleur couleur, String chemin, Point a, int larg, int haut)
	{
		super(couleur, chemin, a, larg, haut);
	}

	public Chant(Couleur couleur, String chemin, Point a)
	{
		super(couleur, chemin, a);
	}

	public Chant(String chemin, Point a, int larg, int haut) 
	{
		super(chemin, a, larg, haut);
	}

	public Chant(String chemin, Point a)
	{
		super(chemin, a);
	}

	public Chant(Texture t) 
	{
		super(t);
	}
}
