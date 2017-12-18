package org.slashdev.rest;

import javax.ws.rs.core.Application;
import java.util.LinkedHashSet;
import java.util.Set;

public class RestController extends Application{

    protected Set<Class<?>> getEnpointClasses() {
        Set<Class<?>> classes = new LinkedHashSet<>();
        return classes;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
