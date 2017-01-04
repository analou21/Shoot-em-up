package Main;

import java.awt.Font;
import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;

public class Main 
{

	public static void main(String[] args) 
	{
		Fenetre f = new Fenetre("Shoot'em Up : chanteur vs fans hystériques", 1000, 650);
		Clavier clavier = new Clavier();
		Souris souris = new Souris(480);
		f.addKeyListener(clavier);
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		f.addMouseMotionListener(souris);
		
		/*// Ecran d'accueil
		Texture fondAccueil = new Texture("../fondAccueil.jpg", new Point(0, 0), 1000, 700);*/
		

		// valeurs amenées à changer en fonction du mode
		Texture fond = new Texture("../image/Fond/fond.jpg", new Point(0, 0), 1000, 700);
		Chanteur chanteur = new Chanteur("../image/Perso/leo.jpg", new Point(295, 40), 49, 85);
		ArrayList<Chant> noteFa = new ArrayList<Chant>();
		ArrayList<Chant> noteSi = new ArrayList<Chant>();
		ArrayList<Bonus> bonus = new ArrayList<Bonus>();
		int score = 0;
		
		// Fréquence du chant du chanteur
		int freqChanteur = 0;
		int freqFans = 0;
		int freqBonus = 0;
		// Sert a identifier le bonus que le chanteur récupère
		int bonusToucheVaisseau = 0; 
		// 3 bonus différents
		boolean bonusVitesse = false;
		boolean malusVitesse = false;
		boolean bonusChantChanteur = false;
				
		f.ajouter(fond);
		
		// Compteur de fans touchés par le chanteur
		int AllFansTouche = 0;
		
		//Nombre de fans aléatoire à chaque partie
		int randomfans = (int) (Math.random() * (20) + 1);
		Fan fans[] = new Fan[randomfans];
				
		// Texte affichant la vie du chanteur (initialement à 5)
		Texte vieChanteur = new Texte(Couleur.BLANC,"Vie du joueur: " + chanteur.getVie(), new Font("tahoma", 12, 12), new Point(50, 50));
		f.ajouter(vieChanteur);
		
		// Texte affichant le score (initialement à 0)
		Texte Score = new Texte(Couleur.BLANC, "Score: " + score, new Font("tahoma", 18, 18), new Point(0, 950));
		f.ajouter(Score);

		// Position initiale aléatoire des fans
		int xFan;
		int yFan = f.getHeight() - 150;
		
		/*
		 * Boucle parcourant tous les fans, affiche aléatoirement la moitié sur une ligne et l'autre moitié
		 * sur la deuxième ligne
		*/		
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

		// Ajout du chanteur
		f.ajouter(chanteur);

		// boucle si le chanteur a encore des vies et si tous les fans n'ont pas ete touches
		while (true && chanteur.getVie() > 0 && AllFansTouche < randomfans)
		{
			try 
			{
				Thread.sleep(30);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			// On incrémente les fréquences à chaque tour
			freqBonus++;
			freqChanteur++;
			freqFans++;
					
			f.setAffichageFPS(true);
			// Déplacement du chanteur si bonus vitesse actif
			if (bonusVitesse)
			{ 
				if (clavier.getDroite() && chanteur.getB().getX() < f.getWidth()) 
				{
					chanteur.translater(20, 0);
				} else if (clavier.getGauche() && chanteur.getA().getX() > 0)
				{
					chanteur.translater(-20, 0);
				} else if (clavier.getHaut() && chanteur.getB().getY() < f.getHeight() / 2)
				{
					chanteur.translater(0, 20);
				} else if (clavier.getBas() && chanteur.getB().getY() > chanteur.getHauteur()) 
				{
					chanteur.translater(0, -20);
				}
			}
			// Déplacement du chanteur si malus vitesse
			else if (malusVitesse) 
			{ 
				if (clavier.getDroite() && chanteur.getB().getX() < f.getWidth()) 
				{
					chanteur.translater(4, 0);
				} else if (clavier.getGauche() && chanteur.getA().getX() > 0) 
				{
					chanteur.translater(-4, 0);
				} else if (clavier.getHaut() && chanteur.getB().getY() < f.getHeight() / 2)
				{
					chanteur.translater(0, 4);
				} else if (clavier.getBas() && chanteur.getB().getY() > chanteur.getHauteur())
				{
					chanteur.translater(0, -4);
				}
			// Sinon vitesse normale
			}else if (clavier.getDroite() && chanteur.getB().getX() < f.getWidth())
			{ 
				chanteur.translater(8, 0);
			} else if (clavier.getGauche() && chanteur.getA().getX() > 0)
			{
				chanteur.translater(-8, 0);
			} else if (clavier.getHaut() && chanteur.getB().getY() < f.getHeight() / 2)
			{
				chanteur.translater(0, 8);
			} else if (clavier.getBas() && chanteur.getB().getY() > chanteur.getHauteur()) 
			{
				chanteur.translater(0, -8);
			}
			// Chant du Chanteur
			if (clavier.getEspace())
			{
				// Chant sans bonus, fréquence "normale"
				if (!bonusChantChanteur && freqChanteur > 15 )
				{
					Chant NoteFa = new Chant("../image/Perso/note.jpg", new Point((chanteur.getA().getX() + chanteur.getLargeur() / 2), 
							((chanteur.getB().getY())) + 10), 21, 34);
					noteFa.add(NoteFa);
					f.ajouter(NoteFa);
					freqChanteur = 0;
						
				}
				// Chant avec bonus, augmente la fréquence du chant >> réduction de la fréquence du chant
				else if(bonusChantChanteur && freqChanteur > 5)
				{  
					Chant noteBonusChanteur = new Chant("../image/Perso/notePlus.jpg", new Point((chanteur.getA().getX() + chanteur.getLargeur() / 2), 
							((chanteur.getB().getY())) + 10), 21, 34);
					noteFa.add(noteBonusChanteur);
					f.ajouter(noteBonusChanteur);
					freqChanteur = 0;
				}
			}
			// Avancement du chant + collisions fans
			for (int indexNoteFa = 0; indexNoteFa < noteFa.size(); indexNoteFa++)
			{
				noteFa.get(indexNoteFa).translater(0, 15);
				// Parcours des ennemis 
				for (int afan = 0; afan < fans.length; afan++)
				{
					// Si le chant du chanteur est encore dans la fenêtre
					if(noteFa.get(indexNoteFa).getA().getY() < f.getHeight())
					{
						//Si c'est un Chant qui n'a encore touché aucun fan et qu'il touche un fan pas encore touché
						if (noteFa.get(indexNoteFa).intersection(fans[afan]) && !noteFa.get(indexNoteFa).getAttaque() 
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
						}
					}
				}
			}
			
			// Déplacement des fans de droite à gauche
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
			
			// Lettre aléatoire des fans
			if (freqFans == 60)
			{
				// Réinitialisation de la fréquence
				freqFans = 0;
				// Choix aléatoire du fans
				int numeroFan = (int) (Math.random() * randomfans);
				// Vérification si le fan existe encore, si oui Chant autorisé
				if (!fans[numeroFan].getFanTouche())
				{
					Chant NoteSi = new Chant("../image/Fans/lettre.png", new Point((fans[numeroFan].getB().getX() - 45),
							((fans[numeroFan].getB().getY()) - 100)), 21, 34); 
					noteSi.add(NoteSi);
					f.ajouter(NoteSi);
				}
			}
			// Avancement des lettres des fans
			for (int i = 0; i < noteSi.size(); i++)
			{
				noteSi.get(i).translater(0, -5);
				// Collisions lettres fans sur Chanteur
				if (noteSi.get(i).intersection(chanteur) && !chanteur.getTouche())
				{
					chanteur.setTouche(true);
					//Décrémente une vie
					chanteur.setVie(chanteur.getVie() - 1);
					// Mise à jour de l'affichage
					vieChanteur.setTexte("Vie du joueur: " + chanteur.getVie());
					f.supprimer(noteSi.get(i));
					noteSi.remove(noteSi.get(i));
					System.out.println(chanteur.getVie()+"Vie");
					chanteur.setTouche(false);
				}
			}
			// Apparition bonus à chaque fois frequence = 300
			if (freqBonus == 300) 
			{
				// Choix random du bonus
				int choixBonus = (int)( Math.random()*3);
				if(choixBonus == 0)
				{
					Bonus missileBonus = new Bonus("../image/Bonus/bonusVitesse.jpg", new Point((int) (Math.random() * 1000), 600), 21, 34);
					bonus.add(missileBonus);
					f.ajouter(missileBonus);
					bonusToucheVaisseau = 1;
				}else if(choixBonus == 1)
				{
					Bonus missileMalus = new Bonus("../image/Bonus/malusVitesse.jpg", new Point((int) (Math.random() * 1000), 600), 21, 34);
					bonus.add(missileMalus);
					f.ajouter(missileMalus);
					bonusToucheVaisseau = 2;
				}else if(choixBonus == 2)
				{
					Bonus bonusTir = new Bonus("../image/Bonus/bonusChant.jpg", new Point((int) (Math.random() * 1000), 600), 21, 34);
					bonus.add(bonusTir);
					f.ajouter(bonusTir);
					bonusToucheVaisseau = 3;
				}
			}
			
			//Translation du bonus
			for (int i = 0; i < bonus.size(); i++) 
			{
				bonus.get(i).translater(0, -5);
				// Différenciation des bonus que le joueur attrape	
				if (bonus.get(i).intersection(chanteur) && bonusToucheVaisseau == 1)
				{
					f.supprimer(bonus.get(i));
					bonus.remove(bonus.get(i));
					bonusVitesse = true;

				}else if(bonus.get(i).intersection(chanteur) && bonusToucheVaisseau == 2)
				{
					f.supprimer(bonus.get(i));
					bonus.remove(bonus.get(i));
					malusVitesse = true;
				}
				else if(bonus.get(i).intersection(chanteur) && bonusToucheVaisseau == 3)
				{
					f.supprimer(bonus.get(i));
					bonus.remove(bonus.get(i));
					bonusChantChanteur = true;
				}
				// Temps du bonus
				if (freqBonus == 310) 
				{
					bonusVitesse = false;
					malusVitesse = false;
					bonusChantChanteur = false;
					freqBonus = 0;
				}
			}
			f.rafraichir();
		}

		// Affichage ecran de fin de jeu
		Rectangle fondGO = new Rectangle(Couleur.GRIS, new Point(0, 0), 1000, 700, true);
		Texte gameover = new Texte(Couleur.ROUGE, "Oh non! Tu as fait sombrer ton chanteur dans une dépression", new Font("tahoma", 20, 20), new Point(500, 300));
		Texte fanLoose = new Texte(Couleur.BLEU, "Bravo! Ton chanteur est en pleine forme et est sauvé des fans hystériques", new Font("tahoma", 20, 20), new Point(500, 300));
		f.ajouter(fondGO);
		if (chanteur.getVie() > 0)
		{
			f.ajouter(fanLoose);
		} else
		{
			f.ajouter(gameover);
		}
	}
}
