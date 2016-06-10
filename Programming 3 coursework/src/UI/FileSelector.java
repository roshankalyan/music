/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.*;

/**
 *
 * @author roshan
 */
public class FileSelector {
    
    
   


    public static String FileChooser()
    {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);

      
        System.out.println(f.getSelectedFile());
        
        String absolutePath = f.getSelectedFile().getAbsolutePath();
        return  absolutePath;
    }      
}
    


            
        
