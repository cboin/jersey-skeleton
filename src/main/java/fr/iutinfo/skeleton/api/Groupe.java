package fr.iutinfo.skeleton.api;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Groupe  {
    final static Logger logger = LoggerFactory.getLogger(Groupe.class);

   
    private int codeGroupe;
    private int codeComposante;
    private int couleurFond;
    private String nom;
    private String alias;
    private String identifiant;
   


    public Groupe(int codeGroupe,String nom, String identifiant) {
        this.codeGroupe = codeGroupe;
        this.nom = nom;
        
    }
    

	public Groupe() {
    	
    }

	public String buildCouleurHex(){
		return "#" + (""+couleurFond).substring(2);
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

	public String getIdentifiant() {
			return identifiant;
	}

	public void setIdentifiant(String identifiant) {
			this.identifiant = identifiant;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + codeGroupe;
		result = prime * result + couleurFond;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (codeGroupe != other.codeGroupe)
			return false;
		if (couleurFond != other.couleurFond)
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public int getCodeComposante() {
		return codeComposante;
	}

	public void setCodeComposante(int codeComposante) {
		this.codeComposante = codeComposante;
	}
}
