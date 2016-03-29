package fr.iutinfo.skeleton.api;

public class EnseignementGroupes {

	private String nomGroupe;
	private String nom;
	private int codeEnseignement;
	private String alias;

	private String profNom;
	private String profPrenom;
	private String codeGroupe;
	private String codeProf;


	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCodeEnseignement() {
		return codeEnseignement;
	}

	public void setCodeEnseignement(int codeEnseignement) {
		this.codeEnseignement = codeEnseignement;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getProfNom() {
		return profNom;
	}

	public void setProfNom(String profNom) {
		this.profNom = profNom;
	}

	public String getProfPrenom() {
		return profPrenom;
	}

	public void setProfPrenom(String profPrenom) {
		this.profPrenom = profPrenom;
	}

	public String getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getCodeProf() {
		return codeProf;
	}

	public void setCodeProf(String codeProf) {
		this.codeProf = codeProf;
	}
}
