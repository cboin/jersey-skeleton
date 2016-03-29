package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ProfDao {

	@SqlUpdate("drop table if exists ressources_profs")
	void dropProfTable();
	
	@SqlUpdate("create table ressources_profs(codeProf integer primary key autoincrement, couleurFond integer,nom varchar(100),prenom varchar(100), alias varchar(100))")
	void createProfTable();
	
	@SqlQuery("select * from ressources_profs where codeProf= :codeProf")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Prof findByCodeProf(@Bind("codeProf") int codeProf);
	@SqlUpdate("insert into ressources_profs(nom, prenom) values(:nom, :prenom)")
	int insert(@BindBean() Prof prof);
	
	@SqlQuery("select * from ressources_profs order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Prof> all();



	@SqlQuery("SELECT\n" +
			"enseignements.codeEnseignement,\n" +
			"ressources_profs.nom,\n" +
			"ressources_profs.prenom,\n" +
			"enseignements.alias,\n" +
			"enseignements.nom AS enseignement,\n" +
			"ressources_profs.codeProf\n" +
			"FROM\n" +
			"enseignements\n" +
			"INNER JOIN enseignements_profs ON enseignements.codeEnseignement = enseignements_profs.codeEnseignement\n" +
			"INNER JOIN ressources_profs ON enseignements_profs.codeRessource = ressources_profs.codeProf\n" +
			"WHERE\n" +
			"enseignements.codeEnseignement = :codeEnseignement AND\n" +
			"enseignements_profs.deleted = 0 AND\n" +
			"enseignements_profs.deleted = 0\n")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Prof getProfFromCours(@Bind("codeEnseignement") int codeEnseignement);





	void close();

}
