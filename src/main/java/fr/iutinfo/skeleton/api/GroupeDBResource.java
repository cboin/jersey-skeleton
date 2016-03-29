package fr.iutinfo.skeleton.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/groupe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupeDBResource {
	private static GroupeDao dao = BDDFactory.getDbi().open(GroupeDao.class);
	final static Logger logger = LoggerFactory.getLogger(GroupeDBResource.class);

	public GroupeDBResource() {
		
	}
	
	@POST 
	Groupe createGroupe(Groupe groupe) {
        dao.insert(groupe);
		return groupe;
	}

	

	@GET
	public List<Groupe> getAllGroupes() {
		return dao.all();
	}
	
	 @GET
		@Path("/{nom}")
		public Groupe getGroupe(@PathParam("nom") String nom) {
			Groupe groupe = dao.findByName(nom);
			if (groupe == null) {
				throw new WebApplicationException(404);
			}
			return groupe;
		}
	    
	
	

}
