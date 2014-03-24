package net.therap.dao;

import net.therap.model.User;
import net.therap.model.VCard;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardDao {
    public void createVCard(VCard vCard);

    public List<VCard> retrieveVCardList();

    public List<VCard> retrieveVCardListByFirstName(String firstName);

    public List<VCard> retrieveVCardListByUser(String firstName, User user);

    public List<VCard> retrieveVCardByUser(User user);

    public void deleteVCard(int id);

    public VCard getVCardByName(String firstName, String lastName);

    public void deleteVCard(VCard vCard);

    public VCard getVCardById(int id);

    public void updateVCard(int id, VCard vCard);
}
