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
			"ressources_groupes.nom AS nomGroupe,\n" +
			"enseignements.couleurFond,\n" +
			"enseignements.couleurPolice\n" +
			"FROM\n" +
			"\t\t\tseances_groupes\n" +
			"\t\t\tINNER JOIN seances ON seances.codeSeance = seances_groupes.codeSeance\n" +
			"\t\t\tINNER JOIN enseignements ON seances.codeEnseignement = enseignements.codeEnseignement\n" +
			"\t\t\tINNER JOIN enseignements_profs AS ep ON enseignements.codeEnseignement = ep.codeEnseignement AND ep.deleted = 0\n" +
			"\t\t\tINNER JOIN ressources_profs ON ep.codeRessource = ressources_profs.codeProf\n" +
			"\t\t\tINNER JOIN ressources_groupes ON seances_groupes.codeRessource = ressources_groupes.codeGroupe\n" +
			"WHERE \n" +
			"\t\t\tseances_groupes.codeRessource = :codeGroupe AND\n" +
			"\t\t\tseances.deleted = 0\n")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Cours> findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);

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
			"ressources_groupes.nom AS nomGroupe,\n" +
			"enseignements.couleurFond,\n" +
			"enseignements.couleurPolice\n" +
			"FROM\n" +
			"\t\t\tseances_groupes\n" +
			"\t\t\tINNER JOIN seances ON seances.codeSeance = seances_groupes.codeSeance\n" +
			"\t\t\tINNER JOIN enseignements ON seances.codeEnseignement = enseignements.codeEnseignement\n" +
			"\t\t\tINNER JOIN enseignements_profs AS ep ON enseignements.codeEnseignement = ep.codeEnseignement AND ep.deleted = 0\n" +
			"\t\t\tINNER JOIN ressources_profs ON ep.codeRessource = ressources_profs.codeProf\n" +
			"\t\t\tINNER JOIN ressources_groupes ON seances_groupes.codeRessource = ressources_groupes.codeGroupe\n" +
			"WHERE \n" +
			"\t\t\tseances_groupes.codeSeance = :codeSeance AND\n" +
			"\t\t\tseances.deleted = 0\n" +
			"LIMIT 1")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Cours findCoursByCodeSeance(@Bind("codeSeance") int codeSeance);



	void close();

}