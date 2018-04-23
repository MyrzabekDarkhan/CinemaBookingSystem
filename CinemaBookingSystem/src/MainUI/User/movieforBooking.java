package MainUI.User;

import MainUI.Admin.AddMovie.MovieData;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class movieforBooking implements Initializable {
    //Creating tableView for every column
    @FXML
    private DatePicker dos;
    @FXML
    private TableView<MovieData> movietable;
    @FXML
    private TableColumn<MovieData, String> idcolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> firstnamecolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> lastnamecolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> detailscolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> ratingscolumn;

    @FXML
    private Button bookmovie;
    @FXML
    private Button loadformember;

    @FXML
    private TableColumn<MovieData, String> dobcolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> pricecolumn;
    private ObservableList<MovieData> data;
    private dbConnection dc;

    //initalize method
    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();
    }

    //takes films from database and write it in the table
    @FXML
    private void loadMovieDataForMember(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Movies");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.AddMovie.MovieData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.detailscolumn.setCellValueFactory(new PropertyValueFactory("details"));
        this.ratingscolumn.setCellValueFactory(new PropertyValueFactory("ratings"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
        this.pricecolumn.setCellValueFactory(new PropertyValueFactory("price"));

        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);
    }

    //go to the dolby atmos hall
    @FXML
    private void BookMoviesFromDolby(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/DolbyAtmosHall.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

    //go to the comfort hall
    @FXML
    private void BookMoviesFromComfort(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/ComfortHall.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

    //go to the brooklyn hall
    @FXML
    private void BookMoviesFromBrooklyn(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/BrooklynHall.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

    //go to the liberty hall
    @FXML
    private void BookMoviesFromLiberty(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/LibertyHall.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

    //go to the Darkhan hall
    @FXML
    private void BookMoviesFromDarkhan(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/DarkhanHall.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }



    @FXML
    private void BacktoDash(ActionEvent event) throws IOException {

        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/MemberDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }}





