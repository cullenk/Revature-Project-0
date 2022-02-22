package cullenkuch.model;

public class AdoptionRecord {
    public int id;
    public String firstName;
    public String lastName;

    public AdoptionRecord(int adopter_id, String firstName, String lastName) {
        this.id = adopter_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AdoptionRecord(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
