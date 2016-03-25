package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface SalleDao {
	
	
	@SqlQuery("select * from ressources_salles where codeSalle= :codeSalle")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCodeSalle(@Bind("codeSalle") int codeSalle);
	
	@SqlQuery("select * from ressources_salles order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Salle> all();


	void close();

}