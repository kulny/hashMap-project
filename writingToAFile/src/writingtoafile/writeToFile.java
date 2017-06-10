/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.nio.charset.Charset;



/**
 *
 * @author Cody
 */
public class writeToFile {
    public void write() {
       saveFile save = new saveFile();
       String writeTarget = save.pathProvide();
       Path path = Paths.get(writeTarget);  // figure out lambdas or interfaces or something to pass the method as a parameter
       
       Scanner scan = new Scanner(System.in);
       
       Charset charset = Charset.defaultCharset();
       
       System.out.println("What would you like to write?");
       
       String toFile = scan.next();
        
       try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
           writer.write(toFile);
       } catch (IOException x) {
           System.err.format("IOException: %s%n", x);
       }
                   
    }
}
