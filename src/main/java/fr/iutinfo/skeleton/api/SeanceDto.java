package fr.iutinfo.skeleton.api;

import java.util.Date;

public class SeanceDto {

	private Date dateSeance;
	private int heureSeance;
	private String Enseignement;
	private String Groupe;
	private String Prof;
	private int codeSeance;
	
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
	
	public String getEnseignement() {
		return Enseignement;
	}
	
	public void setEnseignement(String enseignement) {
		Enseignement = enseignement;
	}
	
	public String getGroupe() {
		return Groupe;
	}
	
	public void setGroupe(String groupe) {
		Groupe = groupe;
	}
	
	public String getProf() {
		return Prof;
	}
	
	public void setProf(String prof) {
		Prof = prof;
	}

	public int getCodeSeance() {
		return codeSeance;
	}

	public void setCodeSeance(int codeSeance) {
		this.codeSeance = codeSeance;
	}
}
