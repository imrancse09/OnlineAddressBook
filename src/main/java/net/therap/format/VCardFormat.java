package net.therap.format;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardFormat {
    public static String BEGIN_END_VALUE = "VCARD";
    public static String BEGIN = "BEGIN:";
    public static String VERSION = "VERSION:";
    public static String NAME = "N:";
    public static String FULL_NAME = "FN:";
    public static String ORGANIZATION = "ORG:";
    public static String TITLE = "TITLE:";
    public static String PHOTO = "PHOTO;VALUE=URL:";
    public static String TELEPHONE_WORK = "TEL;TYPE=WORK,VOICE:";
    public static String TELEPHONE_HOME = "TEL;TYPE=HOME,VOICE:";
    public static String ADDRESS_WORK = "ADR;TYPE=WORK:";
    public static String LABEL_WORK = "LABEL;TYPE=WORK:";
    public static String ADDRESS_HOME = "ADR;TYPE=HOME:";
    public static String LABEL_HOME = "LABEL;TYPE=HOME:";
    public static String EMAIL_PREF = "EMAIL;TYPE=PREF,INTERNET:";
    public static String REVISION = "REV:";
    public static String END = "END:";
}
