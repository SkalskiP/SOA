package services.user;

import dao.CollectionDAO;
import dao.UserDAO;
import dto.CollectionDTO;
import dto.UserDTO;
import io.swagger.annotations.Api;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Path("/users")
@Api(value="/users")
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

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUser(@PathParam("id") Integer id, UserDTO payload) {
        try {
            UserDTO itemToUpdate = UserDAO.getInstance().getItem(id);

            if (payload.getFirstName() != null)
                itemToUpdate.setFirstName(payload.getFirstName());
            if (payload.getLastName() != null)
                itemToUpdate.setLastName(payload.getLastName());
            if (payload.getAge() != null)
                itemToUpdate.setAge(payload.getAge());
            if (payload.getAvatarUri() != null)
                itemToUpdate.setAvatarUri(payload.getAvatarUri());

            UserDTO updatedItem = UserDAO.getInstance().updateItem(itemToUpdate);
            return Response.ok(updatedItem).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}/avatar")
    @Produces("image/png")
    public Response getFullImage(@PathParam("id") Integer id) {
        try {
            UserDTO user = UserDAO.getInstance().getItem(id);
            BufferedImage image = ImageIO.read(UserService.class.getClassLoader().getResourceAsStream(user.getAvatarUri()));

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            byte[] imageData = outputStream.toByteArray();
            return Response.ok(imageData).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}/collection")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserCollection(@PathParam("id") Integer id) {
        try {
            List<CollectionDTO> collection = CollectionDAO.getInstance().getAllCollectionsByUser(id);
            return Response.ok(collection).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
