package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface SeanceSalleDao {
	

	@SqlQuery("select * from seances_salles where codeSeance= :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	SeanceSalle findByCodeSeanceSalle(@Bind("codeSeance") int codeSeance);
	
	@SqlQuery("select * from seances_salles")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<SeanceSalle> all();


	void close();

}
