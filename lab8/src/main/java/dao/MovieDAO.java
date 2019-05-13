package dao;

import dto.MovieDTO;
import services.movie.MovieFilterParams;

import javax.persistence.TypedQuery;
import java.util.List;

public class MovieDAO extends AbstractDAO<MovieDTO> {
    private MovieDAO() {
        super(MovieDTO.class);
    }

    private static MovieDAO instance;

    public static MovieDAO getInstance() {
        if (instance == null) {
            synchronized (MovieDAO.class) {
                if (instance == null) {
                    instance = new MovieDAO();
                }
            }
        }
        return instance;
    }

    public List<MovieDTO> filter(MovieFilterParams params) {
        TypedQuery query = entityManager.createQuery("SELECT at FROM MovieDTO at where at."+ params.filedName +" LIKE :searchKeyword", MovieDTO.class);
        query.setParameter("searchKeyword", "%"+params.text+"%");
        return query.getResultList();
    }
}
