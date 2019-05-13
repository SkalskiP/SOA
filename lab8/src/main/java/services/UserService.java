package services;

import dao.UserDAO;
import dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
        try {
//            payload.setId(0);
            UserDAO.getInstance().addItem(payload);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
