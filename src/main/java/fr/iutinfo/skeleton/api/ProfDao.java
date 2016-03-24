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
	
	/*@SqlUpdate("create table ressources_profs(codeProf varchar(100), couleurFond varchar(100),nom varchar(100),prenom varchar(100), alias varchar(100))")
	void createProfTable();

	@SqlUpdate("insert into ressources_profs (codeProf,couleurFond,nom,prenom,alias) values (:codeProf,:couleurFond,:nom, :prenom, :alias)")
	@GetGeneratedKeys
	int insert(@BindBean() Prof prof);
	*/
	@SqlQuery("select * from ressources_profs where codeProf= :codeProf")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Prof findByCodeProf(@Bind("codeProf") int codeProf);
	
	@SqlQuery("select * from ressources_profs order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Prof> all();


	void close();

}
