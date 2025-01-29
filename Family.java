/**
 * @purpose: Attempting to calculate the probability of the gender of children in the family by reading
 * a text file.
 *
 * @author Trisha Ganesh
 * @version 02/07/2021
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Family {

    public static void main(String[] args) throws IOException {
        //initialize
        double twoGirls = 0;
        double twoBoys = 0;
        double boyAndAGirl = 0;
        double theChanceOfABoy = 0;
        double theChanceOfAGirl = 0;
        double theChanceOfABoyAndGirl = 0;
        int counter = 0;

        String token = "";
        File fileName = new File("test2.txt");
        Scanner inFile = new Scanner(fileName);

        while (inFile.hasNext()) {
            token = inFile.next();
            if ((token.trim().length()) == 0)
                continue;
            if (token.trim().equals("GG")) {
                twoGirls++;
            } else if (token.trim().equals("BB")) {
                twoBoys++;
            } else {
                boyAndAGirl++;
            }
            counter++;
        }

        //calculate the chance of boy, girl, or both
        theChanceOfABoy = (twoBoys / counter) * 100;
        theChanceOfAGirl = (twoGirls / counter) * 100;
        theChanceOfABoyAndGirl = (boyAndAGirl / counter) * 100;

        //print to display output
        System.out.println("Composition statistics for families with two children.");
        System.out.println("\n");
        System.out.println("Total number of families: ");
        System.out.println(counter);
        inFile.close();

        System.out.println("\n");
        System.out.println("Number of families with");
        System.out.println("2 boys: " + (int)twoBoys + " represents " + theChanceOfABoy + "%");
        System.out.println("2 girls: " + (int)twoGirls + " represents " + theChanceOfAGirl + "%");
        System.out.println("1 boy and 1 girl: " + (int)boyAndAGirl + " represents " + theChanceOfABoyAndGirl + "%");
    }
}

