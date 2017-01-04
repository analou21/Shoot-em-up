package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import MG2D.geometrie.Couleur;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;

public class Bonus extends Texture
{

	@Override
	public void afficher(Graphics g) 
	{
		super.afficher(g);
	}

	@Override
	public boolean equals(Object obj) 
	{
		return super.equals(obj);
	}

	@Override
	public BufferedImage getImg()
	{
		return super.getImg();
	}

	@Override
	public boolean getTransparent()
	{
		return super.getTransparent();
	}
	@Override
	public void setA(Point aa) 
	{
		super.setA(aa);
	}

	@Override
	public void setB(Point bb) 
	{
		super.setB(bb);
	}

	@Override
	public void setImg(BufferedImage img)
	{
		super.setImg(img);
	}

	@Override
	public void setImg(String chemin) 
	{
		super.setImg(chemin);
	}

	@Override
	public void setTransparent(boolean transparent)
	{
		super.setTransparent(transparent);
	}
	public Bonus()
	{
		super();
	}

	public Bonus(Couleur couleur, String chemin, Point a, int larg, int haut) 
	{
		super(couleur, chemin, a, larg, haut);
	}

	public Bonus(Couleur couleur, String chemin, Point a)
	{
		super(couleur, chemin, a);
	}

	public Bonus(String chemin, Point a, int larg, int haut)
	{
		super(chemin, a, larg, haut);
	}

	public Bonus(String chemin, Point a) 
	{
		super(chemin, a);
	}

	public Bonus(Texture t) 
	{
		super(t);
	}
}
