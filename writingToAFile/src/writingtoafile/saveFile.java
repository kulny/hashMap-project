/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Cody
 */
public class saveFile {
    public boolean makeFile(String desiredPath) {
        
        Path path = Paths.get(desiredPath);
        
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException x) {
            System.err.format("File named %s" + " already exists%n", path);
        } catch (IOException x) {
            System.err.format("createFile error: %s%n", x);
        }
        
        return Files.exists(path);
    }
    
    public String fileName() {
        Scanner scan = new Scanner(System.in);
        
        System.out.format("Please choose a place to save the file.%n" + 
                "Normal directory is D:\\testfolder\\CHOOSE FILE NAME HERE for now.%n");
        
        String directory = scan.next();
        return directory;
        
    }
    /* TODO
    ADD CHOOSE FILE NAME FUNCTIONALITY
    ADD INPUT FEATURES
    THEN ADD READING
    THEN ADD RETRIEVAL FEATURES
    */
}
