package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface CoursDao {


	@SqlQuery("SELECT\n" +
			"seances.codeEnseignement,\n" +
			"seances.dateSeance,\n" +
			"seances.heureSeance,\n" +
			"seances.dureeSeance,\n" +
			"seances.codeSeance,\n" +
			"seances_groupes.codeRessource AS codeGroupe,\n" +
			"enseignements.nom AS moduleNom,\n" +
			"enseignements.alias,\n" +
			"ressources_profs.nom AS nomProf,\n" +
			"ressources_groupes.nom AS nomGroupe\n" +
			"FROM\n" +
			"seances_groupes\n" +
			"INNER JOIN seances ON seances.codeSeance = seances_groupes.codeSeance\n" +
			"INNER JOIN enseignements ON seances.codeEnseignement = enseignements.codeEnseignement\n" +
			"INNER JOIN enseignements_profs AS ep ON enseignements.codeEnseignement = ep.codeEnseignement AND ep.deleted = 0\n" +
			"INNER JOIN ressources_profs ON ep.codeRessource = ressources_profs.codeProf\n" +
			"INNER JOIN ressources_groupes ON seances_groupes.codeRessource = ressources_groupes.codeGroupe\n" +
			"WHERE \n" +
			"seances_groupes.codeRessource = :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Cours> findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);



	void close();

}