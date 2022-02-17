package cullenkuch.driver;


import cullenkuch.model.Menu;
import cullenkuch.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        /*TO DO:

        -toLowerCase when choosing a breed from returned list
        -Add variables to query instead
        -Add the adoption record to the table at the end.
        -Query to get the adoption records in the beginning if needed.
        -Replace Array List with a manually expanding array like we did in class

         */
        Menu myMenu = new Menu();
        myMenu.createMenu();

    }
}