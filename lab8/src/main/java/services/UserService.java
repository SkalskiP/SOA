package services;

import dao.UserDAO;
import dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/users")
public class UserService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
        List<UserDTO> users = UserDAO.getInstance().getItems();
        return Response.ok().entity(users).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertUser(UserDTO payload) {
        payload.setId(null);
        Optional<Integer> id = UserDAO.getInstance().addItem(payload);

        if (id.isPresent()) {
            return Response.ok(id.get()).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        try {
            UserDAO.getInstance().deleteItem(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
