package fr.iutinfo.skeleton.api;

import java.util.Date;

public class Seance {
	
	private int codeSeance;
	private Date dateSeance;
	private int heureSeance;
	private int dureeSeance;
	private int codeEnseignement;

	
	public Seance(int codeSeance , Date dateSeance , int heureSeance, int dureeSeance, int codeEnseignement){
		this.codeSeance=codeSeance;
		this.dateSeance=dateSeance;
		this.heureSeance=heureSeance;
		this.dureeSeance=dureeSeance;
		this.codeEnseignement=codeEnseignement;
	}
	
	
	public Seance(){
		
	}


	public int getCodeSeance() {
		return codeSeance;
	}


	public void setCodeSeance(int codeSeance) {
		this.codeSeance = codeSeance;
	}


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


	public int getCodeEnseignement() {
		return codeEnseignement;
	}


	public void setCodeEnseignement(int codeEnseignement) {
		this.codeEnseignement = codeEnseignement;
	}
	
	
}
