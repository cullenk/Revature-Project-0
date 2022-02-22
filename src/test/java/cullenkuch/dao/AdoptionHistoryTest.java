package cullenkuch.dao;

import cullenkuch.service.AdoptionHistoryService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdoptionHistoryTest {

    //AdoptionHistoryDAO
    @Test
    void GetsAllAdoptionRecordsDAOTest() throws SQLException {
        AdoptionHistoryDAO testAdoptionDao = new AdoptionHistoryDAO();
        assertTrue(testAdoptionDao.getAdoptionHistory());
    }

//    @Test
//    void SuccessfullyDeletesAnAdoptionRecordDAOTest(){
//        Mockito?
//    }

   //AdoptionHistoryService
    @Test
    void GetsAllAdoptionRecordsServiceTest() throws SQLException {
        AdoptionHistoryService testAdoptionDao = new AdoptionHistoryService();
        assertTrue(testAdoptionDao.getAdoptionHistory());
    }

//    @Test
//    void SuccessfullyDeletesAnAdoptionRecordServiceTest(){
//         Mockito?
//    }


}
