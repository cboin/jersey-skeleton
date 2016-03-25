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


	void close();

}
