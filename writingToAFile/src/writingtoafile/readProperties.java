/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;
import java.io.*;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Cody
 */
public class readProperties {
    
    Properties defProps = new Properties();
    Properties appProps = new Properties();
    
    public void loadProperties() {

        
        try (FileInputStream in = new FileInputStream("defaultWriteToFile.properties")) {
            defProps.load(in);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        

        
        try (FileInputStream in = new FileInputStream("writeToFile.properties")) {
            appProps.load(in);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        
    }
    
    public void saveProperties() {
        try (FileOutputStream newProperties = new FileOutputStream("writeToFile.properties")) {
            appProps.store(newProperties, "--no comment--");
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
    public String getProperties(String property) { //used only for to save default path for now
        return appProps.getProperty(property);
    }
    public void setProperties(String property, String value) {
        appProps.setProperty(property, value);
    }
    public void resetProperties(String property) {
        appProps.remove(property); // ---- NEEDS TESTING
    }
}
