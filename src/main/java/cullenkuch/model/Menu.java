package cullenkuch.model;

import cullenkuch.dao.AdoptionHistoryDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String first_name;
        String last_name;
        String size;
        String temperament;
        String sheds;
        String puppy_name;
        String puppy_gender;
        String breed;

        boolean firstNameValid = false;
        boolean lastNameValid = false;
        do {
            //If the user wants to adopt
            if (goal.equalsIgnoreCase("adopt")) {
                System.out.println("Great, let's find you a puppy!");
                validResponse = true;
                System.out.println("First of all, what's your first name?");

                //CHECK FOR FIRST NAME
                do{
                    first_name = scanner.nextLine();
                    if(first_name.length() > 0){
                        firstNameValid = true;
                    } else {
                        System.out.println("Oops, please enter a name at least one letter long.");
                    }
                } while(!firstNameValid);

                //CHECK FOR LAST NAME
                System.out.println("What's your last name?");
                do{
                    last_name = scanner.nextLine();
                    if(last_name.length() > 0){
                        lastNameValid = true;
                    } else {
                        System.out.println("Oops, please enter a name at least one letter long.");
                    }
                } while(!lastNameValid);

                //CHECK FOR SIZE
                boolean sizeValid = false;
                System.out.println("Thanks " + first_name + " " + last_name + "!" + " " + "Are you interested in a puppy that will grow to be small, medium or large in size?");
                do {
                    size = scanner.nextLine();
                    if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
                        sizeValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid size of small, medium or large");
                    }
                } while (!sizeValid);

                //CHECK FOR TEMPERAMENT
                boolean temperamentValid = false;
                System.out.println("Got it! And would you prefer a puppy that's more mellow or active by nature?");
                do {
                    temperament = scanner.nextLine();
                    if (temperament.equalsIgnoreCase("mellow") || temperament.equalsIgnoreCase("active")) {
                        temperamentValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid temperament of mellow or active");
                    }
                } while (!temperamentValid);

                //CHECK FOR SHEDDING
                boolean shedsValid = false;
                System.out.println("Okay, does it matter if your puppy is easy to groom?");
                do {
                    sheds = scanner.nextLine();
                    if (sheds.equalsIgnoreCase("yes") || sheds.equalsIgnoreCase("no")) {
                        shedsValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid response of yes or no.");
                    }
                } while (!shedsValid);

//                //DISPLAY RESULT OPTIONS FROM SQL QUERY
                    PreparedStatement statement = conn.prepareStatement("SELECT breed FROM puppy WHERE size = ? AND temperament = ? AND sheds = ?");
                    statement.setString(1, size);
                    statement.setString(2, temperament);
                    if(sheds.equalsIgnoreCase("yes")){
                        sheds = "a little";
                    } else if (sheds.equalsIgnoreCase("no")){
                        sheds = "a lot";
                    }
                    statement.setString(3, sheds);

                    ResultSet rs = null;
                    int currentBreedsArrayLength = 0;
                    String[] returnedBreedsArray = new String[1];
                    rs = statement.executeQuery();

                    System.out.println("Fantastic! Based on what you've told me, here are some breeds that would suit you best. Which one would you like?");
                    //Create expanding array to hold returned breeds, without using ArrayList
                    while (rs.next()) {
                        breed = rs.getString("breed");
                        if(currentBreedsArrayLength + 1 > returnedBreedsArray.length) {
                            String[] biggerArray = new String[currentBreedsArrayLength * 2];
                            for (int i = 0; i < returnedBreedsArray.length; i++) {
                                biggerArray[i] = returnedBreedsArray[i];
                            }
                            returnedBreedsArray = biggerArray;
                        }
                        returnedBreedsArray[currentBreedsArrayLength] = breed;
                        currentBreedsArrayLength++;
                        System.out.println(breed);
                    }

                    //Check to see if the breed the user selects exists in the returned breed array
                    boolean validPuppyChoice = false;

                    while(true){
                        breed = scanner.nextLine();
                        for (String s : returnedBreedsArray) {
                            if (s != null && s.equalsIgnoreCase(breed)){
                                validPuppyChoice = true;
                            }
                        }
                        if (validPuppyChoice) break;
                        else System.out.println("Hmm, that breed isn't listed. Please choose a breed from the list above.");
                    }

                //CHECK FOR PUPPY GENDER
                boolean puppyGenderValid = false;
                System.out.println("Great choice! Would you like your puppy to be male or female?");
                do{
                    puppy_gender = scanner.nextLine();
                    if (puppy_gender.equalsIgnoreCase("male") || puppy_gender.equalsIgnoreCase("female")) {
                        puppyGenderValid = true;
                    } else {
                        System.out.println("Oops, please choose a valid response of male or female.");
                    }
                } while(!puppyGenderValid);

                //CHECK FOR PUPPY NAME
                boolean puppyNameValid = false;
                System.out.println("Lastly, what do you want to name your new puppy?");
                do{
                    puppy_name = scanner.nextLine();
                    if (puppy_name.length() > 0) {
                        puppyNameValid = true;
                    } else {
                        System.out.println("Oops, please enter a name at least one letter long.");
                    }
                } while(!puppyNameValid);


                System.out.println("Congratulations " + first_name + "!" + " " + "You're bringing home a " + puppy_gender + " " + breed + " puppy " + "named" + " " + puppy_name + ". Take good care of it!");
                System.out.println("I'll go ahead and add this adoption to our records as well.");

                //Add the chosen puppy to records
                PreparedStatement recordsStatement = conn.prepareStatement("INSERT INTO adoption_history (first_name, last_name, puppy_breed, puppy_gender, puppy_name) VALUES (?, ?, ?, ?, ?)");

                recordsStatement.setString(1, first_name);
                recordsStatement.setString(2, last_name);
                recordsStatement.setString(3, breed);
                recordsStatement.setString(4, puppy_gender);
                recordsStatement.setString(5, puppy_name);
                recordsStatement.executeUpdate();


                //If the user wants records
            } else if (goal.equals("records")) {
                System.out.println("Here's our adoption history:");
                validResponse = true;
                AdoptionHistoryDAO records = new AdoptionHistoryDAO();
                records.getAdoptionHistory();
            }


            //If the user doesn't choose records or adopt
            else {
                System.out.println("Oops, I didn't catch that. You can say 'adopt' or 'records'.");
                goal = scanner.nextLine();
            }
        } while (!validResponse);

    }

}
