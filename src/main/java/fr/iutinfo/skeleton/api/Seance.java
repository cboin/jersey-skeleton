package fr.iutinfo.skeleton.api;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Seance {
	
	final static Logger logger = LoggerFactory.getLogger(Seance.class);
	
	private int codeSeance;
	private Date dateSeance;
	private int heureSeance;
	private int dureeSeance;
	private int diffusable;
	private int dateModif;
	private String Enseignement;
	private String Salle;
	private String Groupe;
	private String Prof;
	private String GroupeId;
	private int couleurFond;
	private int couleurPolice;	
	
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



	public int getDiffusable() {
		return diffusable;
	}



	public void setDiffusable(int diffusable) {
		this.diffusable = diffusable;
	}



	public int getDateModif() {
		return dateModif;
	}



	public void setDateModif(int dateModif) {
		this.dateModif = dateModif;
	}



	public String getEnseignement() {
		return Enseignement;
	}



	public void setEnseignement(String enseignement) {
		Enseignement = enseignement;
	}



	public String getSalle() {
		return Salle;
	}



	public void setSalle(String salle) {
		Salle = salle;
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



	public String getGroupeId() {
		return GroupeId;
	}



	public void setGroupeId(String groupeId) {
		GroupeId = groupeId;
	}



	public int getCouleurFond() {
		return couleurFond;
	}



	public void setCouleurFond(int couleurFond) {
		this.couleurFond = couleurFond;
	}



	public int getCouleurPolice() {
		return couleurPolice;
	}



	public void setCouleurPolice(int couleurPolice) {
		this.couleurPolice = couleurPolice;
	}


	
}
