package services.person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/person")
public class PersonService {

    @GET
    public Response getUsers() {
        return Response.status(Response.Status.TEMPORARY_REDIRECT).location(URI.create("users")).build();
    }
}
