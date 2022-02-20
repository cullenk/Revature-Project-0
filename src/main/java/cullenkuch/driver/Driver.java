package cullenkuch.driver;


import cullenkuch.dao.AdoptionHistoryDAO;
import cullenkuch.dao.PuppyDAO;
import cullenkuch.model.Menu;
import cullenkuch.service.PuppyService;
import cullenkuch.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        /*TO DO:

        -Add testing methods and Mockito
        -Add a method to remove a record by first and last name
        -Add a method to add a new dog breed option
        -Error if no breeds match (small active shedder)
        -add more dog options for every result combo
         */

        PuppyDAO testPuppyDao = new PuppyDAO();
//
        PuppyService puppyService = new PuppyService();
        puppyService.addNewBreed("Bichon Frise", "active", "small", "a lot");
//
//        AdoptionHistoryDAO records = new AdoptionHistoryDAO();
//        records.getAdoptionHistory();

//        Menu myMenu = new Menu();
//        myMenu.createMenu();

    }
}


