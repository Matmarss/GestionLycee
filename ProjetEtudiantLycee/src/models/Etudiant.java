package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import enu.LevelEnum;

public class Etudiant {

	private int number;
	private String name;
	private String surname;
	private Date birth;
	private ListeMatieres listeMatieres;
	protected LevelEnum level;

	SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

	public Etudiant(int number, String name, String surname, Date birth) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		listeMatieres = new ListeMatieres();
	}

	public Etudiant(int number, String name, String surname, Date birth, LevelEnum level) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.level = level;
		listeMatieres = new ListeMatieres();
	}

	@Override
	public String toString() {
		return "Numéro de carte=" + number + ", Nom=" + name + ", Prénom=" + surname + ", Date de naissance="
				+ formatter.format(birth) + ", Classe=" + level;
	}

	public float calculerMoyenne() {
		float total = 0, moy = 0;
		int nbr = 0;
		for (int i = 0; i < getListeMatieres().getCours().size(); i++) {
			total += getListeMatieres().getCours().get(i).getCoef() * getListeMatieres().getNotes().get(i);
			nbr = nbr + 1 * getListeMatieres().getCours().get(i).getCoef();
		}
		moy = total / nbr;
		return moy;
	}

	public void afficherBulletin() {	
		System.out.println("Matière \t\tCoefficient \tNote \tTotal Matière");
		for (int i = 0; i < getListeMatieres().getCours().size(); i++) {
			System.out.print(getListeMatieres().getCours().get(i).getInfo() + "\t"
					+ getListeMatieres().getCours().get(i).getCoef() + "\t\t"
					+ getListeMatieres().getNotes().get(i).toString() + "\t");
			System.out.println(getListeMatieres().getCours().get(i).getCoef() * getListeMatieres().getNotes().get(i));
		}
		System.out.println("--------------------------------------------------------");
		System.out.print("Moyenne générale\t\t\t");
		System.out.println(calculerMoyenne());
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LevelEnum getLevel() {
		return this.level;
	}

	public void setLevel(LevelEnum level) {
		this.level = level;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public ListeMatieres getListeMatieres() {
		return this.listeMatieres;
	}

	public void setListeMatieres(ListeMatieres listeMatieres) {
		this.listeMatieres = listeMatieres;
	}

}
