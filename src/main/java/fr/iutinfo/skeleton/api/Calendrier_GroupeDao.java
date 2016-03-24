package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface Calendrier_GroupeDao {
	
	
	@SqlQuery("select * from calendriers_groupes where code= :code")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCodeCalendrierGroupe(@Bind("code") int code);
	
	@SqlQuery("select * from calendriers_groupes order by codeRessource")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Calendrier_Groupe> all();


	void close();

}