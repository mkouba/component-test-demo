package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped // Just in order to make the JAX-RS resource testable in a QuarkusComponentTest
@Path("/hello")
public class GreetingResource {
    
    @Inject
    MyService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.ping();
    }
}
