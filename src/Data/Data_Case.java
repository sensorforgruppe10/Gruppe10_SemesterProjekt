package Data;

import Aquaintance.ICase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Case class
 * Used for Case information.
 * implements ICase
 * @author Gruppe10
 */
public class Data_Case implements ICase {

    //Attributes for the Case class.
    private int ID;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String birthday;
    private int CPR;
    private String address;
    private String journal;
    private String status;
    private String date;
    private String userName;

     /**
     * Constructor for Case
     * @param ID Sets the ID of the Case.
     * Loads the information from the database into the case based on the ID.
     */
    public Data_Case(int ID) {
        String[] result0 = new String[4];
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        try (Connection db = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/jkclsvjn", "jkclsvjn", "5vckjZ8LGdP6g2S6eHLeP5w34mASozc1");
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("Select * from casefile where caseID = '" + ID + "'");) {
            while (rs.next()) {
                int i = 1;
                while (i < rs.getMetaData().getColumnCount()) {
                    //System.out.print(rs.getString(i) + " ");
                    result0[i - 1] = (rs.getString(i));
                    i++;
                }
                //System.out.println(rs.getString(i) + " ");
                result0[i - 1] = (rs.getString(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        this.ID = ID;
        this.date = result0[1];
        this.userName = result0[2];

        String[] result01 = new String[10];
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        try (Connection db = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/jkclsvjn", "jkclsvjn", "5vckjZ8LGdP6g2S6eHLeP5w34mASozc1");
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("Select firstname, lastname, telephonenumber, email, birthday, cpr, address from users where username = '" + userName + "'");) {
            while (rs.next()) {
                int i = 1;
                while (i < rs.getMetaData().getColumnCount()) {
                    //System.out.print(rs.getString(i) + " ");
                    result01[i - 1] = (rs.getString(i));
                    i++;
                }
                //System.out.println(rs.getString(i) + " ");
                result01[i - 1] = (rs.getString(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        this.firstName = result01[0];
        this.lastName = result01[1];
        this.phoneNumber = Integer.parseInt(result01[2]);
        this.email = result01[3];
        this.birthday = result01[4];
        this.CPR = Integer.parseInt(result01[5]);
        this.address = result01[6];
        this.journal = result0[3];
        this.status = "Under behandling";
    }

    @Override
    public String getJournal() {
        return journal;
    }

    @Override
    public String toString() {
        return "JournalFormat{" + "ID=" + ID + ", firtName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", birthday=" + birthday + ", CPR=" + CPR + ", addresse=" + address + ", journal=" + journal + ", status=" + status + '}';
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public int getCPR() {
        return CPR;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public Data_Case getCase() {
        return this;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getUserName() {
        return userName;
    }

}
