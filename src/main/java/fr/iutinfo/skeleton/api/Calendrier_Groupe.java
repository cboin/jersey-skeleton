package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Calendrier_Groupe {
    final static Logger logger = LoggerFactory.getLogger(Calendrier_Groupe.class);

    private String code;
    private String codeRessource;
    private int etat;
   
   
    public Calendrier_Groupe(String code,String codeRessource, int etat) {
        this.code = code;
        this.codeRessource = codeRessource;
        this.etat = etat;
        
    }
    
    public Calendrier_Groupe() {
    	
    }
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeRessource() {
		return codeRessource;
	}

	public void setCodeRessource(String codeRessource) {
		this.codeRessource = codeRessource;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	
	
}
