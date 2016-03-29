package fr.iutinfo.skeleton.api;

public class Enseignement {

	private String nom;
	private String alias;

	private String composante;
	private int codeComposante;

	private int codeEnseignement;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getComposante() {
		return composante;
	}

	public void setComposante(String composante) {
		this.composante = composante;
	}

	public int getCodeComposante() {
		return codeComposante;
	}

	public void setCodeComposante(int codeComposante) {
		this.codeComposante = codeComposante;
	}

	public int getCodeEnseignement() {
		return codeEnseignement;
	}

	public void setCodeEnseignement(int codeEnseignement) {
		this.codeEnseignement = codeEnseignement;
	}
}
