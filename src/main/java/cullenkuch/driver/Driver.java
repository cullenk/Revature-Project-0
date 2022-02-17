package cullenkuch.driver;


import cullenkuch.model.Menu;
import cullenkuch.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        /*TO DO:

        -Add toLowerCase for all input responses.
        -Add the adoption record to the table at the end.
        -Query to get the adoption records in the beginning if needed.
        -Replace Array List with a manually expanding array like we did in class
        -Remove duplicate dog breeds in my table

         */
        Menu myMenu = new Menu();
        myMenu.createMenu();

    }
}