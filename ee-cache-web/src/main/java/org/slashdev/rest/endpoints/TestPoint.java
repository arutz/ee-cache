package org.slashdev.rest.endpoints;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path(TestPoint.ROOT)
public class TestPoint {
	
	protected static final String ROOT = "/test";

    @GET
    @Produces("text/html")
    public String get() {
        return "<h1>test</h1>";
    }
}
