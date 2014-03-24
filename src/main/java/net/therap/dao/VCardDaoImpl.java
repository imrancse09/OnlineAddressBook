package net.therap.dao;

import net.therap.model.User;
import net.therap.model.VCard;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/17/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class VCardDaoImpl implements VCardDao {
    Logger logger = Logger.getLogger(VCardDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createVCard(VCard vCard) {
        entityManager.merge(vCard);
    }

    @Override
    public List<VCard> retrieveVCardList() {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT v FROM VCard v", VCard.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            logger.debug("No VCard Found");
        }
        return null;
    }

    @Override
    public List<VCard> retrieveVCardListByFirstName(String firstName) {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT vc FROM VCard vc WHERE " +
                ":firstName IN vc.firstName", VCard.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Override
    public List<VCard> retrieveVCardListByUser(String firstName, User user) {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT v FROM VCard v WHERE " +
                ":firstName IN v.firstName AND :user IN v.user", VCard.class);
        query.setParameter("firstName", firstName);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public List<VCard> retrieveVCardByUser(User user) {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT vc FROM VCard vc WHERE " +
                ":user IN vc.user", VCard.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public void deleteVCard(int id) {
        VCard vCard = entityManager.find(VCard.class, id);
        entityManager.remove(vCard);
    }


    @Override
    public VCard getVCardByName(String firstName, String lastName) {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT v FROM VCard v WHERE " +
                ":firstName IN v.firstName AND :lastName IN v.lastName", VCard.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No VCard Found");
        }
        return null;
    }

    @Override
    public void deleteVCard(VCard vCard) {
        entityManager.remove(vCard);
    }

    @Override
    public VCard getVCardById(int id) {
        TypedQuery<VCard> query = entityManager.createQuery("SELECT v FROM VCard v WHERE :id IN " +
                "v.vCardPKey", VCard.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public void updateVCard(int id, VCard vCard) {
        VCard vc = entityManager.find(VCard.class, id);
        if (vc != null) {
            vc.setFirstName(vCard.getFirstName());
            vc.setLastName(vCard.getLastName());
            vc.setHonorificPrefix(vCard.getHonorificPrefix());
            vc.setOrganization(vCard.getOrganization());
            vc.setJobTitle(vCard.getJobTitle());
            entityManager.merge(vc);
        }
    }
}
