package models;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author IN-LL-051
 * modifiable pour ajouter plusieurs notes dans une meme matière, avec une liste implemanté dans une hashmap ou une autre liste?
 */
public class ListeMatieres {

	private ArrayList<Matiere> cours = new ArrayList<Matiere>();
	private ArrayList<Float> notes = new ArrayList<Float>();

	public ListeMatieres(ArrayList<Matiere> cours, ArrayList<Float> notes) {
		this.cours = cours;
		this.notes = notes;
	}

	public ListeMatieres(ArrayList<Matiere> cours) {
		this.cours = cours;
	}

	public ListeMatieres() {
	}

	@Override
	public String toString() {
		return "ListeMatieres [cours=" + cours + ", notes=" + notes + "]";
	}

	public Matiere saisieNotesMatiere() {
		boolean var = true;
		int mat = 0;

		while (var == true) {
			System.out.println("\nChoix de la matière:");
			Scanner sc4 = new Scanner(System.in);
			mat = sc4.nextInt();
			if (mat == 1 || mat == 2 || mat == 3 || mat == 4 || mat == 5 || mat == 6 || mat == 7 || mat == 8 || mat == 9
					|| mat == 10) {
				var = false;
			} else {
				System.out.println("Mauvaise saisie");
				var = true;
			}
		}

		Matiere matiere = new Matiere();

		switch (mat) {
		case 1:
			matiere = new Matiere(1, "Math           ", 6, "Mathématique");
			return matiere;
		case 2:
			matiere = new Matiere(2, "Francais       ", 3, "Francais");
			return matiere;
		case 3:
			matiere = new Matiere(3, "Anglais        ", 2, "Anglais");
			return matiere;
		case 4:
			matiere = new Matiere(4, "Allemand       ", 2, "Allemand");
			return matiere;
		case 5:
			matiere = new Matiere(5, "Musique        ", 2, "Musique");
			return matiere;
		case 6:
			matiere = new Matiere(6, "Physique/Chimie", 5, "Physique/Chimie");
			return matiere;
		case 7:
			matiere = new Matiere(7, "Biologie       ", 5, "Biologie");
			return matiere;
		case 8:
			matiere = new Matiere(8, "Economie       ", 5, "Economie");
			return matiere;
		case 9:
			matiere = new Matiere(9, "Latin          ", 2, "Latin");
			return matiere;
		case 10:
			matiere = new Matiere(10, "Sport         ", 4, "Sport");
			return matiere;
		}
		return null;
	}

	public Matiere demanderMatiere() {

		int mat = 0;

		// variable pour la protection de la saisie
		boolean var = true;

		// chercher la matiere à ajouter
		// protection contre les problemes de saisie
		while (var == true) {
			System.out.println("\nListe des matières à ajouter: ");
			System.out.print("1 = Math, ");
			System.out.print("2 = Francais, ");
			System.out.println("3 = Anglais");
			System.out.print("4 = Allemand, ");
			System.out.print("5 = Musique, ");
			System.out.println("6 = Physique/Chimie");
			System.out.print("7 = Biologie, ");
			System.out.print("8 = Economie, ");
			System.out.print("9 = Latin, ");
			System.out.println("10 = Sport");
			System.out.println("Choix:");
			Scanner sc4 = new Scanner(System.in);
			mat = sc4.nextInt();
			if (mat == 1 || mat == 2 || mat == 3 || mat == 4 || mat == 5 || mat == 6 || mat == 7 || mat == 8 || mat == 9
					|| mat == 10) {
				var = false;
			} else {
				System.out.println("Mauvaise saisie");
				var = true;
			}
		}

		Matiere matiere = new Matiere();
		switch (mat) {
		case 1:
			matiere = new Matiere(1, "Math           ", 6, "Mathématique");
			return matiere;
		case 2:
			matiere = new Matiere(2, "Francais       ", 3, "Francais");
			return matiere;
		case 3:
			matiere = new Matiere(3, "Anglais        ", 2, "Anglais");
			return matiere;
		case 4:
			matiere = new Matiere(4, "Allemand       ", 2, "Allemand");
			return matiere;
		case 5:
			matiere = new Matiere(5, "Musique        ", 2, "Musique");
			return matiere;
		case 6:
			matiere = new Matiere(6, "Physique/Chimie", 5, "Physique/Chimie");
			return matiere;
		case 7:
			matiere = new Matiere(7, "Biologie       ", 5, "Biologie");
			return matiere;
		case 8:
			matiere = new Matiere(8, "Economie       ", 5, "Economie");
			return matiere;
		case 9:
			matiere = new Matiere(9, "Latin          ", 2, "Latin");
			return matiere;
		case 10:
			matiere = new Matiere(10, "Sport         ", 4, "Sport");
			return matiere;
		}
		return null;
	}

	public void ajouterMatiere(Matiere matiere) {
		boolean var = true;
		for (int i = 0; i < cours.size(); i++) {
			if (cours.get(i).getCode() == matiere.getCode()) {
				var = false;
			}
		}
		if (var == false) {
			System.out.println("L'eleve a déjà cette matière");
		} else {
			cours.add(matiere);
			System.out.println(matiere.getNom() + " a été ajouté");
			for (int n = 0; n < cours.size(); n++) {
				if (cours.get(n).getCode() == matiere.getCode()) {
					notes.add(n, 0f);
				}
			}
		}
	}

	public void supprimerMatiere(Matiere matiere) {
		cours.remove(matiere);
	}

	public void chercherMatiere(int code) {
		System.out.println(cours.get(code).toString());
	}

	public void ajouterNotes(Matiere matiere, float note) {
		for (int i = 0; i < cours.size(); i++) {
			if (cours.get(i).getCode() == matiere.getCode()) {
				notes.add(i, note);
			}
		}
	}

	public ArrayList<Matiere> getCours() {
		return cours;
	}

	public void setCours(ArrayList<Matiere> cours) {
		this.cours = cours;
	}

	public ArrayList<Float> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Float> notes) {
		this.notes = notes;
	}

}
