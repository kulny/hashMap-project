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
    
    String intendedPath;
    
    
    //makes the file based on what the file name should be
    public boolean makeFile() {
        
        //creates path variable for use in creating file or directories
        Path path = Paths.get(intendedPath);
        
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
    // asks for user input on file name then uses accessor method setPath() to prep it for anything
    //else that might use it
    
    public boolean fileName() {
        Scanner scan = new Scanner(System.in);
        
        System.out.format("Please choose a filename.%n" + "D:\\javaproject\\");
        
        setPath("D:\\javaproject\\" + scan.next() + ".txt");
        return true;
        
    }
    //accessor method to make it easy to overwrite used path variable
    public void setPath(String desiredPath) {
        intendedPath = desiredPath;
        
    }
    
    public String pathProvide() {
        return intendedPath;
    }
}
