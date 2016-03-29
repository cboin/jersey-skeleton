package fr.iutinfo.skeleton.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class HelperGroupe extends Helper {

	private static GroupeDao dao = null;
	
	public HelperGroupe(WebTarget target) {
		super(target);
		dao = BDDFactory.getDbiForSqlite().open(GroupeDao.class);
	}

	@Override
	public void initDb() {
		dao.dropTable();
		dao.createTable();		
	}
		
	public Groupe createGroupeWithName(String name){
		Groupe groupe = new Groupe();
		groupe.setNom(name);
		return doPost(groupe);
	}

	public Groupe doPost(Groupe groupe){
		Entity<Groupe> groupeEntity = Entity.entity(groupe, MediaType.APPLICATION_JSON);
        return target.request().post(groupeEntity).readEntity(Groupe.class);
	}
	
	public Groupe doCreateInBdd(Groupe groupe) {
		int id = dao.insert(groupe);
		groupe.setCodeGroupe(id);
		return groupe;
	}

	public void deleteGroupeWithName(String string) {
		dao.deleteGroupeWithName(string);
	}
}
