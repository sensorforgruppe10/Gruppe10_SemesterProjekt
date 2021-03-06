package Presentation;

import Aquaintance.IBusiness;
import Aquaintance.IPresentation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;

/**
 * FXML Controller ResetPasswordController class
 * Used to handle the ResetPassword screen.
 * implements Initializable
 * @author Gruppe 10.
 */
public class ResetPasswordController implements Initializable 
{

    private IBusiness Business;
    private IPresentation UI;

    //Attributes of the ResetPasswordController class.
    @FXML
    private Button RestButton;
    @FXML
    private Button backButton;
    @FXML
    private Label invalidUserName;
    @FXML
    private Label InvaldInputLabel;
    @FXML
    private TextField oldPasswordField;
    @FXML
    private PasswordField newPasswordFieldRepeat;
    @FXML
    private PasswordField newPasswordField;

    /**
     * Initializes the ResetPasswordController class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UI = PresentationFacade.getUI();
    }

    public void injectBusiness(IBusiness business) {
        this.Business = business;
    }

    /**
     * Handles the ResetButtonOn action
     * Closes the scene.
     * @param event
     */
    @FXML
    private void ResetButtonOnAction(ActionEvent event) {
        if (newPasswordField.getText().equals(newPasswordFieldRepeat.getText())) {
            UI.setPassword(oldPasswordField.getText(), newPasswordField.getText());
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Handles the backOn action
     * Closes the scene.
     * @param event
     */
    @FXML
    private void backOnAction(ActionEvent event) 
    {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the pressEnter action
     * No implementation.
     * @param event
     */
    @FXML
    private void pressEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (newPasswordField.getText().equals(newPasswordFieldRepeat.getText())) {
                UI.setPassword(oldPasswordField.getText(), newPasswordField.getText());
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.close();
            }
        }
    }

    /**
     * Handles the userNameOn action
     * No implementation.
     * @param event
     */
    @FXML
    private void userNameOnAction(ActionEvent event) 
    {
    }
}
