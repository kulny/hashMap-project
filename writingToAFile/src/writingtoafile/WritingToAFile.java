/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writingtoafile;

/**
 *
 * @author Cody
 */
public class WritingToAFile {

    public static void main(String[] args) {
        
        readProperties rp = new readProperties();
        CLI cli = new CLI();
        FileEditMethods fem = new FileEditMethods();
        
        rp.loadProperties();
        
        cli.CLIChoices();

    }
   
}
