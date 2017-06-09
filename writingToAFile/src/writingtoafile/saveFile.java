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
        
        //creates path variable for use in creating file or directories
        Path path = Paths.get(desiredPath);
        
        //create parent directories of path
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException x) {
            System.err.format("CreateDirectory error: %s%n", x);
        }
        
        //create file 
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
        
        System.out.format("Please choose a filename.%n" + "D:\\javaproject\\");
        
        String directory = "D:\\javaproject\\" + scan.next() + ".txt";
        return directory;
        
    }
    /* TODO
    REMOVE .TXT SO USER CAN INPUT NAMEX.TXT AND IT DOESNT HAVE .TXT.TXT
    ADD INPUT FEATURES
    THEN ADD READING
    THEN ADD RETRIEVAL FEATURES
    */
}
