package cullenkuch.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static cullenkuch.driver.Driver.conn;



public class Menu {

    public Menu(){

    }

    public void createMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there! Are you looking to adopt a puppy today or look up adoption records?");
        String goal = scanner.nextLine();
        boolean validResponse = false;
        int puppy_id;
        String first_name;
        String last_name;
        String size;
        String temperament;
        String sheds;
        String puppy_name;
        String puppy_gender;
        String breed;

        do {
            //Adoption Logic
            if (goal.equals("adopt")) {
                System.out.println("Great, let's find you a puppy!");
                validResponse = true;
                System.out.println("First of all, what's your first name?");
                first_name = scanner.nextLine();
                System.out.println("What's your last name?");
                last_name = scanner.nextLine();

                //CHECK FOR SIZE
                boolean sizeValid = false;
                do {
                    System.out.println("Thanks " + first_name + " " + last_name + "!" + " " + "Are you interested in a puppy that will grow to be small, medium or large in size?");
                    size = scanner.nextLine();
                    if (size.equals("small") || size.equals("medium") || size.equals("large")) {
                        sizeValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid size of small, medium or large");
                    }
                } while (!sizeValid);

                //CHECK FOR TEMPERAMENT
                boolean temperamentValid = false;
                do {
                    System.out.println("Got it! And would you prefer a puppy that's more mellow or active by nature?");
                    temperament = scanner.nextLine();
                    if (temperament.equals("mellow") || temperament.equals("active")) {
                        temperamentValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid temperament of mellow or active");
                    }
                } while (!temperamentValid);

                //CHECK FOR SHEDDING
                boolean shedsValid = false;
                do {
                    System.out.println("Okay, does it matter if your puppy is easy to groom?");
                    sheds = scanner.nextLine();
                    if (sheds.equals("yes") || sheds.equals("no")) {
                        shedsValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid response of yes or no.");
                    }
                } while (!shedsValid);

//                //DISPLAY RESULT OPTIONS
                    PreparedStatement statement = conn.prepareStatement("SELECT breed FROM puppy WHERE size = ? AND temperament = ? AND sheds = ?");
                    statement.setString(1, size);
                    statement.setString(2, temperament);
                    if(sheds.equals("yes")){
                        sheds = "a little";
                    } else {
                        sheds = "a lot";
                    }
                    statement.setString(3, sheds);

                    ResultSet rs = null;
                    ArrayList<String> returnedBreeds = new ArrayList<String>();
                    boolean validPuppyChoice = false;
//
                    rs = statement.executeQuery();
                    System.out.println("Fantastic! Based on what you've told me, here are some breeds that would suit you best. Which one would you like?");
                    while (rs.next()) {
                        breed = rs.getString("breed");
                        returnedBreeds.add(breed);
                        System.out.println(breed);
                    }
                    do{
                        breed = scanner.nextLine();
                        if (returnedBreeds.contains(breed)){
                            validPuppyChoice = true;
                        } else {
                            System.out.println("Hmm, that breed isn't listed. Please choose a breed from the list above.");
                        }
                    } while(!validPuppyChoice);


                System.out.println("Great choice! Would you like your puppy to be male or female?");
                puppy_gender = scanner.nextLine();
                System.out.println("Lastly, what do you want to name your new puppy?");
                puppy_name = scanner.nextLine();
                System.out.println("Congratulations " + first_name + "!" + " " + "You're bringing home a " + puppy_gender + " " + breed + " puppy " + "named" + " " + puppy_name + ". Take good care of it!");

                //Records Logic
            } else if (goal.equals("records")) {
                System.out.println("Here's our adoption history:");
                validResponse = true;
            }


            //Invalid Logic
            else {
                System.out.println("Oops, I didn't catch that. You can say 'adopt' or 'records'.");
                goal = scanner.nextLine();
            }
        } while (!validResponse);

    }

}
