package fr.iutinfo.skeleton.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/v1/")
public class Api extends ResourceConfig {

  final static int CODE_PROPRIO = 2001;




  public Api() {
    packages("fr.iutinfo.skeleton.api");
    // register(LoggingFilter.class);
    register(RolesAllowedDynamicFeature.class);
  }
}
