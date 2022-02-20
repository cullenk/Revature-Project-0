package cullenkuch.service;

import cullenkuch.dao.PuppyDAO;
import cullenkuch.model.Puppy;

import java.sql.SQLException;

public class PuppyService {

    PuppyDAO puppydao;

    //Constructors
    public PuppyService(){
        puppydao = new PuppyDAO();
    }
    public PuppyService(PuppyDAO dao){
        puppydao = dao;
    }

    public boolean addNewBreed(String breed, String temperament, String size, String sheds){
        try{
            Puppy p = new Puppy(breed, temperament, size, sheds);
            puppydao.addNewBreed(p);
            System.out.println("Successfully added: " + p.breed);
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

//    public Painting getPainting(String userInput){
//        if(userInput.length()<=0){
//            return null;
//        }
//        try {
//            return paintingdao.getPainting(userInput);
//        }catch(SQLException e){
//            return null;
//        }
//    }


}
