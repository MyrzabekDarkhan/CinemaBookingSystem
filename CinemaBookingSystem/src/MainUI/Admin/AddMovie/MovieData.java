package MainUI.Admin.AddMovie;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;


public class MovieData {
    //attributes
    private final StringProperty ID;
    private final StringProperty firstName;
    private final StringProperty lastName;


    private final StringProperty Details;
    private final StringProperty Ratings;
    private final StringProperty DOB;
    private final StringProperty Price;
// Paramtetric constructor
    public MovieData(String id, String firstname, String lastname, String details, String ratings, String dob, String price) {
        this.ID = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastname);
        this.Details = new SimpleStringProperty(details);
        this.Ratings = new SimpleStringProperty(ratings);
        this.DOB = new SimpleStringProperty(dob);
        this.Price = new SimpleStringProperty(price);

    }

//returns id
    public String getID() {

        return ID.get();
    }
   //returns the StringProperty of an object
    public StringProperty IDProperty() {

        return ID;
    }
//set the id
    public void setID(String ID) {

        this.ID.set(ID);
    }
    //returns first name
    public String getFirstName() {

        return firstName.get();
    }
  //returns the StringProperty of an object
    public StringProperty firstNameProperty() {

        return firstName;
    }
   //set first name
    public void setFirstName(String firstName) {

        this.firstName.set(firstName);
    }
    //returns last name
    public String getLastName() {

        return lastName.get();
    }
    //returns the StringProperty of an object
    public StringProperty lastNameProperty() {

        return lastName;
    }
    //set last name
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    //returns details about film
    public String getDetails() {

        return Details.get();
    }
    //returns the StringProperty of an object
    public StringProperty detailsProperty() {
        return Details;
    }

    //set details of the film
    public void setDetails(String details) {
        this.Details.set(details);
    }
    //returns rating of the film
    public String getRatings() {
        return Ratings.get();
    }
    //returns the StringProperty of an object
    public StringProperty ratingsProperty() {
        return Ratings;
    }
    //set rating of the film
    public void setRatings(String ratings) {
        this.Ratings.set(ratings);
    }
    //returns DOB
    public String getDOB() {
        return DOB.get();
    }
    //returns StringProperty of an object
    public StringProperty DOBProperty() {
        return DOB;
    }
    //set DOB
    public void setDOB(String DOB) {
        this.DOB.set(DOB);

    }
    //retunrs price of an film
    public String getPrice() {
        return Price.get();
    }
    //returns StringProperty of an object
    public StringProperty priceProperty() {
        return Price;
    }
    //set price of the film
    public void setPrice(String price) {
        this.Price.set(price);
    }
}

