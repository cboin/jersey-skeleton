package fr.iutinfo.skeleton.api;

import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface SeanceDao {

	@SqlQuery("select * from vueseances where codeSeance= :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Seance findByCodeSeance(@Bind("codeSeance") int codeSeance);

	@SqlQuery("select * from vueseances ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Seance> all();


	@SqlUpdate("DELETE FROM seances WHERE codeSeance = :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	void deleteSeanceWithId(@Bind("codeSeance") int codeSeance);

	@SqlUpdate("DELETE FROM seances_groupes WHERE codeSeance = :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	void deleteSeanceGroupeWithId(@Bind("codeSeance") int codeSeance);

	@SqlUpdate("INSERT into seances (codeSeance, dateSeance, dureeSeance, heureSeance, codeEnseignement, codeProprietaire) values (:codeSeance, :dateSeance, :dureeSeance, :heureSeance, :codeEnseignement, :codeProprietaire)")
	void insert(@BindBean SeanceDto seanceDto);

	@SqlUpdate("INSERT into seances_groupes (codeSeance, codeRessource, deleted, codeProprietaire) values (:codeSeance, :codeGroupe, 0, :codeProprietaire)")
	void insertSeancesGroupes(@BindBean SeanceDto seanceDto);



	void close();


	@SqlUpdate("UPDATE seances SET dateSeance=:date,  heureSeance=:heure, dureeSeance=:duree  WHERE codeSeance = :codeSeance")
	void updateHoraires(@Bind("codeSeance") int codeSeance, @BindBean() EventDto eventDto);

	@SqlQuery("SELECT MAX(codeSeance)+1 AS newId FROM seances")
	int lookForNewId();


	@SqlUpdate("drop table if exists seances")
	void dropTable();

	@SqlUpdate("create table seances (codeSeance integer primary key, dateSeance date, heureSeance integer, Enseignement varchar(255), Groupe varchar(100), Prof varchar(100))")
	void createTable();


	@SqlUpdate("UPDATE seances SET codeEnseignement=:codeEnseignement WHERE codeSeance = :codeSeance")
	void updateCodeEnseignement(@Bind("codeSeance") int codeSeance, @BindBean() SeanceDto event);

	@SqlUpdate("UPDATE seances_groupes SET codeRessource=:codeGroupe WHERE codeSeance = :codeSeance")
	void updateCodeGroupe(@Bind("codeSeance") int codeSeance, @BindBean() SeanceDto event);
}