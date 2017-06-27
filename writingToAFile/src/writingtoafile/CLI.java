/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Cody
 */
public class CLI {
    
    FileEditMethods fem = new FileEditMethods();
    Scanner scan = new Scanner(System.in);
    
    public void CLIChoices() {


        System.out.format("Please choose an operation:%n" + 
                "   1: Make File --- creates an empty file%n" + 
                "   2: Read File %n" + 
                "   3: Write File --- writes to a file, and creates it if it does not exist yet%n" +
                "   4: Delete File%n" +
                "   5: More Options%n");
        
        String input = scan.next();
        
        
        switch (input) {
            case "1":
                fem.FileName();
                fem.makeFile();
                break;
            case "2":
                fem.FileName();
                fem.read();
                break;
            case "3":
                fem.FileName();
                writeThis();
                break;
            case "4":
                fem.FileName();
                fem.delete();
                break;
            case "5":
                System.out.format("Please choose an operation:%n" + 
                "   1: Change Directory %n");
                
                input = scan.next();
                
                switch (input) {
                    case "1":
                        System.out.println("Where would you like the file to be saved?");
                        fem.changeDir();
                        break;
                        
                    // ADD MORE CASES AS NECESSARY FOR ADDITIONAL SUB-FEATURES HERE ---------
                    default:
                        System.out.println("That is not a valid command.");
                        break;
                }
                
                break;
                
            default:
                System.out.println("That is not a valid command.");
                break;
        }
        System.out.println("Would you like to use another command? Y/N");
        // recursive call of the CLI for loop
        String response = scan.next();
        
        if (response.equalsIgnoreCase("Y") || (response.equalsIgnoreCase("yes"))) {
            CLIChoices();
        }
    }
    public void writeThis() {
        
        System.out.println("What would you like to write?");
        scan.nextLine(); // clears a hanging line separator or whatever caused by previous calls
        String toFile = scan.nextLine(); // of scan.next();
        
        fem.write(toFile);
        
        writeMore();
    }
    
    public void writeMore() {  // continues writing if user wants, also allows continued input without
        System.out.println("Would you like to write more? Y/N"); // ignoring further command prompts
        String response = scan.next();
        
        if (response.equalsIgnoreCase("y") || (response.equalsIgnoreCase("yes"))) {
           writeThis();
        } else if (response.equalsIgnoreCase("n") || (response.equalsIgnoreCase("no"))) {
            return;
        } else {
           fem.write(response);
           writeMore();
        }
    }
    
}