package dao;

import dto.CollectionDTO;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public List<CollectionDTO> getAllCollectionsByUser(Integer userId) {
        TypedQuery<CollectionDTO> typedQuery = prepareCollectionsForUserQuery(userId);
        return typedQuery.getResultList();
    }

    private TypedQuery<CollectionDTO> prepareCollectionsForUserQuery(Integer userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CollectionDTO> query = criteriaBuilder.createQuery(CollectionDTO.class);
        Root<CollectionDTO> b = query.from(CollectionDTO.class);
        query.select(b).where(criteriaBuilder.equal(b.get("user"), userId));
        return entityManager.createQuery(query);
    }
}
