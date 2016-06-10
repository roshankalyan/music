/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayCreator;

import FileMangement.PathFinder;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3utools.M3UPlaylist;
import m3utools.M3UTrack;
import programming.pkg3.coursework.Programming3Coursework;

/**
 *
 * @author roshan
 */
public class M3u_to_array {

    int Number_of_tracks = 0;
  Path [] ListOfFilesForReturn;

    public Path[] M3uPasserTool(Path listOfFiles,PathFinder MainCaller) {
        int i = 0;
       

        boolean IsValidCheck = m3utools.M3UReader.isValidHeader(listOfFiles.toAbsolutePath().toString());
        
        if (IsValidCheck == true) {
            Number_of_tracks = m3utools.M3UReader.getNumberOfTracks(listOfFiles.toAbsolutePath().toString());
            M3UPlaylist current = m3utools.M3UReader.getPlaylist(listOfFiles.toFile());

            List<M3UTrack> a = current.getTracks();
            ListOfFilesForReturn = new Path[a.size()];
            while (i < a.size()) {
                M3UTrack tester = a.get(i);
                Path Conveted = Paths.get(tester.getTrackFilename());
             ListOfFilesForReturn[i]=Conveted;
                i++;
            }

        } else {
            System.out.print(listOfFiles.getFileName().toString() + " is not a valid playlist file\nPlease select new PlayList");
             Programming3Coursework a = new Programming3Coursework();
            try {
                a.M3UMenu(MainCaller);
            } catch (IOException ex) {
                Logger.getLogger(M3u_to_array.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return ListOfFilesForReturn;
    }
    
    public int ReturnNumberOfTracks(){
        return Number_of_tracks;
    }

}
