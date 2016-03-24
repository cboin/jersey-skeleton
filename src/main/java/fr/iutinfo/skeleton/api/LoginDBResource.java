package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginDBResource {
	private static SalleDao dao = BDDFactory.getDbi().open(SalleDao.class);
	final static Logger logger = LoggerFactory.getLogger(LoginDBResource.class);

	public LoginDBResource() {
		/*
		 * try { dao.createProfTable(); dao.insert(new
		 * Prof("codeProf","nom","prenom")); } catch (Exception e) {
		 * System.out.println("Table déjà là !"); }
		 */
	}


	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void post(@FormParam("name") String name) {
		// Store the message
		logger.debug("Coucou je teste avec : " + name);
	}



}
