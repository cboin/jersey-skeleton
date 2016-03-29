package fr.iutinfo.skeleton.api;

import javax.ws.rs.client.WebTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Helper {

	final static Logger logger = LoggerFactory.getLogger(Helper.class);
	public WebTarget target;

	public Helper(WebTarget target) {
		this.target = target;

	}

	public abstract void initDb();
	
	
	
}
