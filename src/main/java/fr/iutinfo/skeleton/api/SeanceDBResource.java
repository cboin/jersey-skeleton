package fr.iutinfo.skeleton.api;

import java.util.Date;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/seance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SeanceDBResource {
	private static SeanceDao dao = BDDFactory.getDbi().open(SeanceDao.class);
	final static Logger logger = LoggerFactory.getLogger(SeanceDBResource.class);

	public SeanceDBResource() {
		
	}

	@GET
	public List<Seance> getAllSeances() {
		return dao.all();
	}

	@POST
	@Path("/add")
	public void createSeance(SeanceDto event) {
		
		dao.insert(event);
	}
	
	
	@POST
	@Path("/{codeSeance}/horaires")
	public void updateHoraires(@PathParam("codeSeance") int codeSeance, EventDto event) {
		Seance s = dao.findByCodeSeance(codeSeance);

		if (s == null)
			throw new WebApplicationException(404);

		dao.updateHoraires(codeSeance, event);
	}
	
	@GET
	@Path("/{codeSeance}")
	public Seance getSeanceByCode(@PathParam("codeSeance") int codeSeance) {
		Seance s = dao.findByCodeSeance(codeSeance);
		
		if (s == null)
			throw new WebApplicationException(404);
		
		return s;
	}



	@DELETE
	@Path("/{codeSeance}")
	public void removeSeance(@PathParam("codeSeance") int codeSeance) {
		Seance s = dao.findByCodeSeance(codeSeance);

		if (s == null)
			throw new WebApplicationException(404);

		dao.deleteSeanceWithId(codeSeance);
		dao.deleteSeanceGroupeWithId(codeSeance);
	}


}
