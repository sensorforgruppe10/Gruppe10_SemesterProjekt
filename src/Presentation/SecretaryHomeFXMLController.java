package Presentation;

import Aquaintance.IBusiness;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller SecretaryHomeFXMLController class
 * Used to handle the Secretary homescreen.
 * implements Initializable
 * @author Gruppe 10.
 */
public class SecretaryHomeFXMLController implements Initializable 
{

    //Attributes of the SecretaryHomeFXMLController class.
    private IBusiness business;
    @FXML
    private Button logOutButton;
    @FXML
    private Label AdminIDLabel;
    @FXML
    private VBox VBox;
    @FXML
    private Label caseIDLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label PhonenumberLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label caseStatusLabel;
    @FXML
    private TextArea caseTextArea;
    @FXML
    private MenuItem menuButton;

    /**
     * Initializes the SecretaryHomeFXMLController class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }

    /**
     * Handles the logout action
     * Shows logInScreen.fxml on use
     * @param event
     * @throws IOException
     */
    @FXML
    private void LogOutAction(ActionEvent event) throws IOException 
    {
        /*Parent root = FXMLLoader.load(getClass().getResource("FXML/LogInScreen.fxml"));
        Scene logIn = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(logIn);
        stage.show(); */
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/LogInScreen.fxml"));
            Pane root = loader.load();
            LogInScreenController controller = loader.getController();
            controller.injectBusiness(business);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene logIn = new Scene(root);

            stage.setScene(logIn);
            stage.show();
            stage.setResizable(false);
        } catch (IOException ex) 
        {
            Logger.getLogger(PresentationFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the changePassword action
     * No implementation.
     * @param event
     */
    @FXML
    private void changePassword(ActionEvent event) 
    {
    }

    /**
     * Inject Method for Business
     * @param business Sets the businessLayer to use.
     */
    void injectBusiness(IBusiness Business) 
    {
        this.business = business;
    }

}
