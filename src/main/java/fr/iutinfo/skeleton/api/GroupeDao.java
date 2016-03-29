package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface GroupeDao {
	
	
	@SqlQuery("select * from ressources_groupes where codeGroupe= :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);
	
	@SqlQuery("select * from ressources_groupes order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Groupe> all();


	void close();

	
	@SqlUpdate("create table ressources_groupes (codeGroupe integer primary key autoincrement, nom varchar(100), alias varchar(100), identifiant integer)")
	void createTable();

	@SqlUpdate("drop table if exists ressources_groupes")
	void dropTable();
	
	@SqlQuery("select * from ressources_groupes where codeGroupe = :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCode(@Bind("codeGroupe") int codeGroupe);

	
	@SqlUpdate("insert into ressources_groupes (nom,alias,identifiant) values (:nom,:alias,:identifiant)")
	@GetGeneratedKeys
	int insert(@BindBean() Groupe groupe);

	@SqlQuery("select * from ressources_groupes where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByName(@Bind("nom")String nom);

	@SqlUpdate("delete from ressources_groupes where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
	void deleteGroupeWithName(@Bind("nom") String nom);

}