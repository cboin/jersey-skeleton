package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Salle {
	
	 final static Logger logger = LoggerFactory.getLogger(Salle.class);
	 
	 private int codeSalle;
	 private int couleurFond;
	 private String nom;
	 private int capacite;
	 private String alias;
	 
	 
	 public Salle(int codeSalle,String nom, int capacite){
		 this.codeSalle= codeSalle;
		 this.nom=nom;
		 this.capacite=capacite;
	 }
	 
	 public Salle(){
		 
	 }

	public int getCodeSalle() {
		return codeSalle;
	}

	public void setCodeSalle(int codeSalle) {
		this.codeSalle = codeSalle;
	}

	public int getCouleurFond() {
		return couleurFond;
	}

	public void setCouleurFond(int couleurFond) {
		this.couleurFond = couleurFond;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	

}
