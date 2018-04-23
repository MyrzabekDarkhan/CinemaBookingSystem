package MainUI.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MemberDashBoard {
    //logout method
    @FXML
    private void LogOut(ActionEvent event) throws IOException {
        Parent logout_parent = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene logout_scene = new Scene(logout_parent);
        Stage logout_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logout_stage.setScene(logout_scene);
        logout_stage.show();
    }
    //shows available movies
    @FXML
    private void seeAvailableMovies(ActionEvent event) throws IOException{
        Parent seemovie_parent = FXMLLoader.load(getClass().getResource("/MainUI/User/movieforBooking.fxml"));
        Scene seemovie_scene = new Scene(seemovie_parent);
        Stage seemovie_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        seemovie_stage.setScene(seemovie_scene);
        seemovie_stage.show();
    }
    //go to news
    @FXML
    private void goToNews(ActionEvent event) throws IOException{
        Parent news_parent = FXMLLoader.load(getClass().getResource("/MainUI/User/News.fxml"));
        Scene news_scene = new Scene(news_parent);
        Stage news_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        news_stage.setScene(news_scene);
        news_stage.show();
    }

    //shows information about halls
    @FXML
    private void About(ActionEvent event) throws IOException{
        Parent about_parent = FXMLLoader.load(getClass().getResource("/MainUI/User/AboutMember.fxml"));
        Scene about_scene = new Scene(about_parent);
        Stage about_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_stage.setScene(about_scene);
        about_stage.show();
    }

    //back to the memberdashboard
    @FXML
    private void BacktoDash(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/MemberDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }
}
