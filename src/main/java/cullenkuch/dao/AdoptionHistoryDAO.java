package cullenkuch.dao;

import cullenkuch.model.AdoptionRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cullenkuch.driver.Driver.conn;

public class AdoptionHistoryDAO {

    //constructor
    public AdoptionHistoryDAO(){

    }

    public boolean getAdoptionHistory() throws SQLException {
        int highestRecordId = 0;
        int numberOfRecordsReturned = 0;
        boolean highestIdEqualsRecordAmount = false;

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM adoption_history");
        ResultSet rs = null;
        rs = statement.executeQuery();
        while(rs.next()){
            int adopter_id = rs.getInt("adopter_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String puppy_breed = rs.getString("puppy_breed");
            String puppy_gender = rs.getString("puppy_gender");
            String puppy_name = rs.getString("puppy_name");
            ++numberOfRecordsReturned;
            System.out.println(adopter_id + " " + first_name + " " + last_name + " " + "adopted a " + puppy_gender + " " + puppy_breed + " " + "named " + puppy_name);
            if(adopter_id > highestRecordId){
                highestRecordId = adopter_id;
            }
        }
        if(!rs.next()){
            System.out.println("End of adoption records.");
        }
        if(highestRecordId == numberOfRecordsReturned){
            highestIdEqualsRecordAmount = true;
        }
        return highestIdEqualsRecordAmount;
    }

    public void deleteAdoptionRecord(AdoptionRecord R) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM adoption_history WHERE " +
                "adopter_id = ? AND " +
                "first_name = ? AND " +
                "last_name = ?");
        int parameterIndex = 0;
        statement.setInt(++parameterIndex, R.id);
        statement.setString(++parameterIndex, R.firstName);
        statement.setString(++parameterIndex, R.lastName);
        statement.executeUpdate();
        System.out.println("Successfully deleted record.");
    }
}
