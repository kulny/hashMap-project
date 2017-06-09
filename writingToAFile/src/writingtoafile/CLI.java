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
        saveFile save = new saveFile();
        
        
        String input = scan.next();
        
        
        while(true) {
            if (null == input) {
                System.out.println("That is not a valid command.");
                
            } else switch (input) {
                case "1":
                    save.makeFile(save.fileName());
                    break;
            // ------------------------ ADD READ FILE FUNCTIONALITY -----------------------
                case "2":
                    break;
            // ------------------------ ADD WRITE TO FILE FUNCTIONALITY -------------------
                case "3":
                    break;
                default:
                    System.out.println("That is not a valid command.");
                    break;
            }
        }
    }
}
