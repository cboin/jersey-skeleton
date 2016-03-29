package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	public Groupe createGroupe(Groupe groupe) {
        int id = dao.insert(groupe);
        logger.debug("Groupe id : " + id);
        groupe.setCodeGroupe(id);
		return groupe;
	}

	

	@GET
	public List<Groupe> getAllGroupes() {
		return dao.all();
	}
	
	@GET
	@Path("/{codeGroupe}")
	public Groupe getGroupeByCode(@PathParam("codeGroupe") int codeGroupe) {
		Groupe g = dao.findByCode(codeGroupe);
		if (g == null)
			throw new WebApplicationException(404);
		return g;
	}
	
	 @GET
		@Path("/nom/{nom}")
		public Groupe getGroupe(@PathParam("nom") String nom) {
			Groupe groupe = dao.findByName(nom);
			if (groupe == null) {
				throw new WebApplicationException(404);
			}
			return groupe;
		}
	    
	@DELETE
	@Path("/{nom}")
	public Groupe deleteGroupe(@PathParam("nom") String nom) {
		Groupe groupe = dao.findByName(nom);
		if (groupe == null) {
			throw new WebApplicationException(404);
		}
		
		dao.deleteGroupeWithName(nom);
		
		return groupe;
		
	}
	
	
	
	
	

}
