package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
