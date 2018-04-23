package MainUI.Admin;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashController {
    //Log out method
    @FXML
    private void LogOut(ActionEvent event) throws IOException {
        Parent logout_parent = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene logout_scene = new Scene(logout_parent);
        Stage logout_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logout_stage.setScene(logout_scene);
        logout_stage.show();
    }
    @FXML
    private void About(ActionEvent event) throws IOException {
        Parent About_parent = FXMLLoader.load(getClass().getResource("/MainUI/Admin/About.fxml"));
        Scene About_scene = new Scene(About_parent);
        Stage About_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        About_stage.setScene(About_scene);
        About_stage.show();
    }
    @FXML
    private void History(ActionEvent event) throws IOException {
        Parent history_parent = FXMLLoader.load(getClass().getResource("/MainUI/Admin/RegisterShow/History.fxml"));
        Scene history_scene = new Scene(history_parent);
        Stage history_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        history_stage.setScene(history_scene);
        history_stage.show();
    }
    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/Admin/AdminDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }






   //move to the scene where you can add films
    @FXML
    private void goToMovies(ActionEvent event) throws IOException {
        Parent movie_parent = FXMLLoader.load(getClass().getResource("/MainUI/Admin/Movie.fxml"));
        Scene movie_scene = new Scene(movie_parent);
        Stage movie_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        movie_stage.setScene(movie_scene);
        movie_stage.show();
    }
    //back to the main scene
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Parent register_parent = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene register_scene = new Scene(register_parent);
        Stage register_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        register_stage.setScene(register_scene);
        register_stage.show();

    }


}





