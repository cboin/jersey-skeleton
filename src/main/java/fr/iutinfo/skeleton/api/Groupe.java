package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Groupe {
    final static Logger logger = LoggerFactory.getLogger(Groupe.class);

    private int codeGroupe;
    private int couleurFond;
    private String nom;
    private String alias;
   


    public Groupe(int codeGroupe,String nom) {
        this.codeGroupe = codeGroupe;
        this.nom = nom;
        
    }
    
    public Groupe() {
    	
    }

	public int getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(int codeGroupe) {
		this.codeGroupe = codeGroupe;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}


	
 

	
}
