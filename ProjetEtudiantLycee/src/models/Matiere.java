package models;

public class Matiere {

	private int code;
	private int coef;
	private String info;
	private String nom;

	public Matiere() {
	}

	public Matiere(int code, String info, int coef, String nom) {
		this.code = code;
		this.info = info;
		this.coef = coef;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Matiere [code=" + code + ", info=" + info + ", coef=" + coef + "]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
