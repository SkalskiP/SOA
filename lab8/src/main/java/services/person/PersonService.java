package services.person;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/person")
@Api(value="/person")
public class PersonService {

    @GET
    public Response getUsers() {
        return Response.status(Response.Status.TEMPORARY_REDIRECT).location(URI.create("users")).build();
    }
}
