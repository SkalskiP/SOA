package dao;

import dto.MovieDTO;

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
}
