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

    public static void main(String[] args) {
        
        saveFile save = new saveFile();
        writeToFile write = new writeToFile();
        
        save.fileName();
        save.makeFile();
        
        System.out.println(save.pathProvide());
        
        write.write();
        
        
        
    }
   
}
