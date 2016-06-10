/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import static Scrappers.Search.YoutubeSearcher;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.StandardArtwork;

/**
 *
 *
 * /**
 *
 * @author roshan
 */
public class JaudioTagger {

    public static String returnArtistName(Path DirectPath) {
        File file = new File(DirectPath.toString());

        String artist = null;
        try {
            MP3File f = (MP3File) AudioFileIO.read(file);
            AudioHeader audioHeader = f.getAudioHeader();

            artist = f.getTag().getFirst(FieldKey.ARTIST);

            //System.out.print(f.getID3v1Tag().getFirstArtist());
            int seconds = audioHeader.getTrackLength();
            //System.out.println("track duration of "+ testFile.getName() + " is " + seconds + " seconds.");
        } catch (IOException | CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException f) {
         //   System.out.println("couldn't open testFile");
            //  Logger.getLogger(JaudioTagger.class.getName()).log(Level.SEVERE, null, f);
        }

        return artist;
    }

    public static void setArtistName(String Artist, File file) {
        try {
            AudioFile changed = AudioFileIO.read(file);
            Tag tagger = changed.getTag();
            tagger.setField(FieldKey.ARTIST, Artist);
            changed.commit();
        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | CannotWriteException ex) {
            Logger.getLogger(JaudioTagger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void setMusicBrainzInfo(String ArtistID, File file){
        try {
            AudioFile changed = AudioFileIO.read(file);
            Tag tagger = changed.getTag();
            tagger.setField(FieldKey.MUSICBRAINZ_RELEASE_GROUP_ID, ArtistID);
            changed.commit();
            
 
        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | CannotWriteException ex) {
            Logger.getLogger(JaudioTagger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void setArt(File file,String Artist){
        
       
        try {
            AudioFile url = AudioFileIO.read(file);
            
            String screenShot = YoutubeSearcher(Artist,0);
            
            Tag tagger = url.getTag();
            Artwork a = new StandardArtwork();
            a.setImageUrl(screenShot);
            tagger.setField(a);
            url.commit();
            
            
        } catch (FieldDataInvalidException ex) {
            Logger.getLogger(JaudioTagger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotReadException | IOException | ReadOnlyFileException | InvalidAudioFrameException | TagException | CannotWriteException ex) {
            Logger.getLogger(JaudioTagger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
}
