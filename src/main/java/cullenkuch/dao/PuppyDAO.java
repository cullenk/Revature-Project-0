package cullenkuch.dao;

import cullenkuch.model.Puppy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static cullenkuch.driver.Driver.conn;

public class PuppyDAO {

    //constructor
    public PuppyDAO(){

    }

    public boolean getAllBreeds() throws SQLException {
        int highestPuppyId = 0;
        int numberOfBreedsReturned = 0;
        boolean highestIdEqualsBreedAmount = false;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM puppy");
        ResultSet rs = null;
        rs = statement.executeQuery();
        while (rs.next()) {
            int puppy_id = rs.getInt("id");
            String breed = rs.getString("breed");
            String temperament = rs.getString("temperament");
            String size = rs.getString("size");
            String sheds = rs.getString("sheds");
            ++numberOfBreedsReturned;
            System.out.println(puppy_id + " " + breed + " " + temperament + " " + size + " " + sheds);
            if(puppy_id > highestPuppyId){
                highestPuppyId = puppy_id;
            }
        }
        if(highestPuppyId == numberOfBreedsReturned){
            highestIdEqualsBreedAmount = true;
        }
        return highestIdEqualsBreedAmount;
    }


    public Puppy getBreedDetails(String breed) throws SQLException {
        Puppy myPuppy = null;

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM puppy WHERE breed = ?");
        int parameterIndex = 0;
        statement.setString(++parameterIndex, breed);
        ResultSet rs = statement.executeQuery();


        while (rs.next()) {
            myPuppy = new Puppy(
                    rs.getString("breed"),
                    rs.getString("temperament"),
                    rs.getString("size"),
                    rs.getString("sheds"));
            System.out.println(myPuppy);
        }
        rs.close();
        return myPuppy;
    }

    public void addNewBreed(Puppy P) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO puppy (breed, temperament, size, sheds) Values (?,?,?,?)");
        int parameterIndex = 0;
        statement.setString(++parameterIndex, P.getBreed());
        statement.setString(++parameterIndex, P.getTemperament());
        statement.setString(++parameterIndex, P.getSize());
        statement.setString(++parameterIndex, P.getSheds());
        statement.executeUpdate();
        System.out.println("Added new breed");
    }
}





