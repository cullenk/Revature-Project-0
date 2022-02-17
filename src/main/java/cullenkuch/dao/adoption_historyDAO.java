package cullenkuch.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cullenkuch.driver.Driver.conn;

public class adoption_historyDAO {

    //constructor
    public adoption_historyDAO(){

    }

    public void getAdoptionHistory() throws SQLException {
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

            System.out.println(adopter_id + " " + first_name + " " + last_name + " " + puppy_breed + " " + puppy_gender + " " + puppy_name);
        }
    }
}
