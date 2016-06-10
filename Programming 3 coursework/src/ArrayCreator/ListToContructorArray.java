/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayCreator;

import Constructor.MetaData;
import Scrappers.JaudioTagger;
import Scrappers.MP3data;
import java.io.File;

import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author roshan
 */
public class ListToContructorArray {

    public MetaData[] a1Dto2D(Path[] initial, int finalTotal) {
        int interator = 0;
        String a;
        MetaData[] YayArrays = new MetaData[finalTotal];

        while (interator < finalTotal) {

            Path c = initial[interator];
            a = c.getFileName().toString();

            StringBuffer sb = new StringBuffer(a);
            sb = sb.delete(sb.length() - 4, sb.length());
            String name = sb.toString();
            MetaData b = new MetaData();
            b.setID(interator);
            b.setName(name);
            b.setPath(initial[interator]);

            boolean ArtistCheck = name.contains("-");

            if (ArtistCheck == false) {
                System.out.print("NO ARTIST NAME found on track \n" + initial[interator]);

                String metaDataName = (JaudioTagger.returnArtistName(initial[interator]).trim());

                if (metaDataName.equalsIgnoreCase("")) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("\n Enter ARTIST NAME: \t ");
                    String sentence = scanner.nextLine();
                    File file = initial[interator].toFile();
                    JaudioTagger.setArtistName(sentence, file);
                    metaDataName = sentence;
                } else {
                    System.out.print("\nSearching... \n");
                    System.out.print("Searching under tables \n");
                   
                    System.out.print("(╯°□°）╯︵ ┻━┻ \n");
                    
                    System.out.print("Program has found metadata! \n");
                    System.out.print("Program has found ARTIST NAME to be: " + metaDataName + "\n");
                }

                b.setArtist(metaDataName);
                b.setSongName(name);
            } else {
                String[] ArtistTracknameSplit = name.split(" - ", 2);
                
                if (ArtistTracknameSplit[1].contains("\\("))
                {
    
                     b.setSongName( ArtistTracknameSplit[1].replace("(", "").replace(")",""));
                   
                }else{ 
                    b.setSongName(ArtistTracknameSplit[1].trim());
                }
                b.setArtist(ArtistTracknameSplit[0].trim());
            }
            
            
            
            b.setAlbumName(name);
           
            
            b.setSeconds( MP3data.getSeconds(initial[interator]));
            
            YayArrays[interator] = b;
         // System.out.print(YayArrays[interator].returnArtist()+"\n");
            //  System.out.print(YayArrays[interator].returnSongName()+"\n");
            //    System.out.print(YayArrays[interator].ReturnName() +"\n");
            //  System.out.print(YayArrays[interator].ReturnPath()+"\n");
            // System.out.print(YayArrays[interator].ReturnID()+"\n");

            interator++;
        }
        int i = 0;
        while (i < YayArrays.length) {
            System.out.print("\n");
            System.out.print(YayArrays[i].ReturnID() + "\n");
            System.out.print(YayArrays[i].returnArtist() + "\n");
            System.out.print(YayArrays[i].returnSongName() + "\n");
            //System.out.print(YayArrays[i].ReturnName() +"\n");
            System.out.print(YayArrays[i].ReturnPath() + "\n");
             System.out.print(YayArrays[i].getSeconds()+"\n");

            i++;
        }
        return YayArrays;
    }

}
