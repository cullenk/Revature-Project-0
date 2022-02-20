package cullenkuch.dao;

import cullenkuch.model.Puppy;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PuppyDAOTest {

    @Test
    void GetsThePuppyBreedYouSearchFor() throws SQLException {
        PuppyDAO testPuppyDao = new PuppyDAO();
        Puppy myPug = testPuppyDao.getBreedDetails("Pug");
        assertTrue(myPug.breed.equalsIgnoreCase("Pug"));
    }

//    @Test
//    void GetsAllThePuppiesInTheTable() throws SQLException {
//        PuppyDAO testPuppyDao = new PuppyDAO();
//        Puppy myPug = testPuppyDao.getBreedDetails("Pug");
//        assertTrue(myPug.breed.equalsIgnoreCase("Pug"));
//    }

}