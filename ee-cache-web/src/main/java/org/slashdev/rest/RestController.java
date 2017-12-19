package org.slashdev.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.LinkedHashSet;
import java.util.Set;

@ApplicationPath(RestController.REST_ROOT)
public class RestController extends Application{

	protected static final String REST_ROOT = "/rest";
	
    protected Set<Class<?>> getEnpointClasses() {
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        return classes;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
