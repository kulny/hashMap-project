/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author Cody
 */
public class FileEditMethods {
    //PROGRAM FLOW
    //nFileName(); USES ACCESSOR METHOD setPath(String intendedPath); TO SET private String intendedPath; ACCORDING TO USER INPUT OF FILENAME
    //ONCE THIS IS SET, METHODS CREATE, WRITE, OR READ CAN BE IMMEDIATELY CALLED
    
    Scanner scan = new Scanner (System.in);
    
    private String intendedPath;
    private String intendedDirectory = "D:\\javaproject\\"; //pretty sure there's a way to do this without needing to set a directory. some call parents method acted on the final path or something
    private static final Charset CHARSET = Charset.defaultCharset();
    
    // makes the file based on what the file name should be
    public boolean makeFile() {
        
        //creates path variable for use in creating file or directories
        Path path = Paths.get(intendedPath);
        
        
        // lets user know if file is created
        if (!Files.exists(path)) {
            System.out.println("Creating the file...");
        }
        
        //create parent directories of path
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException x) {
            System.err.format("CreateDirectory error: %s%n", x);
        }
        
        //create file 
        try {
            Files.createFile(path);
        //} catch (FileAlreadyExistsException x) {
            //System.err.format("File named %s" + " already exists%n", path);
        } catch (IOException x) {
            System.err.format("createFile error: %s%n", x);
        }
        
        return Files.exists(path);
    }
    
    // asks for user input on file name then uses accessor method setPath() to prep it for anything
    // else that might use it 
    //v2
    public void nFileName() {
        
        
        System.out.format("Please choose a filename.%n");
        String fileName = scan.nextLine();
        
        if (fileName.endsWith(".txt") == false) {
            setPath(intendedDirectory + fileName + ".txt");
        } else {
            setPath(intendedDirectory + fileName);
        }
    }
    //accessor method to make it easy to overwrite used path variable
    public void setPath(String desiredPath) {
        intendedPath = desiredPath;
    }
    public void setDirectory(String desiredDir) {
        intendedDirectory = desiredDir;
    }
    //writes to file given String parameter
    public void write(String toFile) {
       Path path = Paths.get(intendedPath);
       
       File file = new File(intendedPath);

       if (file.length() == 0) {

           try (BufferedWriter writer = Files.newBufferedWriter(path, CHARSET)) {
               writer.write(toFile + System.lineSeparator());
           } catch (IOException x) {
               System.err.format("IOException: %s%n", x);
           }
       }
       else {

           try (BufferedWriter writer = Files.newBufferedWriter(path, CHARSET, StandardOpenOption.APPEND)) {
               writer.append(toFile);
               writer.append(System.lineSeparator());  // IMPLEMENT writer.newLine(); to create command line printable \n but not text file readable \n
           } catch (IOException x) {                    // in case of desire to read the text file through OS GUI rather than print to console or w/e
               System.err.format("IOException: %s%n", x);
           }
       }
    }
    //reads from file
    public void read() {
        Path path = Paths.get(intendedPath);
        
        if (Files.exists(path)) {
        
            try (BufferedReader reader = Files.newBufferedReader(path, CHARSET)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
    
    public void delete() {
        
        Path path = Paths.get(intendedPath);
        File file = new File(intendedPath);
        
        if (!file.exists()) {
            System.out.println("File does not exist, and cannot be deleted.");
            return;
        }
        
        
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // catches file permission issues
            System.err.println(x);
        }
        
        if (!file.exists()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File could not be deleted.");
        }
    }
    
    public void changeDir() {


    // use File.separator
    String newDir = scan.next();

    File file = new File(newDir);
    if (file.isDirectory()) {
        setDirectory(newDir);
        scan.nextLine(); // clears hanging line end or w.e
    } else {
        System.out.format("That is not a valid directory.%n"
        + "Please choose a valid directory.%n");
        changeDir();
    }
    
    }
}