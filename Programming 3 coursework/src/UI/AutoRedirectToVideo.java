/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 *
 * @author roshan
 */
public class AutoRedirectToVideo {

    public static void OpenYoutubeLink(String URL) throws URISyntaxException{
        
      
final URI uri = new URI(URL);


    open(uri);

    }
    
private static void open(URI uri) 
{
    if (Desktop.isDesktopSupported()) 
    {
      try 
      {
        Desktop.getDesktop().browse(uri);
      }
      catch (IOException e) 
      { /* TODO: error handling */ }
    }
    
  }


  }
