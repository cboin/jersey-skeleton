package fr.iutinfo.skeleton.api;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupeDBResourceTest extends JerseyTest {
	final static Logger logger = LoggerFactory.getLogger(GroupeDBResourceTest.class);

	private HelperGroupe hg;

	@Override
	protected Application configure() {
		return new Api();
	}

	@Before
	public void init() {
		hg = new HelperGroupe(target("/groupe"));
		hg.initDb();
	}

	@Test
	public void create_groupe_with_name() {
		hg.createGroupeWithName("n4p2");
		Groupe groupe = target("/groupe/nom/n4p2").request().get(Groupe.class);
		assertEquals("n4p2", groupe.getNom());
	}

	@Test
	public void should_return_404_status() {
		hg.deleteGroupeWithName("n4p2");
		int status = target("/groupe/nom/n4p2").request().get().getStatus();
		assertEquals(404, status);
	}

	@Test
	public void add_groupe() {
		Groupe groupe = new Groupe(123456, "N3P8", "idN3P8");
		Entity<Groupe> groupeEntity = Entity.entity(groupe, MediaType.APPLICATION_JSON);
		String recv = target("/groupe").request().post(groupeEntity).readEntity(String.class);
		assertEquals("{\"codeGroupe\":1,\"couleurFond\":0,\"nom\":\"N3P8\"}", recv);
	}

}
