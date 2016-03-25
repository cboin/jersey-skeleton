package fr.iutinfo.skeleton.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class GetDBPropertyValues {
	private String host;
	private String db;
	private String user;
	private String password;
	
	public GetDBPropertyValues(String propFilename) {
		BufferedReader in = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			in = new BufferedReader(
					new InputStreamReader(loader.getResourceAsStream(propFilename)));
			
			Properties prop = new Properties();
			if (in != null) {
				prop.load(in);
			} else {
				throw new FileNotFoundException("property file '" + propFilename + "' not found in the classpath");
			}
			
			this.host = prop.getProperty("host");
			this.db = prop.getProperty("db");
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @return the db
	 */
	public String getDb() {
		return db;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

}
