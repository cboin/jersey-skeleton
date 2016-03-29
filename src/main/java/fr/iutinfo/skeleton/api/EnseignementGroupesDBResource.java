package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/enseignements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnseignementGroupesDBResource {
	private static EnseignementGroupesDao dao = BDDFactory.getDbi().open(EnseignementGroupesDao.class);
	final static Logger logger = LoggerFactory.getLogger(EnseignementGroupesDBResource.class);

	public EnseignementGroupesDBResource() {

	}


	@GET
	@Path("/{codeGroupe}")
	public List<EnseignementGroupes> fromGroupe(@PathParam("codeGroupe") int codeGroupe) {
		return dao.forGroupe(codeGroupe);
	}
	
	

}
