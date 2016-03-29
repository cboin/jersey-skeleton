package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/prof")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfDBResource {
	private static ProfDao dao = BDDFactory.getDbi().open(ProfDao.class);
	final static Logger logger = LoggerFactory.getLogger(ProfDBResource.class);

	public ProfDBResource() {
		/*
		 * try { dao.createProfTable(); dao.insert(new
		 * Prof("codeProf","nom","prenom")); } catch (Exception e) {
		 * System.out.println("Table déjà là !"); }
		 */
	}



	@GET
	public List<Prof> getAllProfs() {
		return dao.all();
	}


	@GET
	@Path("/{codeEnseignement}")
	public Prof getProfFromCours(@PathParam("codeSeance") int codeEnseignement) {
		return dao.getProfFromCours(codeEnseignement);
	}



}
