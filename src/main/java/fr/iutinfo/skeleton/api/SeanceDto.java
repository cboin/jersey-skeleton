package fr.iutinfo.skeleton.api;

import java.util.Date;

public class SeanceDto {

	private Date dateSeance;
	private int heureSeance;
	private int Enseignement;
	private String Groupe;
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
	
	public int getEnseignement() {
		return Enseignement;
	}
	
	public void setEnseignement(int enseignement) {
		Enseignement = enseignement;
	}
	
	public String getGroupe() {
		return Groupe;
	}
	
	public void setGroupe(String groupe) {
		Groupe = groupe;
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
