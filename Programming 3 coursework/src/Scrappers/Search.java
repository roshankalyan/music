/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

/**
 *
 * @author roshan
 */
/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
import UI.AutoRedirectToVideo;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import java.io.IOException;
import java.util.List;

/**
 * Print a list of videos matching a search term.
 *
 * @author Jeremy Walker
 */
public class Search {

    private static final long NUMBER_OF_VIDEOS_RETURNED = 5;

    private static YouTube youtube;

    public static String YoutubeSearcher(String searchTerm, int i) {
        // Read the developer key from the properties file.

        try {
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // Prompt the user to enter a query term.
            if (searchTerm.contentEquals("Wortrausch - Sommerzeit (Doppelzeit) - (Live)"))
            {
                searchTerm = "Wortrausch - Sommerzeit Dauerschleife Live";
            }
            
            
            String queryTerm = searchTerm;

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            String apiKey = "AIzaSyAMnuPkixjDQYvfuNGCS_-Hy0aTuZ1GusA";
            search.setKey(apiKey);
            search.setQ(queryTerm);

            search.setType("video");

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
             SearchResult a =       searchResultList.get(0);
             String thumbnail =  a.getSnippet().getThumbnails().getDefault().toString();
              
             String url = thumbnail.substring(31,  thumbnail.length()-14);
            
             if(i == 1){
             String completeURL = "https://www.youtube.com/watch?v="+url;
             AutoRedirectToVideo.OpenYoutubeLink(completeURL);
             }
           
           String thumbnails = (String) thumbnail.subSequence(8,thumbnail.length()-2);
            //System.out.printf(thumbnails);
           
           
             return thumbnails;
        } catch (GoogleJsonResponseException e) {
            
        } catch (IOException e) {
            
        } catch (Throwable t) {
            
        }
        
        return null;
    }

  
    
}
