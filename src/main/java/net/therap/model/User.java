package net.therap.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<VCard> vCardList;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;

    public User(String name, String password) {
        name = userName;
        this.password = password;
    }

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<VCard> getvCardList() {
        return vCardList;
    }

    public void setvCardList(List<VCard> vCardList) {
        this.vCardList = vCardList;
    }
}
