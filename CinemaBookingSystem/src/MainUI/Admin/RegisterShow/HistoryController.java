package MainUI.Admin.RegisterShow;

import MainUI.Admin.AddMovie.MovieData;
import MainUI.Admin.RegisterShow.HistoryData;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class HistoryController implements Initializable {
    //Creating tableView for every column

    @FXML
    private TableView<MainUI.Admin.RegisterShow.HistoryData> movietable;
    @FXML
    private TableColumn<HistoryData,String> namecolumn;
    @FXML
    private TableColumn<HistoryData, String> surnamecolumn;
    @FXML
    private TableColumn<MainUI.Admin.RegisterShow.HistoryData, String> seatidcolumn;
    @FXML
    private TableColumn<MainUI.Admin.RegisterShow.HistoryData, String> contactnumbercolumn;
    @FXML
    private TableColumn<MainUI.Admin.RegisterShow.HistoryData, String> creditcardcolumn;
    @FXML
    private TableColumn<MainUI.Admin.RegisterShow.HistoryData, String> movienamecolumn;

    @FXML
    private Button DolbyData;
    @FXML
    private Button ComfortData;
    @FXML
    private Button BrooklynData;
    @FXML
    private Button LibertyData;
    @FXML
    private Button DarkhanData;



    private ObservableList<MainUI.Admin.RegisterShow.HistoryData> data;
    private dbConnection dc;




    //initalize method
    public void initialize(URL url, ResourceBundle rb) {

        this.dc = new dbConnection();
    }

    @FXML
    private void loadMovieDolby(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Members");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.RegisterShow.HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.seatidcolumn.setCellValueFactory(new PropertyValueFactory("seatID"));
        this.contactnumbercolumn.setCellValueFactory(new PropertyValueFactory("ContactNumber"));
        this.creditcardcolumn.setCellValueFactory(new PropertyValueFactory("CreditCard"));
        this.movienamecolumn.setCellValueFactory(new PropertyValueFactory("MovieName"));


        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);

    }

    @FXML
    private void loadMovieBrooklyn(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Members3Hall");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.RegisterShow.HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.seatidcolumn.setCellValueFactory(new PropertyValueFactory("seatID"));
        this.contactnumbercolumn.setCellValueFactory(new PropertyValueFactory("ContactNumber"));
        this.creditcardcolumn.setCellValueFactory(new PropertyValueFactory("CreditCard"));
        this.movienamecolumn.setCellValueFactory(new PropertyValueFactory("MovieName"));


        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);

    }

    @FXML
    private void loadMovieComfort(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Members2Hall");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.RegisterShow.HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.seatidcolumn.setCellValueFactory(new PropertyValueFactory("seatID"));
        this.contactnumbercolumn.setCellValueFactory(new PropertyValueFactory("ContactNumber"));
        this.creditcardcolumn.setCellValueFactory(new PropertyValueFactory("CreditCard"));
        this.movienamecolumn.setCellValueFactory(new PropertyValueFactory("MovieName"));


        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);

    }

    @FXML
    private void loadMovieLiberty(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Members4Hall");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.RegisterShow.HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.seatidcolumn.setCellValueFactory(new PropertyValueFactory("seatID"));
        this.contactnumbercolumn.setCellValueFactory(new PropertyValueFactory("ContactNumber"));
        this.creditcardcolumn.setCellValueFactory(new PropertyValueFactory("CreditCard"));
        this.movienamecolumn.setCellValueFactory(new PropertyValueFactory("MovieName"));


        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);

    }

    @FXML
    private void loadMovieDarkhan(ActionEvent event) {
        try {
            //open connection
            Connection conn = dbConnection.getConnection();
            //observable arraylist created to add a way to listen for changes on a list
            this.data = FXCollections.observableArrayList();
            //from database take all films
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Members5Hall");
            //while it has next,add them to the table columns
            while (rs.next()) {
                this.data.add(new MainUI.Admin.RegisterShow.HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) { //catch block
            System.err.println("Error " + e);
        }

        //Insert informations into table
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.seatidcolumn.setCellValueFactory(new PropertyValueFactory("seatID"));
        this.contactnumbercolumn.setCellValueFactory(new PropertyValueFactory("ContactNumber"));
        this.creditcardcolumn.setCellValueFactory(new PropertyValueFactory("CreditCard"));
        this.movienamecolumn.setCellValueFactory(new PropertyValueFactory("MovieName"));


        //set data
        this.movietable.setItems(null);
        this.movietable.setItems(this.data);

    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/Admin/AdminDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }

}
