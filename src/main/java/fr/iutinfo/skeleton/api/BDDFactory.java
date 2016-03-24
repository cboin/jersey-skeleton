package fr.iutinfo.skeleton.api;

import javax.inject.Singleton;

import org.skife.jdbi.v2.DBI;

@Singleton
public class BDDFactory {
    private static DBI dbi = null;
    
    public static DBI getDbi() {
        if(dbi == null) {
           try {
			Class.forName("com.mysql.jdbc.Driver");
			dbi = new DBI("jdbc:mysql://localhost/agile", "root", "");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
           
        }
        return dbi;
    }
}