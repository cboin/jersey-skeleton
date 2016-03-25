package fr.iutinfo.skeleton.api;

import javax.inject.Singleton;

import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import fr.iutinfo.skeleton.utils.GetDBPropertyValues;

@Singleton
public class BDDFactory {
    private static DBI dbi = null;
    
    public static DBI getDbi() {
        GetDBPropertyValues db = new GetDBPropertyValues("db.properties");
        if (dbi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                dbi = new DBI("jdbc:mysql://" + db.getHost() + "/" + db.getDb(), db.getUser(), db.getPassword());
            } catch (ClassNotFoundException e) {


                e.printStackTrace();
            }
        }

        return dbi;
    }

	public static DBI getDbiForSqlite() {
		if (dbi == null) {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:" + System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")
					+ "data.db");
			dbi = new DBI(ds);
		}
		
		return dbi;
	}
}
