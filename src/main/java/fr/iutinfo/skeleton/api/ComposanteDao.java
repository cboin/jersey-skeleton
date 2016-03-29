package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ComposanteDao {


	@SqlQuery("SELECT\n" +
			"composantes.codeComposante,\n" +
			"composantes.nom\n" +
			"FROM\n" +
			"composantes ORDER BY composantes.codeComposante\n")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Composante> all();



	void close();

}