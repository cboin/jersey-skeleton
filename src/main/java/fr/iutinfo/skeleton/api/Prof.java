package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Prof {
    final static Logger logger = LoggerFactory.getLogger(Prof.class);

    private int codeProf;
    private int couleurFond;
    private String nom;
    private String prenom;
    private String alias;
	private int codeComposante;
   


    public Prof(int codeProf, String nom , String prenom, int codeComposante) {
        this.codeProf = codeProf;
        this.nom = nom;
        this.prenom = prenom;
		this.codeComposante = codeComposante;
	}


    public Prof() {
    }


	public int getCodeProf() {
		return codeProf;
	}


	public void setCodeProf(int codeProf) {
		this.codeProf = codeProf;
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getCodeComposante() {
		return codeComposante;
	}

	public void setCodeComposante(int codeComposante) {
		this.codeComposante = codeComposante;
	}
}
