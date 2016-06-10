/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.pkg3.coursework;

import ArrayCreator.ListToContructorArray;
import Constructor.MetaData;
import FileMangement.PathFinder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Scrappers.Search;
import UI.FileSelector;
import java.util.Scanner;
import ArrayCreator.M3u_to_array;
import Scrappers.JaudioTagger;
import java.nio.file.Path;
import Scrappers.Search;

/**
 *
 * @author k1116774
 */
public class Programming3Coursework {

    MetaData[] listOfFiles = null;
    boolean M3u = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating new Object 
        Programming3Coursework a = new Programming3Coursework();
        //Object A running Menu function
        a.First();

    }

    public void First() {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Would you like to View playlists Or View music files ?\n");
        System.out.print("Press 1 View playlists\n");
        System.out.print("Press 2 View music files\n");
        int myint = keyboard.nextInt();

        try {
            PathFinder MainCaller = new PathFinder();
            if (myint == 2) {
                Mp3Menu(MainCaller);
            }
            if (myint == 1) {
                M3UMenu(MainCaller);
            }
        } catch (IOException ex) {
            Logger.getLogger(Programming3Coursework.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Mp3Menu(PathFinder MainCaller) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        M3u = false;
        MainCaller.setArray(MainCaller.FileCreator(FileSelector.FileChooser(), M3u));
        ListToContructorArray convertor = new ListToContructorArray();
        listOfFiles = convertor.a1Dto2D(MainCaller.returnArray(), MainCaller.returnfinalTotal());

        System.out.println("add music art or view youtube video?\nPress 1 for add music art \nPress 2 for youtube video");
        int choice = keyboard.nextInt();
        if (choice == 1) {

            System.out.println("Please enter the Id of the track");
            int i = keyboard.nextInt();
            JaudioTagger.setArt(listOfFiles[i].ReturnPath().toFile(), listOfFiles[i].returnSongName());
        } else {
            System.out.print(" Please enter the track id you wish to play on youtube\n");
            int youtubeID = keyboard.nextInt();
            Youtube(youtubeID);
        }
    }

    public void M3UMenu(PathFinder MainCaller) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        MainCaller.setArray(MainCaller.FileCreator(FileSelector.FileChooser(), M3u));
        int i = 0;
        Path[] listOfPaths = MainCaller.returnArray();
        while (i < listOfPaths.length) {
            System.out.println(i);
            System.out.println(listOfPaths[i] + "\n");
            i++;
        }

        System.out.println("Which Playlist would you like to view?");
        int m3u = keyboard.nextInt();
        M3u_to_array a = new M3u_to_array();
        ListToContructorArray convertor = new ListToContructorArray();
        listOfFiles = convertor.a1Dto2D(a.M3uPasserTool(listOfPaths[m3u], MainCaller), a.ReturnNumberOfTracks());
        System.out.println("Play Playlist or view youtube video?\nPress 1 for Playlist\nPress 2 for view single video on youtube");
        int choice = keyboard.nextInt();
        if (choice == 1) {
            i = 0;
            while (i < listOfFiles.length) {

                Youtube(i);
                try {
                    Thread.sleep(listOfFiles[i].getSeconds() * 1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                i++;
            }
        } else {
            System.out.print(" Please enter the track id you wish to play on youtube\n");
            int youtubeID = keyboard.nextInt();
            Youtube(youtubeID);
        }
    }

    public void Youtube(int youtubeID) {
        String searchVariable = listOfFiles[youtubeID].returnArtist() + " - " + listOfFiles[youtubeID].returnSongName();
        Search.YoutubeSearcher(searchVariable, 1);
    }

}
