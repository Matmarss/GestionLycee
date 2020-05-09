package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import enu.LevelEnum;

public class Groups {

	private LevelEnum lev = null;
	private int MAX = 30;
	private int s = 0;
	private int p = 0;
	private int t = 0;
	private String choix = null;
	private String level = null;

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

	public void addEtudiant() throws ParseException {

		// mise en place de la variable pour la protection de saisie
		boolean var1 = true;

		// Mise en place du scanner
		Scanner st = new Scanner(System.in);

		// choix pour savoir si l'étudiant est deja en terminal ou pas
		// protection contre une mauvaise saisie
		while (var1 == true) {
			System.out.println("Voulez-vous ajouter un élève en terminal ? (Y/N)");
			choix = st.next();
			if (choix.equals("Y") || choix.equals("N")) {
				var1 = false;
			} else {
				System.out.println("Mauvaise saisie");
				var1 = true;
			}
		}

		// connaitre le nombre d'eleves par niveau
		for (Etudiant etudiants : listeEtudiants) {
			if (etudiants.level == LevelEnum.PREMIERE) {
				p = p++;
			} else if (etudiants.level == LevelEnum.SECONDE) {
				s = s++;
			} else {
				t = t++;
			}
		}

		if (choix.equals("N")) {
			// Mise en place des scanners
			Scanner sc = new Scanner(System.in);
			Scanner str = new Scanner(System.in);

			// Implementation de l'etudiant
			System.out.println("Numéro de carte de l'étudiant:");
			int number = sc.nextInt();
			System.out.println("Nom:");
			String name = str.nextLine();
			System.out.println("Prenom:");
			String surname = str.nextLine();

			while (var1 == false) {
				System.out.println("Classe: (Seconde ou Premiere)");
				level = str.nextLine();
				if (level.equals("Seconde") || level.equals("Premiere")) {
					var1 = true;
				} else {
					System.out.println("Mauvaise saisie");
					var1 = false;
				}
			}
			if (level.equals("Seconde")) {
				s = s++;
				lev = LevelEnum.SECONDE;
			} else if (level.equals("Premiere")) {
				p = p++;
				lev = LevelEnum.PREMIERE;
			}
			System.out.println("Date de naissance (format \"dd/MM/yyyy\"):");
			String birth = str.nextLine();
			Etudiant etudiant = new Etudiant(number, name, surname, formatter.parse(birth), lev);
			if (p > MAX || s > MAX) {
				System.out.println("Plus de place dans cette classe");
				var1 = true;
			} else {
				Matiere math = new Matiere(1, "Math           ", 6, "Mathématique");
				Matiere francais = new Matiere(2, "Francais       ", 3, "Francais");
				etudiant.getListeMatieres().getCours().add(math);
				etudiant.getListeMatieres().getNotes().add(0f);
				etudiant.getListeMatieres().getCours().add(francais);
				etudiant.getListeMatieres().getNotes().add(0f);
				listeEtudiants.add(etudiant);
				var1 = true;
			}
		} else {
			// Mise en place des scanners
			Scanner sc = new Scanner(System.in);
			Scanner str = new Scanner(System.in);

			// Implementation de l'etudiant en terminal
			System.out.println("Numéro de carte de l'étudiant:");
			int number = sc.nextInt();
			System.out.println("Nom:");
			String name = str.nextLine();
			System.out.println("Prenom:");
			String surname = str.nextLine();
			System.out.println("Date de naissance (format \"dd/MM/yyyy\"):");
			String birth = str.nextLine();
			System.out.println("Project:");
			String project = str.nextLine();
			Etudiant etudiant = new EtudiantTerminal(number, name, surname, formatter.parse(birth), project);
			if (t > MAX) {
				System.out.println("Plus de place dans cette classe");
				var1 = true;
			} else {
				Matiere math = new Matiere(1, "Math           ", 6, "Mathématique");
				Matiere francais = new Matiere(2, "Francais       ", 3, "Francais");
				etudiant.getListeMatieres().getCours().add(francais);
				etudiant.getListeMatieres().getNotes().add(0f);
				etudiant.getListeMatieres().getCours().add(math);
				etudiant.getListeMatieres().getNotes().add(0f);
				listeEtudiants.add(etudiant);
				var1 = true;
			}

		}
	}

	public void removeEtudiant(int num) {
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getNumber() == num) {
				listeEtudiants.remove(i);
			}
		}
	}

	public int searchEtudiantById(int num) {
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getNumber() == num) {
				return i;
			}
		}
		return -1;
	}

	public void afficherEtudiant(int num) {
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getNumber() == num) {
				System.out.println(e.toString());
			}
		}
	}

	public void afficherNom(int num) {
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getNumber() == num) {
				System.out.println(e.getName());
			}
		}
	}

	public void afficherMatieres(int num) {
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getNumber() == num) {
				for (int o = 0; o < e.getListeMatieres().getCours().size(); o++) {
					System.out.print(e.getListeMatieres().getCours().get(o).getCode() + " = "
							+ e.getListeMatieres().getCours().get(o).getNom() + " /");
				}
			}
		}
	}

	public void eleveAdmis() {

		String classe = null;
		LevelEnum level = null;

		// mise en place de la variable pour la protection de saisie
		boolean var1 = true;

		// choix de la classe
		// protection contre une mauvaise saisie
		while (var1 == true) {
			System.out.println("Liste des admis de quelle classe ?");
			Scanner str2 = new Scanner(System.in);
			classe = str2.next();
			if (classe.equals("Seconde") || classe.equals("Premiere") || classe.equals("Terminal")) {
				var1 = false;
			} else {
				System.out.println("Mauvaise saisie");
				var1 = true;
			}
		}

		// Change le type de l'attribu classe vers le typeEnum qui correspond au
		// type du level dans la class de l'étudiant
		switch (classe) {
		case ("Seconde"):
			level = LevelEnum.SECONDE;
			break;
		case ("Premiere"):
			level = LevelEnum.PREMIERE;
			break;
		case ("Terminal"):
			level = LevelEnum.TERMINAL;
			break;
		}

		// Calcule de la moyenne pour connaitre les admis
		HashMap<String, Float> listeAdmis = new HashMap<>();
		Etudiant e;
		for (int i = 0; i < listeEtudiants.size(); i++) {
			e = (Etudiant) listeEtudiants.get(i);
			if (e.getLevel() == level && e.calculerMoyenne() > 10) {
				listeAdmis.put(e.getName(), e.calculerMoyenne());
			}
		}

		// Admis par note decroissante
		System.out.print("Admis de la classe :");
		System.out.println(level);

		// si aucun admis
		if (listeAdmis.size() == 0) {
			System.out.println("Aucun admis");
		}
		listeAdmis.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.forEachOrdered(System.out::println);
	}

	public ArrayList<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

}
