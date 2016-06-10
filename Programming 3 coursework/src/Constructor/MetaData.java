/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructor;

import java.nio.file.Path;

/**
 *
 * @author roshan
 */
public class MetaData{

    private  int Id;
    private String FullTrackName;
    private Path Filepath;
    private float popularity;
    private String Artist;
    private String SongName;
    private String AlbumName;
    private int seconds;
    
    public void MetaData(int id, String name, Path filePath){

        this.Id = id;
        this.FullTrackName = name;
        this.Filepath = filePath;

    }

    public int ReturnID() {

        return Id;
    }

    public String ReturnName() {
        return FullTrackName;
    }

    public Path ReturnPath() {
        return Filepath;
    }

    public void setID(int id) {
        Id = id;
    }

    public void setName(String name) {
       FullTrackName = name;
    }

    public void setPath(Path filepath) {
       Filepath = filepath;
    }
  
    
    
    public void setpopularity(float Popularity ){
        popularity = Popularity;
    }
    
    public float returnpopularity(){
        return popularity;
    }
    
    public void setArtist(String artist ){
        Artist = artist;
    }
    
      public String returnArtist(){
        return Artist;
    }
    
          public void setSongName(String songName ){
        SongName = songName;
    }
    
      public String returnSongName(){
        return SongName;
    }
      
      public void setAlbumName(String albumName){
          AlbumName = albumName;
      }
      
      public String returnAlbumName(){
          return AlbumName;
      }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    

}
