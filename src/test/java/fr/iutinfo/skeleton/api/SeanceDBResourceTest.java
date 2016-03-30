package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeanceDBResourceTest extends JerseyTest {
	final static Logger logger = LoggerFactory.getLogger(SeanceDBResource.class);

	private HelperSeance h;

	@Override
	protected Application configure() {
		return new Api();
	}

	@Before
	public void init() {
		h = new HelperSeance(target("/seance"));
		h.initDb();
	}

	@Test
	public void create_seance_with_code() {
		h.createSeanceWithCode(1);
		Seance seance = target("/seance/1").request().get(Seance.class);
		assertEquals(1, seance.getCodeSeance());
	}

}
