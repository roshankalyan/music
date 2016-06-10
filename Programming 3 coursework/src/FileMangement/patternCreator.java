/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileMangement;

/**
 *
 * @author roshan
 */
public class patternCreator {
        public static String[] patternCreator(boolean mp3, boolean wma, boolean acc, boolean flac,int j) {

        String[] pattern;
        pattern = new String[j];
        int i = 0;

        if (mp3 == true) {
            pattern[i] = "*.mp3";
            i++;
        }
        if (wma == true) {
            pattern[i] = "*.wma";
            i++;
        }
        if (acc == true) {
            pattern[i] = "*.acc";
            i++;
        }
        if (flac == true) {
            pattern[i] = "*.flac";
            i++;
        }

        return pattern;

    }
    
}
