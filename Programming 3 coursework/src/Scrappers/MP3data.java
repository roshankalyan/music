/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import javazoom.jl.player.Player;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;

/**
 *
 * @author roshan
 */
public class MP3data {

    public static int getSeconds(Path DirectPath) {
        File file = (DirectPath.toFile());
         int duration = 0;
        try {

            FileInputStream fis = new FileInputStream(file);

            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);

           

            AudioFile audioFile = AudioFileIO.read(file);
            duration = audioFile.getAudioHeader().getTrackLength();

        //    int numberOfMinutes = ((duration % 86400) % 3600) / 60;
         //   int  numberOfSeconds = ((duration % 86400 ) % 3600 ) % 60  ;
            //System.out.print("time in milliseconds=   " + numberOfMinutes + ":"+ numberOfSeconds);
                
           
            
            //player.play();
        } catch (Exception e) {

            System.out.print("ERROR " + e);
        }
    return duration;
    }

}
