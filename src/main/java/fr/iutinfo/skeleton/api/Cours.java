package fr.iutinfo.skeleton.api;

import java.util.Date;

public class Cours {


	private Date dateSeance;
	private int heureSeance;
	private int dureeSeance;
	private int codeSeance;
	private int codeRessource;
	private int codeGroupe;
	private String nom;
	private String alias;

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public int getHeureSeance() {
		return heureSeance;
	}

	public void setHeureSeance(int heureSeance) {
		this.heureSeance = heureSeance;
	}

	public int getDureeSeance() {
		return dureeSeance;
	}

	public void setDureeSeance(int dureeSeance) {
		this.dureeSeance = dureeSeance;
	}

	public int getCodeSeance() {
		return codeSeance;
	}

	public void setCodeSeance(int codeSeance) {
		this.codeSeance = codeSeance;
	}

	public int getCodeRessource() {
		return codeRessource;
	}

	public void setCodeRessource(int codeRessource) {
		this.codeRessource = codeRessource;
	}

	public int getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(int codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

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
}
