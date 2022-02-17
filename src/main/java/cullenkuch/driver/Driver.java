package cullenkuch.driver;

import cullenkuch.dao.puppyDAO;
import cullenkuch.model.Puppy;
import cullenkuch.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        //Puppy Picker App

        /*
        1) Do you prefer a small, medium or big dog?
        2) Do you want it to be active or mellow in nature?
        3) Does it need to be easy to groom? (Y/N?)
        4) Here are the breed options best suited for you! Choose one.
        5) You've chosen a _____. Do you want a male or female?
        6) What would you like to name it?
        7) Congrats, you've found the best puppy for you! It's a male labrador retriever named Cooper!
        8) Print image of dog?
         */
        puppyDAO firstTest = new puppyDAO();
        firstTest.getAllPuppies();

    }
}