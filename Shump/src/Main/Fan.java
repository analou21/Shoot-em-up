package Main;

import MG2D.geometrie.*;

public class Fan extends Texture 
{
	
	// Booleen qui determine si un fan a touché le bord de la fenetre
	private boolean paroi = false;
	private boolean fanTouche = false;
	
	public boolean getFanTouche() 
	{
		return fanTouche;
	}

	public void setFanTouche(boolean fanTouche) 
	{
		this.fanTouche = fanTouche;
	}
	public boolean getParoi() 
	{
		return paroi;
	}

	public void setParoi(boolean paroi) 
	{
		this.paroi = paroi;
	}

	public Fan() 
	{
		super();
	}

	public Fan(Couleur couleur, String chemin, Point a, int larg, int haut) 
	{
		super(couleur, chemin, a, larg, haut);
	}

	public Fan(Couleur couleur, String chemin, Point a)
	{
		super(couleur, chemin, a);
	}

	public Fan(String chemin, Point a, int larg, int haut)
	{
		super(chemin, a, larg, haut);
	}
	public Fan(String chemin, Point a) 
	{
		super(chemin, a);
	}

	public Fan(Texture t)
	{
		super(t);
	}	
}
