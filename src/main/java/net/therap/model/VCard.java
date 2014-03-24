package net.therap.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VCard")
public class VCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vCardPKey")
    private int vCardPKey;

    @ManyToOne
//            (cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @Column(name = "version", columnDefinition="varchar(10) default '3.0'")
    private String version = "3.0";

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "honorificPrefix")
    private String honorificPrefix;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "organization")
    private String organization;

    @Column(name = "photoUrl")
    private String photoUrl;

    @Column(name = "phoneWork")
    private String phoneWork;

    @Column(name = "phoneHome")
    private String phoneHome;

    @Column(name = "postOfficeboxWork")
    private String postOfficeBoxWork;

    @Column(name = "houseNumberWork")
    private String houseNumberWork;

    @Column(name = "streetWork")
    private String streetWork;

    @Column(name = "cityWork")
    private String cityWork;

    @Column(name = "stateWork")
    private String stateWork;

    @Column(name = "postalCodeWork")
    private String postalCodeWork;

    @Column(name = "countryWork")
    private String countryWork;

    @Column(name = "postOfficeboxHome")
    private String postOfficeBoxHome;

    @Column(name = "houseNumberHome")
    private String houseNumberHome;

    @Column(name = "streetHome")
    private String streetHome;

    @Column(name = "cityHome")
    private String cityHome;

    @Column(name = "stateHome")
    private String stateHome;

    @Column(name = "postalCodeHome")
    private String postalCodeHome;

    @Column(name = "countryHome")
    private String countryHome;

    @Column(name = "prefEmail")
    private String prefEmail;

    @Column(name = "revision")
    private String revision;

    public VCard(User user) {
        this.setUser(user);
    }

    public VCard() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHonorificPrefix() {
        return honorificPrefix;
    }

    public void setHonorificPrefix(String honorificPrefix) {
        this.honorificPrefix = honorificPrefix;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPostOfficeBoxWork() {
        return postOfficeBoxWork;
    }

    public void setPostOfficeBoxWork(String postOfficeBoxWork) {
        this.postOfficeBoxWork = postOfficeBoxWork;
    }

    public String getHouseNumberWork() {
        return houseNumberWork;
    }

    public void setHouseNumberWork(String houseNumberWork) {
        this.houseNumberWork = houseNumberWork;
    }

    public String getStreetWork() {
        return streetWork;
    }

    public void setStreetWork(String streetWork) {
        this.streetWork = streetWork;
    }

    public String getCityWork() {
        return cityWork;
    }

    public void setCityWork(String cityWork) {
        this.cityWork = cityWork;
    }

    public String getStateWork() {
        return stateWork;
    }

    public void setStateWork(String stateWork) {
        this.stateWork = stateWork;
    }

    public String getPostalCodeWork() {
        return postalCodeWork;
    }

    public void setPostalCodeWork(String postalCodeWork) {
        this.postalCodeWork = postalCodeWork;
    }

    public String getCountryWork() {
        return countryWork;
    }

    public void setCountryWork(String countryWork) {
        this.countryWork = countryWork;
    }

    public String getPostOfficeBoxHome() {
        return postOfficeBoxHome;
    }

    public void setPostOfficeBoxHome(String postOfficeBoxHome) {
        this.postOfficeBoxHome = postOfficeBoxHome;
    }

    public String getHouseNumberHome() {
        return houseNumberHome;
    }

    public void setHouseNumberHome(String houseNumberHome) {
        this.houseNumberHome = houseNumberHome;
    }

    public String getStreetHome() {
        return streetHome;
    }

    public void setStreetHome(String streetHome) {
        this.streetHome = streetHome;
    }

    public String getCityHome() {
        return cityHome;
    }

    public void setCityHome(String cityHome) {
        this.cityHome = cityHome;
    }

    public String getStateHome() {
        return stateHome;
    }

    public void setStateHome(String stateHome) {
        this.stateHome = stateHome;
    }

    public String getPostalCodeHome() {
        return postalCodeHome;
    }

    public void setPostalCodeHome(String postalCodeHome) {
        this.postalCodeHome = postalCodeHome;
    }

    public String getCountryHome() {
        return countryHome;
    }

    public void setCountryHome(String countryHome) {
        this.countryHome = countryHome;
    }

    public String getPrefEmail() {
        return prefEmail;
    }

    public void setPrefEmail(String prefEmail) {
        this.prefEmail = prefEmail;
    }

    public String getRevision() {
        String s = showCurrentDate()+showCurrentTime();
        return s;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String showCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String s = dateFormat.format(date);
        return s+"T";
    }

    public String showCurrentTime() {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String s =  sdf.format(cal.getTime());
        return s+"Z";
    }

    public String getN() {
        String str1;
        String str2;

        String str4;

        if (firstName != null) {
            str1 = firstName+";";
        } else str1 = ";";
        if (lastName != null) {
            str2 = lastName+";";
        } else str2 = ";";
        if (honorificPrefix != null) {
            str4 = honorificPrefix;
        } else {
            str4 = "";
        }

        return str2+str1+str4;
    }

    public String getFN() {
        String str1;
        String str2;

        str1 = firstName+" ";
        if (lastName != null) {
            str2 = lastName;
        } else str2 = "" ;
        return str1+str2;
    }

    public String getAddressWork() {
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (postOfficeBoxWork != null) {
            str1 = postOfficeBoxWork+";";
        } else str1 = ";";
        if (houseNumberWork != null) {
            str2 = houseNumberWork+";";
        } else str2 = ";";
        if (streetWork != null) {
            str3 = streetWork+";";
        } else str3 = ";";
        if (cityWork != null) {
            str4 = cityWork+";";
        } else str4 = ";";
        if (stateWork != null) {
            str5 = stateWork+";";
        } else str5 = ";";
        if (postalCodeWork != null) {
            str6 = postalCodeWork+";";
        } else str6 = ";";
        if (countryWork != null) {
            str7 = countryWork;
        } else str7 = "";

        return str1+str2+str3+str4+str5+str6+str7;
    }

    public String getAddressHome() {
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (postOfficeBoxHome != null) {
            str1 = postOfficeBoxHome+";";
        } else str1 = ";";
        if (houseNumberHome != null) {
            str2 = houseNumberHome+";";
        } else str2 = ";";
        if (streetHome != null) {
            str3 = streetHome+";";
        } else str3 = ";";
        if (cityHome != null) {
            str4 = cityHome+";";
        } else str4 = ";";
        if (stateHome != null) {
            str5 = stateHome+";";
        } else str5 = ";";
        if (postalCodeHome != null) {
            str6 = postalCodeHome+";";
        } else str6 = ";";
        if (countryHome != null) {
            str7 = countryHome;
        } else str7 = "";

        return str1+str2+str3+str4+str5+str6+str7;
    }

    public String getLabelWork() {
        String str1, str2, str3, str4, str5, str6, str7;

        if (postOfficeBoxWork != null) {
            str1 = postOfficeBoxWork+"\\n";
        } else str1 = "";
        if (houseNumberWork != null) {
            str2 = houseNumberWork+"\\n";
        } else str2 = "";
        if (streetWork != null) {
            str3 = streetWork + "\\n";
        } else str3 = "";
        if (cityWork != null) {
            str4 = cityWork+", ";
        } else str4 = "";
        if (stateWork != null) {
            str5 = stateWork+" ";
        } else str5 = "";
        if (postalCodeWork != null) {
            str6 = postalCodeWork+"\\n";
        } else str6 = "";
        if (countryWork != null) {
            str7 = countryWork;
        } else str7 = "";

        return str1+str2+str3+str4+str5+str6+str7;
    }

    public String getLabelHome() {
        String str1, str2, str3, str4, str5, str6, str7;

        if (postOfficeBoxHome != null) {
            str1 = postOfficeBoxHome+"\\n";
        } else str1 = "";
        if (houseNumberHome != null) {
            str2 = houseNumberHome+"\\n";
        } else str2 = "";
        if (streetHome != null) {
            str3 = streetHome + "\\n";
        } else str3 = "";
        if (cityHome != null) {
            str4 = cityHome+", ";
        } else str4 = "";
        if (stateHome != null) {
            str5 = stateHome+" ";
        } else str5 = "";
        if (postalCodeHome != null) {
            str6 = postalCodeHome+"\\n";
        } else str6 = "";
        if (countryHome != null) {
            str7 = countryHome;
        } else str7 = "";

        return str1+str2+str3+str4+str5+str6+str7;
    }

    @Override
    public String toString() {
        return "VCard{" +

                ", version=" + getVersion() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", honorificPrefix='" + honorificPrefix + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", organization='" + organization + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", phoneWork='" + phoneWork + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", postOfficeBoxWork='" + postOfficeBoxWork + '\'' +
                ", houseNumberWork='" + houseNumberWork + '\'' +
                ", streetWork='" + streetWork + '\'' +
                ", cityWork='" + cityWork + '\'' +
                ", stateWork='" + stateWork + '\'' +
                ", postalCodeWork='" + postalCodeWork + '\'' +
                ", countryWork='" + countryWork + '\'' +
                ", postOfficeBoxHome='" + postOfficeBoxHome + '\'' +
                ", houseNumberHome='" + houseNumberHome + '\'' +
                ", streetHome='" + streetHome + '\'' +
                ", cityHome='" + cityHome + '\'' +
                ", stateHome='" + stateHome + '\'' +
                ", postalCodeHome='" + postalCodeHome + '\'' +
                ", countryHome='" + countryHome + '\'' +
                ", prefEmail='" + prefEmail + '\'' +
                ", revision='" + revision + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getvCardPKey() {
        return vCardPKey;
    }

    public void setvCardPKey(int vCardPKey) {
        this.vCardPKey = vCardPKey;
    }
}
