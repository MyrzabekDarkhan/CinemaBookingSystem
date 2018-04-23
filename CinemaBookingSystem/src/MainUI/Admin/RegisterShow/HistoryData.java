package MainUI.Admin.RegisterShow;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HistoryData {

    //attributes
    private final StringProperty Name;
    private final StringProperty Surname;
    private final StringProperty SeatID;


    private final StringProperty ContactNumber;
    private final StringProperty CreditCard;
    private final StringProperty MovieName;

    // Paramtetric constructor
    public HistoryData(String name, String surname, String seatID, String contactnumber, String creditcard, String moviename) {
        this.Name = new SimpleStringProperty(name);
        this.Surname = new SimpleStringProperty(surname);
        this.SeatID = new SimpleStringProperty(seatID);
        this.ContactNumber = new SimpleStringProperty(contactnumber);
        this.CreditCard = new SimpleStringProperty(creditcard);
        this.MovieName = new SimpleStringProperty(moviename);


    }


    //getters and setters are instantiated
    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }
    public String getSurname() {
        return Surname.get();
    }

    public StringProperty surnameProperty() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname.set(surname);
    }

    public String getSeatID() {
        return SeatID.get();
    }

    public StringProperty seatIDProperty() {
        return SeatID;
    }

    public void setSeatID(String seatID) {
        this.SeatID.set(seatID);
    }

    public String getContactNumber() {
        return ContactNumber.get();
    }

    public StringProperty contactNumberProperty() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.ContactNumber.set(contactNumber);
    }

    public String getCreditCard() {
        return CreditCard.get();
    }

    public StringProperty creditCardProperty() {
        return CreditCard;
    }

    public void setCreditCard(String creditCard) {
        this.CreditCard.set(creditCard);
    }

    public String getMovieName() {

        return MovieName.get();
    }

    public StringProperty movieNameProperty() {

        return MovieName;
    }

    public void setMovieName(String movieName) {

        this.MovieName.set(movieName);
    }
}