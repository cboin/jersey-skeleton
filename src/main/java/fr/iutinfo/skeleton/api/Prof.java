package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Prof {
    final static Logger logger = LoggerFactory.getLogger(Prof.class);

    private String codeProf;
    private String couleurFond;
    private String nom;
    private String prenom;
    private String alias;
   


    public Prof(String codeProf, String nom , String prenom) {
        this.codeProf = codeProf;
        this.nom = nom;
        this.prenom = prenom;
    }


    public Prof() {
    }


	public String getCodeProf() {
		return codeProf;
	}


	public void setCodeProf(String codeProf) {
		this.codeProf = codeProf;
	}


	public String getCouleurFond() {
		return couleurFond;
	}


	public void setCouleurFond(String couleurFond) {
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

 

	
}
