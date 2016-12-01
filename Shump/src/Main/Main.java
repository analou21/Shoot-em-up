package Main;

import MG2D.*;
import MG2D.geometrie.*;
import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{		
		//Instanciation d'une fenêtre
		Fenetre f = new Fenetre("MaFenetre", 900, 600);
		//instanciation du clavier
		Clavier clavier = new Clavier();
		//Instanciation de la souris
		Souris souris = new Souris(480);
		// Paramètrage du clavier et de la souris
		f.addKeyListener(clavier);
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		//Instanciation d'un rectangle
		Rectangle r = new Rectangle(Couleur.NOIR, new Point(0,0), new Point(900,600), true);
		//Affichage du rectangle
		f.ajouter(r);
		//Intanciation d'un objet texture pour afficher notre vaisseau
		Texture vaisseau = new Texture("../vaisseau.png", new Point(390, 0), 70, 100);
		//Affichage du vaisseau
		f.ajouter(vaisseau);
		//Instanciation du laser
		ArrayList<Texture> laser = new ArrayList<Texture>();
		//Intanciation d'un objet texture pour afficher les ennemis
		Texture ennemi = new Texture("../ennemi1.png", new Point(390, 490), 70, 100);
		//Affichage de l'ennemi
		f.ajouter(ennemi);
		
		int compteur = 0;
		//int delai = 0;
		
		while(true)
		{			
			try {
		        Thread.sleep(30);
		    }
		    catch (InterruptedException ex) {}
			
			//Si appuie sur la touche gauche, le vaisseau se déplace à gauche
			if(clavier.getGauche() && vaisseau.getA().getX() > 0)
			{
				vaisseau.translater(-5,0);
			}
			//Si appuie sur la touche droite, le vaisseau se déplace à droite
			if(clavier.getDroite() && vaisseau.getA().getX() < f.getWidth()-70)
			{
				vaisseau.translater(5,0);
			}
			//Si appuie sur la touche haut, le vaisseau se déplace à haut
			if(clavier.getHaut() && vaisseau.getA().getY() < f.getHeight()-90)
			{
				vaisseau.translater(0,5);
			}
			//Si appuie sur la touche bas, le vaisseau se déplace à bas
			if(clavier.getBas() && vaisseau.getA().getY() > 0)
			{
				vaisseau.translater(0,-5);
			}
			//Si appuie sur la touche espace, tir des missiles
			if(clavier.getEspace())
			{
				if(compteur>13)
				{
					laser.add(new Texture("../laser.png", new Point(((vaisseau.getB().getX()-vaisseau.getA().getX())/2) + vaisseau.getA().getX(),vaisseau.getB().getY()+15), 5,50));
					f.ajouter(laser.get(laser.size()-1));
					compteur=0;
				}
			}
			//Si le laser dépasse la fenêtre, on le supprime
			for(int j=0; j<laser.size(); j++)
			{
				laser.get(j).translater(0,6);
				if(laser.get(j).getA().getY()>=600)
				{
					f.supprimer(laser.get(j));
					laser.remove(j);
				}
			}
			
			
			f.rafraichir();
			compteur = compteur +1;
		}
	}
}
