package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.admin.LoginModel;

import java.io.IOException;

public class Controller {

    //Creating an object loginModel to bound it with sql and check weather it connected or not.
    LoginModel loginModel = new LoginModel();


    //label created to show us wrongly passed our username or password or not.
    @FXML
    private Label loginStatus;


    //username textfield created.
    @FXML
    private TextField username;


    //password textfiedl created.
    @FXML
    private TextField password;

    //closeButton created.
    @FXML
    Button closeButton;


    //method which will close our stage.
    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


    // When this method is called, it will change the Scene to
    // a TableView example
    @FXML
    private void RegisterButtonAction(ActionEvent event) throws IOException {

        Parent register_parent = FXMLLoader.load(getClass().getResource("/sample/register/register.fxml"));
        Scene register_scene = new Scene(register_parent);
        Stage register_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        register_stage.setScene(register_scene);
        register_stage.show();
    }

    //it will move to the admin register page,to sign in further.
    @FXML
    private void SignInButtonAction(ActionEvent event) throws IOException {

        Parent sign_parent = FXMLLoader.load(getClass().getResource("/sample/admin/admin.fxml"));
        Scene sign_scene = new Scene(sign_parent);
        Stage sign_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sign_stage.setScene(sign_scene);
        sign_stage.show();
    }

    //Check from database,does it have member in database or not.
    @FXML
    public void LoginForMember(ActionEvent event) throws IOException {
        //we wrap it in try catch

        //it moves to the memberdashboard.
        Parent sign_parent = FXMLLoader.load(getClass().getResource("/MainUI/User/MemberDashBoard.fxml"));
        Scene sign_scene = new Scene(sign_parent);
        Stage sign_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sign_stage.setScene(sign_scene);
        sign_stage.show();


    }
}


