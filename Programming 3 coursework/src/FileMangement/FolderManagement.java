/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileMangement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author roshan
 */
public class FolderManagement {
    
    public static void test(String paths){
        
        Path path =Paths.get(paths);
        
         Path p =   path.toAbsolutePath();
                 
         
         
        
        System.out.print(p);
        
       // File dir = new File("a");
      //  dir.mkdir();
    }
    
}
