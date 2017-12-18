package org.slashdev.rest.endpoints;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("test")
public class TestPoint {

    @GET
    @Produces("text/html")
    public String get() {
        return "<h1>test</h1>";
    }
}
