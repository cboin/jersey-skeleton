package fr.iutinfo.skeleton.api;

import java.util.Date;

public class Cours {


	private Date dateSeance;
	private int heureSeance;
	private int dureeSeance;
	private int codeSeance;
	private int codeRessource;
	private int codeEnseignement;
	private int codeGroupe;
	private String moduleNom;
	private String alias;
	private String nomProf;
	private String nomGroupe;

	private String couleurPolice = "";
	private String couleurFond = "";



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

	public String getModuleNom() {
		return moduleNom;
	}

	public void setModuleNom(String moduleNom) {
		this.moduleNom = moduleNom;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public String getCouleurPolice() {
		return couleurPolice;
	}

	public void setCouleurPolice(String couleurPolice) {
		this.couleurPolice = couleurPolice;
	}

	public String getCouleurFond() {
		return couleurFond;
	}

	public void setCouleurFond(String couleurFond) {
		this.couleurFond = couleurFond;
	}

	public int getCodeEnseignement() {
		return codeEnseignement;
	}

	public void setCodeEnseignement(int codeEnseignement) {
		this.codeEnseignement = codeEnseignement;
	}
}
