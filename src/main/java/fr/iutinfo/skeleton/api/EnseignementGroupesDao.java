package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public interface EnseignementGroupesDao {
	

	@SqlQuery("SELECT\n" +
			"ressources_groupes.nom AS nomGroupe,\n" +
			"enseignements.nom,\n" +
			"enseignements.codeEnseignement,\n" +
			"enseignements.alias,\n" +
			"ressources_profs.nom AS profNom,\n" +
			"ressources_profs.prenom AS profPrenom,\n" +
			"ressources_groupes.codeGroupe,\n" +
			"ressources_profs.codeProf\n" +
			"FROM\n" +
			"enseignements\n" +
			"INNER JOIN enseignements_groupes ON enseignements_groupes.codeEnseignement = enseignements.codeEnseignement\n" +
			"INNER JOIN ressources_groupes ON enseignements_groupes.codeRessource = ressources_groupes.codeGroupe\n" +
			"INNER JOIN enseignements_profs ON enseignements_profs.codeEnseignement = enseignements.codeEnseignement\n" +
			"INNER JOIN ressources_profs ON ressources_profs.codeProf = enseignements_profs.codeRessource\n" +
			"WHERE\n" +
			"ressources_groupes.codeGroupe = :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<EnseignementGroupes> forGroupe(@Bind("codeGroupe") int codeGroupe);


	void close();

}