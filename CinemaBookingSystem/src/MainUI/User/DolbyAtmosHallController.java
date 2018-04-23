package MainUI.User;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

    public class  DolbyAtmosHallController implements Initializable {


        //Textfields
        public TextField nameField;
        public TextField surnameField;
        public TextField creditCardField;
        public TextField contactNumberField;
        public TextField seatField;
        public Button submitButton;

        //statuses which will control everything ok or not
        public Label nameStatus;
        public Label surnameStatus;
        public Label creditCardStatus;
        public Label contactNumberStatus;
        public Label seatStatus;


        public Label MovieNameLabel;
        //label which shows us everything ok or not
        public Label successfullyCompletedReservation;

        //buttons
        // all seats
        public Button seat1;
        public Button seat2;
        public Button seat3;
        public Button seat4;
        public Button seat5;
        public Button seat6;
        public Button seat7;
        public Button seat8;
        public Button seat9;
        public Button seat10;
        public Button seat11;
        public Button seat12;
        public Button seat13;
        public Button seat14;
        public Button seat15;
        public Button seat16;
        public Button seat17;
        public Button seat18;

        //selected seat
        private String seatsSelected = null;

        //check if input is ok
        private boolean conditionToSubmit = true;


        //check fully
        @FXML
        private void BacktoDash(ActionEvent event) throws IOException {

            Parent dash = FXMLLoader.load(getClass().getResource("/MainUI/User/MemberDashBoard.fxml"));
            Scene dash_scene = new Scene(dash);
            Stage dash_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            dash_stage.setScene(dash_scene);
            dash_stage.show();
        }

        //FUNCTION TO CHECK DATA
        public void checkData() {
            conditionToSubmit = true;
            checkInput();
            if (conditionToSubmit) {
                BookParticularSeat();
            }
        }

        //checks inserted right or not
        private void checkInput() {


            //namefield activated
            if (nameField.getText().isEmpty()) {
                nameStatus.setText("Enter the name");
                conditionToSubmit = false;
            } else if (!Pattern.matches("[a-zA-Z]+", nameField.getText())) {
                nameStatus.setText("");
                nameStatus.setText("Letters only");
                conditionToSubmit = false;
            }

            //surnamefield activated
            if (surnameField.getText().isEmpty()) {
                surnameStatus.setText("Enter the surname");
                conditionToSubmit = false;
            } else if (!Pattern.matches("[a-zA-Z]+", surnameField.getText())) {
                surnameStatus.setText("");
                surnameStatus.setText("Letters only");
                conditionToSubmit = false;
            }


            //creditcardfield activated
            if (creditCardField.getText().isEmpty()) {
                creditCardStatus.setText("Enter the number of credit card");
                conditionToSubmit = false;
            } else if ((!Pattern.matches("[0-9]+", creditCardField.getText())) ||
                    creditCardField.getText().length() != 16) {
                creditCardStatus.setText("");
                creditCardStatus.setText("16 numbers");
                conditionToSubmit = false;
            }


            //contactnumberfield activated
            if(contactNumberField.getText().isEmpty())
            {
                contactNumberStatus.setText("Enter the contact number");
                conditionToSubmit = false;
            } else if(!Pattern.matches("[0-9]+",contactNumberField.getText()))

            {
                contactNumberStatus.setText("");
                contactNumberStatus.setText("Numbers only");
                conditionToSubmit = false;
            }

            if(seatsSelected ==null)
            {
                conditionToSubmit = false;
                seatStatus.setText("Select the seats");
            }

         //   conditionToSubmit =false;
        }


               public void BookParticularSeat() {


            //inserting info about member and inserted his seats
            String sqlInsert = "INSERT INTO `MembersHall` (`Name`,`Surname`,`ContactNumber`,`CreditCardNumber`,`seatID`,`MovieName`) VALUES (?,?,?,?,?,?)";
            //setting status to not free
            String sqlUpdateRoom = "UPDATE DolbyAtmosHall SET Available = ? WHERE Number = ?";
            try {  //try block
                //connecting to database
                Connection connection = dbConnection.getConnection();
                //updating the status of the seats
                PreparedStatement statementUpdate = connection.prepareStatement(sqlUpdateRoom);
                //setting Available column to no
                statementUpdate.setString(1, "no");
                statementUpdate.setString(2, seatsSelected);
                statementUpdate.executeUpdate();
                //inserting every booking to the database
                PreparedStatement statementInsert = connection.prepareStatement(sqlInsert);

                statementInsert.setString(1, nameField.getText());
                statementInsert.setString(2, surnameField.getText());
                statementInsert.setString(3, contactNumberField.getText());
                statementInsert.setString(4, creditCardField.getText());
                statementInsert.setString(5, seatsSelected);
                statementInsert.setString(6,MovieNameLabel.getText());
                statementInsert.execute();
                //closing connection
                statementInsert.close();
                connection.close();

            } catch (SQLException e) {   //catch block
                e.printStackTrace();
            }


            //setting every textfield empty
            nameField.setText("");
            surnameField.setText("");
            creditCardField.setText("");
            contactNumberField.setText("");

            //success label
            successfullyCompletedReservation.setText("Successfully booked");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Mercy,successfully booked!");
            alert.showAndWait();

        }

        //observablelists for seatNumber for first column and freeSeats for second column
        private ObservableList<Integer> seatNumber = FXCollections.observableArrayList();
        private ObservableList<String> FreeSeats = FXCollections.observableArrayList();


        //arraylist of all seats' number
        private ArrayList<Integer> AllSeats = new ArrayList<>();
        //arraylist of all buttons'
        private ArrayList<Button> allSeatsButtons = new ArrayList<>();

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //request to get info about booking
            String sqlCheckWhichIsFree = "SELECT Name, Surname, SeatID FROM MembersHall";

            //list with already booked seats
            ObservableList<Integer> busySeats;
            try { //try block
                Connection connection = dbConnection.getConnection();

                //initialize
                busySeats = FXCollections.observableArrayList();

                //result will show info about customer and his order
                ResultSet resultSet = connection.createStatement().executeQuery(sqlCheckWhichIsFree);

                //while you have customers with his order
                while (resultSet.next()) {
                    //add all their seats number to the busyseats observablelist
                    busySeats.add(resultSet.getInt(3));
                }

                //listing all the seats
                addAllSeatsToList();

                //request to update seats to no
                String sqlUpdateSeats = "UPDATE DolbyAtmosHall SET Available = ? WHERE Number = ?";
                PreparedStatement statementUpdate = connection.prepareStatement(sqlUpdateSeats);

                //Find all busyseats and update the to no
                for (int busySeat = 0; busySeat < busySeats.size(); busySeat++) {
                    statementUpdate.setString(1, "no");
                    statementUpdate.setInt(2, busySeats.get(busySeat));
                    statementUpdate.executeUpdate();
                }

                //if there is no busyseats then all the seats available
                for (int seat = 0; seat < AllSeats.size(); seat++) {
                    if (!busySeats.contains(AllSeats.get(seat))) {
                        statementUpdate.setString(1, "yes");
                        statementUpdate.setInt(2, AllSeats.get(seat));
                        statementUpdate.executeUpdate();
                    }
                }

                //method which add buttons to arraylist of buttons
                addSeatsButtons();

                //getting number of seats and status free or not
                String sqlGetFree = "SELECT Number, Available FROM DolbyAtmosHall";
                ResultSet resultSetOfSeats = connection.createStatement().executeQuery(sqlGetFree);

                //through all the seats
                while (resultSetOfSeats.next()) {
                    //adding number of seats observablelist "seatNumber"
                    seatNumber.add(resultSetOfSeats.getInt(1));
                    //adding status to observablelist "freeSeats"
                    FreeSeats.add(resultSetOfSeats.getString(2));
                }

                //through all the seats
                for (int seats = 0; seats < FreeSeats.size(); seats++) {
                    //if this seat free then change the button to green
                    if (FreeSeats.get(seats).equals("yes")) {
                        allSeatsButtons.get(seats)
                                .setStyle("-fx-background-color: #38ff3b;");
                    } else {
                        //if not change color to red
                        allSeatsButtons.get(seats)
                                .setStyle("-fx-background-color: #f90000;");
                    }
                }

                //closing connection
                connection.close();
            } catch (SQLException e) { //catch block
                e.getCause();
            }
        }

        public void selectedSeats(ActionEvent actionEvent) {
            //if no seats was selected
            if (seatsSelected == null) {
                //number of seats getting from button's text
                seatsSelected = ((Button) actionEvent.getSource()).getText();

                if (FreeSeats.get(AllSeats.indexOf(Integer.parseInt(seatsSelected))).equals("yes")) {
                    //change color to blue
                    ((Button) actionEvent.getSource()).setStyle("-fx-background-color: #bfa8a8;");
                    seatStatus.setText("");
                } else {
                    conditionToSubmit = false;
                    seatStatus.setText("");
                    seatStatus.setText("Seat is busy");
                    seatsSelected = null;
                }
            } else {
                //if room was selected
                //go through all the rooms
                for (int index = 0; index < FreeSeats.size(); index++) {
                    //if its yes to green
                    if (FreeSeats.get(index).equals("yes")) {
                        allSeatsButtons.get(index)
                                .setStyle("-fx-background-color: #38ff3b;");
                    } else {
                        //otherwise to red
                        allSeatsButtons.get(index)
                                .setStyle("-fx-background-color: #f90000;");
                    }
                }
                seatsSelected = ((Button) actionEvent.getSource()).getText();
            }
        }

        private void addAllSeatsToList() {
            for (int index = 1; index <= 18; index++) {
                AllSeats.add(index);
            }
        }

        private void addSeatsButtons() {
            allSeatsButtons.add(seat1);
            allSeatsButtons.add(seat2);
            allSeatsButtons.add(seat3);
            allSeatsButtons.add(seat4);
            allSeatsButtons.add(seat5);
            allSeatsButtons.add(seat6);
            allSeatsButtons.add(seat7);
            allSeatsButtons.add(seat8);
            allSeatsButtons.add(seat9);
            allSeatsButtons.add(seat10);
            allSeatsButtons.add(seat11);
            allSeatsButtons.add(seat12);
            allSeatsButtons.add(seat13);
            allSeatsButtons.add(seat14);
            allSeatsButtons.add(seat15);
            allSeatsButtons.add(seat16);
            allSeatsButtons.add(seat17);
            allSeatsButtons.add(seat18);

        }
    }


