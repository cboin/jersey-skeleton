package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/enseignements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnseignementDBResource {
	private static EnseignementDao dao = BDDFactory.getDbi().open(EnseignementDao.class);
	final static Logger logger = LoggerFactory.getLogger(EnseignementDBResource.class);

	public EnseignementDBResource() {

	}


	@GET
	public List<Enseignement> getAll() {
		return dao.all();
	}
	
	

}
