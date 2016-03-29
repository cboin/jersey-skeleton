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
	
	
	@SqlQuery("select * from groupes where codeGroupe= :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);
	
	@SqlQuery("select * from ressources_groupes order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Groupe> all();


	void close();

	
	@SqlUpdate("create table groupes (codeGroupe integer primary key autoincrement, nom varchar(100), alias varchar(100), identifiant integer)")
	void createTable();

	@SqlUpdate("drop table if exists groupes")
	void dropTable();

	
	@SqlUpdate("insert into groupes (nom,alias,identifiant) values (:nom,:alias,:identifiant)")
	@GetGeneratedKeys
	int insert(@BindBean() Groupe groupe);

	@SqlQuery("select * from groupes where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByName(@Bind("nom")String nom);

	@SqlUpdate("delete from groupes where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
	void deleteGroupeWithName(@Bind("nom") String nom);

}