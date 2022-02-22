package cullenkuch.driver;


import cullenkuch.dao.AdoptionHistoryDAO;
import cullenkuch.dao.PuppyDAO;
import cullenkuch.model.AdoptionRecord;
import cullenkuch.model.Menu;
import cullenkuch.model.Puppy;
import cullenkuch.service.AdoptionHistoryService;
import cullenkuch.service.PuppyService;
import cullenkuch.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        PuppyDAO testPuppyDao = new PuppyDAO();
        PuppyService puppyService = new PuppyService();
        AdoptionHistoryDAO adoptionDao = new AdoptionHistoryDAO();
        AdoptionHistoryService adoptionService = new AdoptionHistoryService();
        Puppy newPuppy = new Puppy();
        AdoptionRecord newRecord = new AdoptionRecord();

//        adoptionDao.getAdoptionHistory();

//        Menu myMenu = new Menu();
//        myMenu.createMenu();
    }
}


