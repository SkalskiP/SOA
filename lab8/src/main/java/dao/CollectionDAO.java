package dao;

import dto.CollectionDTO;

public class CollectionDAO extends AbstractDAO<CollectionDTO> {
    private CollectionDAO() {
        super(CollectionDTO.class);
    }

    private static CollectionDAO instance;

    public static CollectionDAO getInstance() {
        if (instance == null) {
            synchronized (CollectionDAO.class) {
                if (instance == null) {
                    instance = new CollectionDAO();
                }
            }
        }
        return instance;
    }
}
