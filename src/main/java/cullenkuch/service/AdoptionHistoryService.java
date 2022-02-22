package cullenkuch.service;

import cullenkuch.dao.AdoptionHistoryDAO;
import cullenkuch.dao.PuppyDAO;
import cullenkuch.model.AdoptionRecord;
import cullenkuch.model.Puppy;

import java.sql.SQLException;

public class AdoptionHistoryService {

    AdoptionHistoryDAO adoptionhistorydao;

    //Constructors
    public AdoptionHistoryService(){
        adoptionhistorydao = new AdoptionHistoryDAO();
    }
    public AdoptionHistoryService(AdoptionHistoryDAO dao){
        adoptionhistorydao = dao;
    }

    public boolean getAdoptionHistory(){
        try{
            AdoptionHistoryDAO records = new AdoptionHistoryDAO();
            adoptionhistorydao.getAdoptionHistory();
            System.out.println("Successfully printing out adoption history");
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public void deleteAdoptionRecord(int id, String firstName, String lastName){
        try{
            AdoptionHistoryDAO records = new AdoptionHistoryDAO();
            AdoptionRecord r = new AdoptionRecord(id, firstName, lastName);
            adoptionhistorydao.deleteAdoptionRecord(r);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }



}
