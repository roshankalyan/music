/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileMangement;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class PathFinder {

    private static int finalTotal = 0;
    public Path[] listOfPaths = null;
    
    
    @SuppressWarnings("empty-statement")
    public Path[] FileCreator(String filename,boolean m3uCheck)
            throws IOException {

        File paths = new File(filename);
        String[] pattern;
        
        if (m3uCheck != true){
            pattern = patternCreator.patternCreator(true, false, false, false,1);
        }else{
            pattern = new String[1];
            pattern[0] = "*.m3u";
        }
        
       
      
        String str = paths.toString();
        String slash = "\\";
       
      
                
        String s = new StringBuilder(str).append(slash).toString();
        Path startingDir = Paths.get(s);

        int i = 0;
        while (i < pattern.length) {
            Finder finder = new Finder(pattern[i]);
            Files.walkFileTree(startingDir, finder);

            listOfPaths = ArrayUtils.addAll(listOfPaths, NullCleaner(finder.returnArray()));
            finalTotal = finder.done(finalTotal);
            i++;
        }
       
        
    //    StringBuffer sb = new StringBuffer(listOfPaths[1].getFileName().toString());
      //  sb.delete(sb.length()-4,sb.length()) ;
        
     //  System.out.println(sb);
        
        
      //  System.out.println(Arrays.toString(listOfPaths));

     //   System.out.println("Total Matched Number of Files : " + finalTotal);
      
return listOfPaths;
    }
    
    public int   returnfinalTotal(){
        return finalTotal;
    }

    public  Path[] returnArray(){
        return listOfPaths;
    }
    
       public void setArray(Path[] listOfPaths){
          listOfPaths = this.listOfPaths;
    }
    
    public static Path[] NullCleaner(Path[] test) {
        int i = 0;
        int nullAmount = 0;
        while (i < test.length) {
            if (test[i] == null) {
                nullAmount++;
                i++;
            } else {
                i++;
            }
        }
        Path[] cleanArray = Arrays.copyOf(test, test.length - nullAmount);
        return cleanArray;
    }

}
