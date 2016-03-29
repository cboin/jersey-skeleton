package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface EnseignementDao {
	

	@SqlQuery("SELECT\n" +
			"enseignements.nom,\n" +
			"enseignements.alias,\n" +
			"composantes.nom AS composante,\n" +
			"composantes.codeComposante,\n" +
			"enseignements.codeEnseignement\n" +
			"FROM\n" +
			"composantes\n" +
			"INNER JOIN enseignements ON composantes.codeComposante = enseignements.codeComposante\n" +
			"WHERE\n" +
			"enseignements.deleted = 0")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Enseignement> all();


	void close();

}