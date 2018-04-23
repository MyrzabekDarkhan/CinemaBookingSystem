package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //connect root with login.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //created new scene
        Scene scene = new Scene(root);
        //set it resizable
        stage.setTitle("Cinema Booking System");
        stage.getIcons().add(new Image("file:C:\\Users\\Darkhan\\IdeaProjects\\CinemaBookingSystem\\src\\resources\\images\\netflixlogo.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }
}

