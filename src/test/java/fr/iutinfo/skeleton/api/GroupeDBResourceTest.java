package fr.iutinfo.skeleton.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.ws.rs.core.Application;

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
		Groupe groupe = target("/groupe/n4p2").request().get(Groupe.class);
		assertEquals("n4p2", groupe.getNom());
	}
	
	@Test
	public void should_return_404_status(){
		hg.deleteGroupeWithName("n4p2");
		int status = target("/groupe/n4p2").request().get().getStatus();
		assertEquals(404, status);
	}

}
