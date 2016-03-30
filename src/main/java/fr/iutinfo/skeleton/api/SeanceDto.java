package fr.iutinfo.skeleton.api;

import java.util.Date;

public class SeanceDto {

	private Date dateSeance;
	private int heureSeance;
	private int codeEnseignement;
	private int codeGroupe;
	private int codeSeance;
	private int dureeSeance;
	private int codeProprietaire = Api.CODE_PROPRIO;
	
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

	public int getCodeEnseignement() {
		return codeEnseignement;
	}

	public void setCodeEnseignement(int codeEnseignement) {
		this.codeEnseignement = codeEnseignement;
	}

	public int getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(int codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public int getCodeSeance() {
		return codeSeance;
	}

	public void setCodeSeance(int codeSeance) {
		this.codeSeance = codeSeance;
	}

	public int getDureeSeance() {
		return dureeSeance;
	}

	public void setDureeSeance(int dureeSeance) {
		this.dureeSeance = dureeSeance;
	}

	public int getCodeProprietaire() {
		return codeProprietaire;
	}

	public void setCodeProprietaire(int codeProprietaire) {
		this.codeProprietaire = codeProprietaire;
	}
}
