package MainUI.Admin;

import MainUI.Admin.AddMovie.MovieData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import dbUtil.dbConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class MovieController implements Initializable {

//controllers are instantiated
    @FXML
    private TextField id1;
    @FXML
    private TextField id;
    @FXML
    private TextField moviename;
    @FXML
    private TextField director;
    @FXML
    private TextField details;
    @FXML
    private TextField ratings;
    @FXML
    private TextField price;

   //Creating tableView for every column
    @FXML
    private DatePicker dos;
    @FXML
    private TableView<MainUI.Admin.AddMovie.MovieData> movietable;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> idcolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> firstnamecolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> lastnamecolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> detailscolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> ratingscolumn;

    @FXML
    private TableColumn<MovieData, String> dobcolumn;
    @FXML
    private TableColumn<MainUI.Admin.AddMovie.MovieData, String> pricecolumn;
    @FXML
    private Button loadbutton;
    private ObservableList<MainUI.Admin.AddMovie.MovieData> data;
    private dbConnection dc;

    //initalize method
    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();
    }

    //takes films from database and write it in the table
    @FXML
    private void loadMovieData(ActionEvent event) {
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

    private boolean validationcheck()
    {
        if("".equals(id.getText()))
            return false;
        if("".equals(moviename.getText()))
            return false;
        if("".equals(director.getText()))
            return false;
        if("".equals(details.getText()))
            return false;
        if("".equals(ratings.getText()))
            return false;
        if("".equals(price.getText()))
            return false;
        return true;
    }

   //method which delete movies
    @FXML
    private void deleteMovie(ActionEvent event){
        String sql = "DELETE FROM `Movies` WHERE id = ?";
        try {//try block
            //open connection
            Connection conn = dbConnection.getConnection();
            //PreparedStatement: precompiles queries that can contain input parameters
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.id1.getText());
            stmt.executeUpdate();
            this.id1.setText("");


            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Success Dialog");
            alert1.setHeaderText(null);
            alert1.setContentText("Successfully deleted from database!");
            alert1.showAndWait();


            conn.close();
        }catch (SQLException ex){
            System.err.println("Got an exception!");
            System.err.println(ex.getMessage());
        }
    }

      //adding movies to the database
    @FXML
    private void addMovie(ActionEvent event) {
        //? - place of insertion of our value
        String sql = "INSERT INTO `Movies`(`id`, `mname`, `director`, `details`, `Rating`,`date`,`price`) VALUES (? , ?, ?, ?, ?, ? ,?)";
        try {//try block
            //open connection
            Connection conn = dbConnection.getConnection();
            //PreparedStatement: precompiles queries that can contain input parameters
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.moviename.getText());
            stmt.setString(3, this.director.getText());
            stmt.setString(4, this.details.getText());
            stmt.setString(5, this.ratings.getText());
            stmt.setString(6, this.dos.getEditor().getText());
            stmt.setString(7, this.price.getText());
            //perform statement
            stmt.execute();

            if (validationcheck() == true) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Successfully added to the database!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Please fill out all required fields!");


                alert.showAndWait();

            }


                this.id.setText("");
            this.moviename.setText("");
            this.director.setText("");
            this.details.setText("");
            this.ratings.setText("");
            this.dos.setValue(null);
            this.price.setText("");

            //close connection
            conn.close();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    //Method which clear fields
    @FXML
    private void clearFields(ActionEvent event) {

        this.id.setText("");
        this.moviename.setText("");
        this.director.setText("");
        this.details.setText("");
        this.ratings.setText("");
        this.dos.setValue(null);
        this.price.setText("");

    }
    //back button method
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/Admin/AdminDashBoard.fxml"));
        Scene dash_scene = new Scene(dash);
        Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dash_stage.setScene(dash_scene);
        dash_stage.show();
    }
}

