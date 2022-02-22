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

    public boolean getAllBreeds(){
        try{
            Puppy p = new Puppy();
            puppydao.getAllBreeds();
            System.out.println("Successfully returning all breeds");
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Puppy getBreedDetails(String breed){
        Puppy myPuppy = null;
        try{
            myPuppy = new Puppy(breed);
            myPuppy.breed = breed;
            puppydao.getBreedDetails(breed);
            System.out.println("Successfully checking breed: " + breed);

        } catch(SQLException e){
            e.printStackTrace();
        }
        return myPuppy;
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

}
