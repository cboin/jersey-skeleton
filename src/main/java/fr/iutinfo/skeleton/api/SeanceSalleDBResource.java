package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/seance_salle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SeanceSalleDBResource {
	private static SeanceSalleDao dao = BDDFactory.getDbi().open(SeanceSalleDao.class);
	final static Logger logger = LoggerFactory.getLogger(SeanceSalleDBResource.class);

	public SeanceSalleDBResource() {
		/*
		 * try { dao.createProfTable(); dao.insert(new
		 * Prof("codeProf","nom","prenom")); } catch (Exception e) {
		 * System.out.println("Table déjà là !"); }
		 */
	}

	/*
	 * @POST public Prof createProf(Prof prof) { prof.resetPasswordHash(); int
	 * id = dao.insert(prof); user.setId(id); return prof; }
	 * 
	 * @GET
	 * 
	 * @Path("/{name}") public Prof getProf(@PathParam("name") String name) {
	 * User user = dao.findByName(name); if (user == null) { throw new
	 * WebApplicationException(404); } return user; }
	 */

	@GET
	public List<SeanceSalle> getAllSeancesSalles() {
		return dao.all();
	}

}
