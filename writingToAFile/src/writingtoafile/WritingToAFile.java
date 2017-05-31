/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.nio.file.*;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Cody
 */
public class WritingToAFile {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        
        
        
        // REFERENCE CODE
        
        Path path = Paths.get("D:\\testfolder\\test.txt");
        
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException x) {
            System.err.format("File named %s" + " already exists%n", path);
        } catch (IOException x) {
            System.err.format("createFile error: %s%n", x);
        }
    }
   
}
