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
    
    
    
    private String intendedPath;
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
        Scanner scan = new Scanner (System.in);
        
        System.out.format("Please choose a filename.%n" + "D:\\javaproject\\");
        
        String fileName = scan.next();
        
        if (fileName.endsWith(".txt") == false) {
            setPath("D:\\javaproject\\" + fileName + ".txt");
        } else {
            setPath("D:\\javaproject\\" + fileName);
        }
    }
    //accessor method to make it easy to overwrite used path variable
    public void setPath(String desiredPath) {
        intendedPath = desiredPath;
        
    }
    
    //writes to file
    public void write() {
       Path path = Paths.get(intendedPath);
       
       File file = new File(intendedPath);
       Scanner scan = new Scanner(System.in);

       System.out.println("What would you like to write?");
           
       String toFile = scan.nextLine();
       
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
       
       System.out.println("Would you like to write more? Y/N");
       String response = scan.next();
       if (response.equalsIgnoreCase("y") || (response.equalsIgnoreCase("yes"))) {
           write();
       }
       
    }
    //reads to file
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
}
