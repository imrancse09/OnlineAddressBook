package net.therap.service;

import net.therap.dao.VCardDao;
import net.therap.model.User;
import net.therap.model.VCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imran
 * Date: 3/18/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class VCardServiceImpl implements VCardService {
    @Autowired
    private VCardDao vCardDao;

    @Override
    @Transactional
    public void createVCard(VCard vCard) {
        vCardDao.createVCard(vCard);
    }

    @Override
    @Transactional
    public List<VCard> retrieveVCardList() {
        return vCardDao.retrieveVCardList();
    }

    @Override
    @Transactional
    public List<VCard> retrieveVCardListByFirstName(String firstName) {
        return vCardDao.retrieveVCardListByFirstName(firstName);
    }

    @Override
    @Transactional
    public List<VCard> retrieveVCardByUser(User user) {
        return vCardDao.retrieveVCardByUser(user);
    }

    @Override
    @Transactional
    public void deleteVCard(int id) {
        vCardDao.deleteVCard(id);
    }

    @Override
    @Transactional
    public List<VCard> retrieveVCardListByUser(String firstName, User user) {
        return vCardDao.retrieveVCardListByUser(firstName, user);
    }

    @Override
    @Transactional
    public VCard getVCardByName(String firstName, String lastName) {
        return vCardDao.getVCardByName(firstName, lastName);
    }

    @Override
    @Transactional
    public void deleteVCard(VCard vCard) {
        vCardDao.deleteVCard(vCard);
    }

    @Override
    @Transactional
    public VCard getVCardById(int id) {
        return vCardDao.getVCardById(id);
    }

    @Override
    @Transactional
    public void updateVCard(int id, VCard vCard) {
        vCardDao.updateVCard(id, vCard);
    }
}
