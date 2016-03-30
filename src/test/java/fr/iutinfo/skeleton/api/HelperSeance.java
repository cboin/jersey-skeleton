package fr.iutinfo.skeleton.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class HelperSeance extends Helper {
	private static SeanceDao dao = null;

	public HelperSeance(WebTarget target) {
		super(target);
		dao = BDDFactory.getDbiForSqlite().open(SeanceDao.class);
	}

	@Override
	public void initDb() {
		dao.dropTable();
		dao.createTable();
		
	}

	public Seance createSeanceWithCode(int codeSeance) {
		Seance s = new Seance();
		s.setCodeSeance(codeSeance);
		return doPost(s);
	}

	private Seance doPost(Seance seance) {
		Entity<Seance> seanceEntity = Entity.entity(seance, MediaType.APPLICATION_JSON);
        return target.request().post(seanceEntity).readEntity(Seance.class);
	}
}
