
package edu.psu.ist411;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ISt 411 Group 2
 */
@Path("music")
public class MusicResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MusicResource
     */
    public MusicResource() {
    }

    /**
     * Retrieves representation of an instance of edu.psu.ist411.MusicResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        System.out.println("GET method called.");
        return "<html><head><title>TESTING</title></head><body>TESTING</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of MusicResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
