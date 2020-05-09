package main;

import java.text.ParseException;

import java.util.Scanner;

import models.Groups;
import models.Matiere;

public class Main {
	public static void main(String[] args) throws ParseException {

		// initialisation de var
		boolean var = true;

		// un scanner par type
		Scanner str = new Scanner(System.in);

		Groups groups = new Groups();

		while (var == true) {
			System.out.println("******Choissiser votre action******");
			System.out.println("Ajout Etudiant...............1");
			System.out.println("Ajout Matiere................2");
			System.out.println("Recherche Etudiant...........3");
			System.out.println("Saisie Notes.................4");
			System.out.println("Affichage Bulletin...........5");
			System.out.println("Suppression Etudiant.........6");
			System.out.println("Liste des admis..............7");
			System.out.println("Sortie.......................8");
			System.out.println("Choix: ");

			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.println("******Ajout Etudiant******");
				groups.addEtudiant();

				break;

			case 2:
				System.out.println("******Ajout Matiere******");

				// demande du numero de carte de l'étudiant
				System.out.println("Numéro de carte de l'étudiant: ");
				Scanner sc2 = new Scanner(System.in);
				int id = sc2.nextInt();
				int etu1 = groups.searchEtudiantById(id);

				// Montrer les matieres de l'étudiant
				System.out.print("Voici les matières de l'élève ");
				groups.afficherNom(id);
				groups.afficherMatieres(id);

				// demander la matiere
				Matiere matiere = groups.getListeEtudiants().get(etu1).getListeMatieres().demanderMatiere();

				// ajouter une matiere a l'etudiant
				groups.getListeEtudiants().get(etu1).getListeMatieres().ajouterMatiere(matiere);

				// afficher la liste des matieres
				// System.out.println(groups.getListeEtudiants().get(etu1).getListeMatieres().getCours().toString());
				break;

			case 3:
				System.out.println("******Recherche Etudiant******");

				// demande du numero de carte de l'étudiant
				System.out.println("Numéro de carte de l'étudiant:");
				Scanner sc3 = new Scanner(System.in);
				int id2 = sc3.nextInt();

				// afficher info etudiant
				groups.afficherEtudiant(id2);
				break;

			case 4:
				System.out.println("******Saisie Notes******");

				// demande du numero de carte de l'étudiant
				System.out.println("Numéro de carte de l'étudiant:");
				Scanner sc4 = new Scanner(System.in);
				int id3 = sc4.nextInt();
				int etu2 = groups.searchEtudiantById(id3);

				// demander la matiere
				System.out.print("Voici les matières de l'élève ");
				groups.afficherNom(id3);
				groups.afficherMatieres(id3);
				// System.out.println(groups.getListeEtudiants().get(etu2).getListeMatieres().getCours().toString());
				Matiere matiere3 = groups.getListeEtudiants().get(etu2).getListeMatieres().saisieNotesMatiere();
				System.out.println("Taper la note:");
				Scanner sc5 = new Scanner(System.in);
				float note = sc5.nextFloat();
				groups.getListeEtudiants().get(etu2).getListeMatieres().ajouterNotes(matiere3, note);
				// System.out.println(groups.getListeEtudiants().get(etu2).getListeMatieres().toString());

				break;

			case 5:
				System.out.println("******Affichage Bulletin******");

				// demande du numero de carte de l'étudiant
				System.out.println("Numéro de carte de l'étudiant:");

				Scanner sc6 = new Scanner(System.in);
				int id4 = sc6.nextInt();
				int etu3 = groups.searchEtudiantById(id4);
				System.out.print("Bulletin de l'eleve");
				groups.afficherNom(id4);
				groups.getListeEtudiants().get(etu3).afficherBulletin();
				break;

			case 6:
				System.out.println("******Suppression Etudiant******");

				// demande du numero de carte de l'étudiant
				System.out.println("Numéro de carte de l'étudiant:");
				Scanner sc31 = new Scanner(System.in);
				id = sc31.nextInt();

				// enleve l'etudiant en fonction de son numero de carte
				groups.removeEtudiant(id);
				System.out.println("L'étudiant a été enlevé");
				break;

			case 7:
				System.out.println("******Liste des admis******");
				groups.eleveAdmis();
				break;

			case 8:
				System.out.println("******Sortie******");
				System.exit(0);
			}
		}
	}
}
