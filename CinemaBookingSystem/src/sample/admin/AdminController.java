package sample.admin;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable{
    //controllers are instantiated
    @FXML
    Button closeButton;

    LoginModel loginModel = new LoginModel();
    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;

    @FXML
    private Label loginStatus;


    @FXML
    public void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
   //Back button method
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Parent register_parent = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene register_scene = new Scene(register_parent);
        Stage register_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        register_stage.setScene(register_scene);
        register_stage.show();

    }

   //whenever the application runs this method checking conditions of the database
    public void initialize(URL url, ResourceBundle rb) {
        if (this.loginModel.isDataBaseConnected()) {
            this.dbstatus.setText("Connected to Database");
        } else {
            this.dbstatus.setText("Not Connected to Database");
        }

    }
    //Check from database,does it have admin in database or not.
    @FXML
    public void Login(ActionEvent event) {
        //try block
        try {
            //check conditions
            if (loginModel.isLogin(this.username.getText(), this.password.getText())) {
                Parent sign_parent = FXMLLoader.load(getClass().getResource("/MainUI/Admin/AdminDashBoard.fxml"));
                Scene sign_scene = new Scene(sign_parent);
                Stage sign_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                sign_stage.setScene(sign_scene);
                sign_stage.show();

            } else {
                loginStatus.setText("Wrong Password or Username");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}