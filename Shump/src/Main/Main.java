package Main;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

public class Main 
{

	public static void main(String[] args) 
	{
		// Instanciation de la fenêtre
		Fenetre f = new Fenetre("Shoot'em Up : Chanteurs vs fans hystériques", 1000, 650);
		// Instanciation du clavier
		Clavier clavier = new Clavier();
		// Instanciation de la souris
		Souris souris = new Souris(480);
		// Paramètrage du clavier et de la souris
		f.addKeyListener(clavier);
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		f.addMouseMotionListener(souris);
		
		// Valeurs changeantes
		ArrayList<Texture> PersoChoisi = new ArrayList<Texture>();
		int score = 0;
		
		/* 1er écran : Ecran d'accueil */
		// Fond de l'écran d'accueil
		Texture fondAccueil = new Texture("../image/Fond/fondAccueil.jpg", new Point(0, 0), 1000, 700);
		// Ajout du fond à la fenêtre
		f.ajouter(fondAccueil);
		// Titre du jeu + menu && ajout à la fenêtre
		Texte titre = new Texte(Couleur.BLANC, "Shoot'em up : Chanteurs vs Fans hystériques", new Font("tahoma", Font.BOLD, 32), new Point(500, 600));
		Texte text = new Texte(Couleur.BLANC, "Règles", new Font("tahoma", Font.BOLD, 28), new Point(500, 450));
		Texte texte = new Texte(Couleur.BLANC, "Choix du personnage", new Font("tahoma", Font.BOLD, 28), new Point(500, 350));
		Texte textes = new Texte(Couleur.BLANC, "Meilleurs Scores", new Font("tahoma", Font.BOLD, 28), new Point(500, 250));
		f.ajouter(titre);
		f.ajouter(text);
		f.ajouter(texte);
		f.ajouter(textes);
		
		if(souris.getClicGauche() && ((Point) souris.getPosition()).getX() == 500 && ((Point) souris.getPosition()).getY() == 450)
		{
			// Titre + règles && ajout à la fenêtre
			Texte titre1 = new Texte(Couleur.BLANC, "Règles", new Font("tahoma", Font.BOLD, 32), new Point(500, 600));
			Texte ligne = new Texte(Couleur.BLANC, "Les fans s'en prènent aux célébrités.", new Font("tahoma", Font.ITALIC, 20), new Point(400, 450));
			Texte ligne1 = new Texte(Couleur.BLANC, "Stoppent-les en leurs envoyant des chansons.", new Font("tahoma", Font.ITALIC, 20), new Point(400, 300));
			Texte ligne2 = new Texte(Couleur.BLANC, "Sinon, les chanteurs et/ou les groupes risquent de sombrer.", new Font("tahoma", Font.ITALIC, 20), new Point(400, 350));
			f.ajouter(titre1);
			f.ajouter(ligne);
			f.ajouter(ligne1);
			f.ajouter(ligne2);
		}else if(souris.getClicGauche() && ((Point) souris.getPosition()).getX() == 500 && ((Point) souris.getPosition()).getY() == 450)
		{
			// Titre + question choix perso && ajout à la fenêtre
			Texte titre2 = new Texte(Couleur.BLANC, "Personnages", new Font("tahoma", Font.BOLD, 32), new Point(500, 600));
			Texte p = new Texte(Couleur.BLANC, "Quel personnage, choisis-tu ?", new Font("tahoma", Font.ITALIC, 20), new Point(400, 450));
			f.ajouter(titre2);
			f.ajouter(p);
			
		}else if(souris.getClicGauche() && ((Point) souris.getPosition()).getX() == 500 && ((Point) souris.getPosition()).getY() == 350)
		{
			/* 2ème écran : Choix personnage */
			// Fond choix perso && ajout
			Texture fondPerso = new Texture("../image/Fond/fondPerso.jpg", new Point(0, 0), 1000, 700);
			f.ajouter(fondPerso);
			// Menu perso
			int choix = 0;
			switch(choix)
			{
				case 1: 
					Texture Perso1 = new Texture("../image/Perso/n.jpg", new Point(700, 100), 700, 100);
					f.ajouter(Perso1);	
					break;
				case 2: 
					Texture Perso2 = new Texture("../image/Perso/leo.jpg", new Point(700, 300), 700, 100);
					f.ajouter(Perso2);
					break;
				case 3: 
					Texture Perso3 = new Texture("../image/Perso/ken.jpg", new Point(700, 500), 700, 500);
					f.ajouter(Perso3);
					break;
				case 4: 
					Texture Perso4 = new Texture("../image/Perso/hongbin.jpg", new Point(400, 100), 400, 100);
					f.ajouter(Perso4);
					break;
				case 5: 
					Texture Perso5 = new Texture("../image/Perso/ravi.jpg", new Point(400, 300), 400, 300);
					f.ajouter(Perso5);
					break;
				case 6: 
					Texture Perso6 = new Texture("../image/Perso/hyuk.jpg", new Point(400, 500), 400, 500);
					f.ajouter(Perso6);
					break;
			}
			// Récupère le personnage choisi en fonction du menu
			if(choix == 1)
			{
				Texture persoChoisi = new Texture("../image/Perso/n.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);
			}else if(choix == 2)
			{
				Texture persoChoisi = new Texture("../image/Perso/leo.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);				
			}else if(choix == 3)
			{
				Texture persoChoisi = new Texture("../image/Perso/ken.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);
			}else if(choix == 4)
			{
				Texture persoChoisi = new Texture("../image/Perso/hongbin.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);
			}else if(choix == 5)
			{
				Texture persoChoisi = new Texture("../image/Perso/ravi.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);
			}else if(choix == 6)
			{
				Texture persoChoisi = new Texture("../image/Perso/hyuk.jpg", new Point(295, 40), 50, 90);
				PersoChoisi.add(persoChoisi);
			}
			
			if(souris.getClicGauche() && souris.getPosition().getX() > 0)
			{
				/* 3ème écran : Eran de jeu */
				// Fond du jeu && ajout
				Texture fond = new Texture("../image/Fond/fond.jpg", new Point(0, 0), 1000, 700);
				f.ajouter(fond);
				f.ajouter(PersoChoisi);
				// Valeur par défaut
				ArrayList<Chant> noteFa = new ArrayList<Chant>();
				ArrayList<Chant> noteSi = new ArrayList<Chant>();
				ArrayList<Bonus> bonus = new ArrayList<Bonus>();
				// Sert a identifier le bonus que le chanteur récupère
				int bonusToucheVaisseau = 0; 
				// Bonus de chant (+ de score)
				boolean bonusChantChanteur = false;
				// Compteur de fans touchés par le chanteur
				int AllFansTouche = 0;
				//Nombre de fans aléatoire à chaque partie
				int randomfans = (int) (Math.random() * (20) + 1);
				Fan fans[] = new Fan[randomfans];
				// Texte affichant la vie du chanteur (initialement à 5)
				Texte vieChanteur = new Texte(Couleur.BLANC,"Vie du joueur: " + chanteur.getVie(), new Font("tahoma", Font.BOLD, 12), new Point(50, 50));
				f.ajouter(vieChanteur);
				// Texte affichant le score (initialement à 0)
				Texte Score = new Texte(Couleur.BLANC, "Score: " + score, new Font("tahoma", Font.BOLD, 18), new Point(0, 950));
				f.ajouter(Score);
				// Position initiale aléatoire des fans
				int xFan;
				int yFan = f.getHeight() - 150;
				// Boucle qui parcourent les fans et les place sur deux lignes
				for (int i = 0; i < randomfans; i++)
				{ 
					xFan = (int) (Math.random() * (f.getWidth() - 116));
					if (i > (randomfans / 2))
					{ 	
						yFan = f.getHeight() - 250;
					}
					fans[i] = (new Fan("../image/Fans/fan1.jpg", new Point(xFan, yFan), 100, 100));
					f.ajouter(fans[i]);
				}
				
				while(true)
				{
					
				}
				
			}
		}else if(souris.getClicGauche() && ((Point) souris.getPosition()).getX() == 500 && ((Point) souris.getPosition()).getY() == 250)
		{
			// Titre + question choix perso && ajout à la fenêtre
			Texte titre3 = new Texte(Couleur.BLANC, "Meilleurs Scores", new Font("tahoma", Font.BOLD, 32), new Point(500, 600));
			Texte affScore = new Texte(Couleur.BLANC, "Score" + score, new Font("tahoma", Font.ITALIC, 20), new Point(400, 450));
			f.ajouter(titre3);
			f.ajouter(affScore);
		}
	}
}
