/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Aquaintance.IBusiness;
import Aquaintance.ICase;
import Aquaintance.IPresentation;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Obel
 */
public class CaseWorkerHomeFXMLController implements Initializable {

    private IBusiness Business;
    private IPresentation UI;
    private ICase sag;

    @FXML
    private Button logOutButton;
    @FXML
    private Label AdminIDLabel;
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
    private Button viewCaseButton;
    @FXML
    private MenuItem menuButton;
    @FXML
    private VBox VBox;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    public void injectBusiness(IBusiness business) {
        this.Business = business;
    }

    private void addCase() throws IOException {
        Pane newVBox = FXMLLoader.load(getClass().getResource("casePreview.fxml"));
        VBox.getChildren().add(newVBox);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UI = PresentationFacade.getUI();
        caseIDLabel.setText(String.valueOf(UI.getID()));
        firstNameLabel.setText(String.valueOf(UI.getFirtName()));
        lastNameLabel.setText(String.valueOf(UI.getLastName()));
        PhonenumberLabel.setText((String.valueOf(UI.getPhoneNumber())));
        emailLabel.setText(String.valueOf((UI.getEmail())));
        caseTextArea.setText((String.valueOf(UI.getJournal())));
        caseStatusLabel.setText(UI.getStatus());

        try {
            addCase();
        } catch (IOException ex) {
            Logger.getLogger(CaseWorkerHomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void LogOutAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        Scene logIn = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(logIn);
        stage.show();
    }

    @FXML
    private void viewCaseAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewCase.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(viewCaseButton.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(menuButton.getParentPopup().getOwnerWindow());
        stage.showAndWait();
    }
}
