/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.util.Scanner;

/**
 *
 * @author Cody
 */
public class CLI {
    
    public void CLIChoices() {
        // 1 make file
        // 2 read file
        // 3 write to file
        
        System.out.format("Please choose an operation:%n" + 
                "   1: Make File%n" + 
                "   2: Read File%n" + 
                "   3: Write File%n");
        
        Scanner scan = new Scanner(System.in);
        FileEditMethods fem = new FileEditMethods();
        
        
        String input = scan.next();
        
        
        switch (input) {
            case "1":
                fem.nFileName();
                fem.makeFile();
                break;
            case "2":
                fem.nFileName();
                fem.read();
                break;
            case "3":
                fem.nFileName();
                fem.write();
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
}