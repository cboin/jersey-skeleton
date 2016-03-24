package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Groupe {
    final static Logger logger = LoggerFactory.getLogger(Groupe.class);

    private String codeGroupe;
    private String couleurFond;
    private String nom;
    private String alias;
   


    public Groupe(String codeGroupe,String nom) {
        this.codeGroupe = codeGroupe;
        this.nom = nom;
        
    }
    
    public Groupe() {
    	
    }

	public String getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}


	
 

	
}
