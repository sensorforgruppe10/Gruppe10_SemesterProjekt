package Aquaintance;

/**
 *
 * @author ProjektGruppe 10.
 */
public interface IBorger extends IUser
{
    int getCPR();

    String getFirstName();

    String getLastName();

    String getAddress();

    int getPhoneNumber();

    String getEmail();

    String getPassword();

    int getBirthday();

    String getUsername();

}
