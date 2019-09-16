package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 * @Guan
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    @PersistenceContext(unitName = "W2ExeSolution-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags().size();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        Property property = this.searchPropertyById(propertyId);

        if (property != null) {
            entityManager.remove(property);
        }
    }

    @Override
    public void editProperty(Property property) throws Exception {
        entityManager.merge(property);
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
       return null;
    }
}
