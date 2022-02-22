package cullenkuch.dao;

import cullenkuch.model.Puppy;
import cullenkuch.service.PuppyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PuppyDAOTest {
//    Puppy testPuppy;
//    Puppy testPuppyFromMock;
//    PuppyDAO mockdao;
//    PuppyDAO realdao;
//    Connection mockConnection;
//    PreparedStatement mockPrepared;
//    ResultSet mockResultForGetBreedDetails;
//
//    @BeforeAll
//    public void SetUpMocks() throws SQLException {
//        testPuppy = new Puppy("Space Dog", "active", "medium", "a little");
//        testPuppyFromMock = new Puppy("Space Dog", "active", "medium", "a little");
//        mockdao = Mockito.mock(PuppyDAO.class);
//
//        Mockito.when(mockdao.getBreedDetails("Space Dog")).thenReturn(testPuppyFromMock);
//
//        mockConnection = Mockito.mock(Connection.class);
//        mockPrepared = Mockito.mock(PreparedStatement.class);
//        mockResultForGetBreedDetails = Mockito.mock(ResultSet.class);
//
//        PuppyDAO pdao = new PuppyDAO(mockConnection);
//        realdao = new PuppyDAO(mockConnection);
//
//        Mockito.when(mockResultForGetBreedDetails.next()).thenReturn(true).thenReturn(false);
//        Mockito.when(mockResultForGetBreedDetails.getString("breed")).thenReturn("Space Dog");
//        Mockito.when(mockResultForGetBreedDetails.getString("temperament")).thenReturn("active");
//        Mockito.when(mockResultForGetBreedDetails.getString("size")).thenReturn("medium");
//        Mockito.when(mockResultForGetBreedDetails.getString("sheds")).thenReturn("a little");
//
//        Mockito.when(mockConnection.prepareStatement("Select * From puppy Where breed = ?")).thenReturn(mockPrepared);
//        Mockito.when(mockPrepared.executeQuery()).thenReturn(mockResultForGetBreedDetails);
//    }


    //PuppyDAO
    @Test
    void GetsAllTheBreedsInTheTableDAOTest() throws SQLException {
        PuppyDAO testPuppyDao = new PuppyDAO();
        assertTrue(testPuppyDao.getAllBreeds());
    }

    @Test
    void GetsTheBreedYouSearchForDAOTest() throws SQLException {
        PuppyDAO testPuppyDao = new PuppyDAO();
        Puppy myPug = testPuppyDao.getBreedDetails("Pug");
        assertTrue(myPug.breed.equalsIgnoreCase("Pug"));
    }

    //PuppyService
    @Test
    void GetsAllTheBreedsInTheTableServiceTest() throws SQLException {
        PuppyService testPuppyService = new PuppyService();
        assertTrue(testPuppyService.getAllBreeds());
    }

    @Test
    void GetsTheBreedYouSearchForServiceTest() throws SQLException {
        PuppyService testPuppyService = new PuppyService();
        Puppy myPug = testPuppyService.getBreedDetails("Pug");
        assertTrue(myPug.breed.equalsIgnoreCase("Pug"));
    }


//    @Test
//    void SuccessfullyAddsANewBreedToTheTable() throws SQLException {
//        Mockito?
//    }

}