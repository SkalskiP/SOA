package services;

import dao.MovieDAO;
import dto.MovieDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/movies")
public class MovieService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovies() {
        List<MovieDTO> movies = MovieDAO.getInstance().getItems();
        return Response.ok().entity(movies).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertMovie(MovieDTO payload) {
        payload.setId(null);
        Optional<Integer> id = MovieDAO.getInstance().addItem(payload);

        if (id.isPresent()) {
            return Response.ok(id.get()).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Integer id) {
        try {
            MovieDAO.getInstance().deleteItem(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateMovie(@PathParam("id") Integer id, MovieDTO payload) {
        try {
            MovieDTO itemToUpdate = MovieDAO.getInstance().getItem(id);

            if (payload.getTitle() != null)
                itemToUpdate.setTitle(payload.getTitle());
            if (payload.getUri() != null)
                itemToUpdate.setUri(payload.getUri());

            MovieDTO updatedItem = MovieDAO.getInstance().updateItem(itemToUpdate);
            return Response.ok(updatedItem).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
