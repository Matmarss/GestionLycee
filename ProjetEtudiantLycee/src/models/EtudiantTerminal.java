package models;

import java.util.Date;

import enu.LevelEnum;

public class EtudiantTerminal extends Etudiant {
	
	private String project;

	public EtudiantTerminal(int number, String name, String surname, Date birth,String project) {
		super(number, name, surname, birth);
		this.project = project;
		this.level = LevelEnum.TERMINAL;
	}

	@Override
	public String toString() {
		return super.toString() + ", projet de fin d'étude: " + this.project;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}
