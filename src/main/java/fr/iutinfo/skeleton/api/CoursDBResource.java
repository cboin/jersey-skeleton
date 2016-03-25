package fr.iutinfo.skeleton.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/cours")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursDBResource {
	private static CoursDao dao = BDDFactory.getDbi().open(CoursDao.class);
	final static Logger logger = LoggerFactory.getLogger(CoursDBResource.class);

	public CoursDBResource() {

	}


	@GET
	@Path("/{codegroupe}")
	public List<Cours> getCoursFromGroupe(@PathParam("codegroupe") int codegroupe) {
		return dao.findByCodeGroupe(codegroupe);
	}



}
