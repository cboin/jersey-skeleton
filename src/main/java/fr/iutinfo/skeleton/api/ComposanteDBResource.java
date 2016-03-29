package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/composantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComposanteDBResource {
	private static ComposanteDao dao = BDDFactory.getDbi().open(ComposanteDao.class);
	final static Logger logger = LoggerFactory.getLogger(ComposanteDBResource.class);

	public ComposanteDBResource() {

	}

	@GET
	public List<Composante> getAll() {
		return dao.all();
	}



}
