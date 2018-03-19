package edu.psu.ist411;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author IST411 Group2
 */
public class HTTPClient2 {
    
    
    public static void main(String[] args) {
        Client client = javax.ws.rs.client.ClientBuilder.newClient();
        String BASE_URI = "http://localhost:8080/IST411L07/webresources";
        WebTarget webTarget = client.target(BASE_URI);
        WebTarget resource = webTarget.path("/music");
        Builder builder = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        
        // GET
        Invocation getInvocation = builder.buildGet();
        //GenericType responseType = new GenericType<List<Song>>();
        //List<Song> songs = getInvocation.invoke(responseType);
        
        // PUT
        //Invocation putInvocation = builder.buildPut(Song s);

        // POST
        //Invocation postInvocation = builder.buildPost();

        // DELETE
        //Invocation deleteInvocation = builder.buildDelete();
    }
}
