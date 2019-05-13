package services.collection;

import dao.CollectionDAO;
import dao.MovieDAO;
import dao.UserDAO;
import dto.CollectionDTO;
import dto.MovieDTO;
import dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/collections")
public class CollectionService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCollections() {
        List<CollectionDTO> collections = CollectionDAO.getInstance().getItems();
        return Response.ok().entity(collections).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertMovie(CollectionParams payload) {
        try {
            MovieDTO movie = MovieDAO.getInstance().getItem(payload.getMovieId());
            UserDTO user = UserDAO.getInstance().getItem(payload.getUserId());
            CollectionDTO collection = new CollectionDTO();
            collection.setMovie(movie);
            collection.setUser(user);

            Optional<Integer> id = CollectionDAO.getInstance().addItem(collection);

            if (id.isPresent()) {
                return Response.ok(id.get()).build();
            } else {
                return Response.serverError().build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Integer id) {
        try {
            CollectionDAO.getInstance().deleteItem(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
