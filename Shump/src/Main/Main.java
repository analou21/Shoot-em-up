package Main;

import java.awt.Font;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

public class Main 
{
	public static void main(String[] args) 
	{
		// Instanciation de la fenêtre
		Fenetre f = new Fenetre("Music's Shmup", 1000, 650);
		// Instanciation du clavier
		Clavier clavier = new Clavier();
		// Instanciation de la souris
		Souris souris = new Souris(650);
		// Paramètrage du clavier et de la souris
		f.addKeyListener(clavier);
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		f.addMouseMotionListener(souris);
		// Variables pour rediriger
		boolean accueil = true;
		/* Valeurs variantes */
		// Instanciation du score
		int score = 0;
		// Fréquence du chanteur, des fans
		int freqChanteur = 0;
		int freqFans = 0;
		
		if(accueil)
		{
			accueil = false;
			/** 1er écran : Ecran d'accueil **/
			// Fond de l'écran d'accueil
			Texture fondAccueil = new Texture("../image/Fond/fondAccueil.jpg", new Point(0, 0), 1000, 700);
			// Ajout du fond à la fenêtre
			f.ajouter(fondAccueil);
			// Position des textes
			// Titre du jeu + menu && ajout à la fenêtre
			Texte titre = new Texte(Couleur.BLANC, "Shoot'em up : Chanteurs vs Fans hystériques", new Font("tahoma", Font.BOLD, 32), new Point(500, 600));
			Texture regle = new Texture("../image/Menu/Regles.png", new Point(500, 450));
			Texture gamestart = new Texture("../image/Menu/Game.png", new Point(500, 350));
			f.ajouter(titre);
			f.ajouter(regle);
			f.ajouter(gamestart);
		
			while(true)
			{
				try 
				{
					Thread.sleep (20);
				}
				catch ( Exception e ) 
				{
					System.out.println ( e );
				}			
				try 
				{
					Thread.sleep(30);
				}
				catch (InterruptedException ex) {}
				/* Clic sur l'une des textures qui composent le menu */
				boolean clic=souris.getClicGauche();
				if(clic && regle.intersection(souris.getPosition()))
				{
					f.supprimer(titre);
					f.supprimer(regle);
					f.supprimer(gamestart);
					// Titre + règles && ajout à la fenêtre
					Texte titre1 = new Texte(Couleur.BLANC, "Shoot'em up : Chanteurs vs Fans Hystériques", 
							new Font("tahoma", Font.ITALIC, 32), new Point(500, 600));
					Texte ligne = new Texte(Couleur.BLANC, "Les fans s'en prennent aux célébrités.", 
							new Font("tahoma", Font.ITALIC, 20), new Point(500, 450));
					Texte ligne1 = new Texte(Couleur.BLANC, "Stoppent-les en leurs envoyant des chansons.", 
							new Font("tahoma", Font.ITALIC, 20), new Point(500, 350));
					Texte ligne2 = new Texte(Couleur.BLANC, "Sinon, les chanteurs risquent de sombrer.", 
							new Font("tahoma", Font.ITALIC, 20), new Point(500, 250));
					Texture back = new Texture("../image/Menu/Retour.png", new Point(700, 20));
					f.ajouter(titre1);
					f.ajouter(ligne);
					f.ajouter(ligne1);
					f.ajouter(ligne2);
					f.ajouter(back);
					if(clic && back.intersection(souris.getPosition()))
					{
						accueil = true;
						System.out.println(accueil);
					}
				}else if(clic && gamestart.intersection(souris.getPosition()))
				{
					// Suppression de l'ancien affichage
					f.supprimer(fondAccueil);
					f.supprimer(titre);
					f.supprimer(regle);
					f.supprimer(gamestart);
					/** 2ème écran : Ecran de Jeu **/
					// Fond liste perso && ajout
					Texture game = new Texture("../image/Fond/fond.jpg", new Point(0, 0), 1000, 700);
					f.ajouter(game);
					// Personnage
					Chanteur chanteur = new Chanteur("../image/Perso/leo.jpg", new Point(300, 0), 90, 100);
					f.ajouter(chanteur);
					/* Valeur par défaut */
					ArrayList<Chant> noteFa = new ArrayList<Chant>();
					ArrayList<Chant> noteSi = new ArrayList<Chant>();
					// Compteur de fans touchés par le chanteur
					int AllFansTouche = 0;
					/* Nombre de fans aléatoire à chaque partie */
					int randomfans = (int) (Math.random() * (20) + 1);
					Fan fans[] = new Fan[randomfans];
					// Texte affichant la vie du chanteur (initialement à 5)
					Texte vieChanteur = new Texte(Couleur.BLANC,"Vie du joueur : " + chanteur.getVie(), new Font("tahoma", Font.BOLD, 18), 
						new Point(90, 50));
					f.ajouter(vieChanteur);
					// Texte affichant le score (initialement à 0)
					Texte Score = new Texte(Couleur.BLANC, "Score : " + score, new Font("tahoma", Font.BOLD, 18), new Point(900, 60));
					f.ajouter(Score);
					// Position initiale aléatoire des fans
					int xFan = 0;
					int yFan = f.getHeight() - 150;
					// Boucle qui parcourent les fans et les place sur deux lignes
					for (int i = 0; i < randomfans; i++)
					{ 
						xFan = (int) (Math.random() * (f.getWidth() - 116));
						if(i > (randomfans / 2))
						{ 	
							yFan = f.getHeight() - 250;
						}
						fans[i] = (new Fan("../image/Fans/fan1.jpg", new Point(xFan, yFan), 100, 100));
						f.ajouter(fans[i]);
					}
					// boucle si le chanteur a encore des vies et si tous les fans n'ont pas ete touches
					while(true && chanteur.getVie() > 0 && AllFansTouche < randomfans)
					{
						try 
						{
							Thread.sleep(20);
						}	 
						catch (Exception e) 
						{
							System.out.println(e.getMessage());
						}
						try 
						{
							Thread.sleep(30);
						}
						catch (InterruptedException ex) {}
						// On incrémente les fréquences à chaque tour
						freqChanteur++;
						freqFans++;
						// Déplacement du perso (droite, gauche, haut, bas)
						if(clavier.getDroite() && chanteur.getB().getX() < f.getWidth())
						{ 
							chanteur.translater(8, 0);
						}else if(clavier.getGauche() && chanteur.getA().getX() > 0)
						{
							chanteur.translater(-8, 0);
						}else if(clavier.getHaut() && chanteur.getB().getY() < f.getHeight() / 2)
						{
							chanteur.translater(0, 8);
						}else if(clavier.getBas() && chanteur.getB().getY() > chanteur.getHauteur()) 
						{
							chanteur.translater(0, -8);
						}
						// Chant du Chanteur
						if(clavier.getEspace())
						{
							// Chant
							if(freqChanteur > 15)
							{
								Chant NoteFa = new Chant("../image/Perso/note.jpg", 
									new Point((chanteur.getA().getX() + chanteur.getLargeur() / 2), 
									((chanteur.getB().getY())) + 10), 21, 34);
								noteFa.add(NoteFa);
								f.ajouter(NoteFa);
								freqChanteur = 0;
							}	
						}
						// Avancement du chant + collisions avec fans
						for(int indexNoteFa = 0; indexNoteFa < noteFa.size(); indexNoteFa++)
						{
							noteFa.get(indexNoteFa).translater(0, 15);
							// Parcours des fans 
							for(int afan = 0; afan < fans.length; afan++)
							{
								// Si le chant du chanteur est encore dans la fenêtre
								if(noteFa.get(indexNoteFa).getA().getY() < f.getHeight())
								{
									//Si c'est un Chant qui n'a encore touché aucun fan et qu'il touche un fan pas encore touché
									if(noteFa.get(indexNoteFa).intersection(fans[afan]) && !noteFa.get(indexNoteFa).getAttaque() 
										&& !fans[afan].getFanTouche()) 
									{
										fans[afan].setFanTouche(true);
										// On supprime le fan et le Chant
										f.supprimer(fans[afan]);
										f.supprimer(noteFa.get(indexNoteFa));
										// La note a touché un fan, elle ne pourra plus toucher d'autres fans
										noteFa.get(indexNoteFa).setAttaque(true);
										// Incrémentation du compteur de fans touchés
										AllFansTouche++;
										// Gain de point
										score += 10;
									}
								}
							}
						}
						/* Déplacement des fans de droite à gauche */
						for (int i = 0; i < fans.length; i++)
						{
							if (fans[i].getB().getX() < f.getWidth() + 1 && !(fans[i]).getParoi())
							{
								fans[i].translater(10, 0);
							}
							if (fans[i].getB().getX() > f.getWidth())
							{
								fans[i].setParoi(true);
							}
							if (fans[i].getParoi())
							{
								fans[i].translater(-10, 0);
							}
							if (fans[i].getA().getX() < 0)
							{
								fans[i].setParoi(false);
							}
						}
						/* Lettre aléatoire des fans */
						if (freqFans == 25)
						{
							// Choix aléatoire du fans
							int numeroFan = (int) (Math.random() * randomfans);
							// Encore des fans ? Oui, on peut chanter
							if (!fans[numeroFan].getFanTouche())
							{
								Chant NoteSi = new Chant("../image/Fans/lettre.png", new Point((fans[numeroFan].getB().getX() - 45),
									((fans[numeroFan].getB().getY()) - 100)), 21, 34); 
								noteSi.add(NoteSi);
								f.ajouter(NoteSi);
							}
							// Réinitialisation de la fréquence
							freqFans = 0;
						}
						// Avancement des lettres des fans
						for (int i = 0; i < noteSi.size(); i++)
						{
							noteSi.get(i).translater(0, -15);
							// Collisions lettres fans sur Chanteur
							if(noteSi.get(i).intersection(chanteur) && !chanteur.getTouche())
							{
								chanteur.setTouche(true);
								//Décrémente une vie
								chanteur.setVie(chanteur.getVie() - 1);
								// Mise à jour de l'affichage
								vieChanteur.setTexte("Vie du joueur : " + chanteur.getVie());
								f.supprimer(noteSi.get(i));
								noteSi.remove(noteSi.get(i));
								System.out.println(chanteur.getVie()+"Vie");
								chanteur.setTouche(false);
							}
						}
						f.rafraichir();
					}
					// Affichage ecran de fin de jeu
					Texture Gameover = new Texture("../image/Fond/fondGameover.jpg", new Point(0, 0), 1000, 700);
					f.ajouter(Gameover);
					// Ecran perdant
					Texte depression = new Texte(Couleur.ROUGE, "Oh non! Tu as fait sombrer ton chanteur dans une dépression", 
							new Font("tahoma", 20, 20), new Point(500, 300));
					// Ecran gagnant
					Texte fanAime = new Texte(Couleur.BLEU, "Bravo! Ton chanteur est en pleine forme et est sauvé des fans hystériques", 
							new Font("tahoma", 20, 20), new Point(500, 300));
					// Score
					Texte affScore = new Texte(Couleur.GRIS, "Score : " + score, new Font("tahoma", Font.ITALIC, 26), new Point(400, 450));
					if (chanteur.getVie() > 0)
					{
						// Ajout Ecran gagnant + score
						f.ajouter(fanAime);
						f.ajouter(affScore);
					} else
					{
						// Ajout Ecran perdant + score
						f.ajouter(depression);
						f.ajouter(affScore);
					}				
				}
			}
		}
	}
}

