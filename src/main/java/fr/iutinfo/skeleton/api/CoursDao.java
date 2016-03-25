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
			"seances_groupes.codeRessource,\n" +
			"enseignements.nom,\n" +
			"enseignements.alias\n" +
			"FROM\n" +
			"seances_groupes\n" +
			"INNER JOIN seances ON seances.codeSeance = seances_groupes.codeSeance\n" +
			"INNER JOIN enseignements ON seances.codeEnseignement = enseignements.codeEnseignement\n" +
			"\n" +
			"WHERE seances_groupes.codeRessource = :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Cours> findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);



	void close();

}