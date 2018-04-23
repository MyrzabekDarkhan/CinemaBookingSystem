package MainUI.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewsController {
    //back button
    @FXML
    private void BacktoDash(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/MemberDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }
    @FXML
    private void goToNews(ActionEvent event) throws IOException{
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/News.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }
    @FXML
    private void goToNews2(ActionEvent event) throws IOException{
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/News2.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }
    @FXML
    private void goToNews3(ActionEvent event) throws IOException{
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/News3.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

}
