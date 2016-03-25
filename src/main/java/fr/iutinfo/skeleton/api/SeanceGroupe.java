package fr.iutinfo.skeleton.api;

public class SeanceGroupe {
	
	
	private int codeSeance;
	private int codeRessource;
	
	public SeanceGroupe(int codeSeance , int codeRessource){
		this.codeSeance=codeSeance;
		this.codeRessource=codeRessource;
	}
	
	public SeanceGroupe(){
		
	}

	public int getCodeSeance() {
		return codeSeance;
	}

	public void setCodeSeance(int codeSeance) {
		this.codeSeance = codeSeance;
	}

	public int getCodeRessource() {
		return codeRessource;
	}

	public void setCodeRessource(int codeRessource) {
		this.codeRessource = codeRessource;
	}

	
}
