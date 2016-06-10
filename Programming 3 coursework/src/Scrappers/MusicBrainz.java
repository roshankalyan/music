/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import java.util.Arrays;
import java.util.List;
import org.musicbrainz.DomainsWs2;
import org.musicbrainz.MBWS2Exception;
import org.musicbrainz.controller.Artist;
import org.musicbrainz.controller.Recording;
import org.musicbrainz.controller.Release;
import org.musicbrainz.controller.ReleaseGroup;
import org.musicbrainz.model.MediumListWs2;
import org.musicbrainz.model.TrackWs2;
import org.musicbrainz.model.entity.ArtistWs2;
import org.musicbrainz.model.entity.RecordingWs2;
import org.musicbrainz.model.entity.ReleaseGroupWs2;
import org.musicbrainz.model.entity.ReleaseWs2;
import org.musicbrainz.model.searchresult.RecordingResultWs2;
import org.musicbrainz.model.searchresult.ReleaseGroupResultWs2;
import org.musicbrainz.model.searchresult.ArtistResultWs2;
import org.musicbrainz.model.searchresult.ReleaseResultWs2;

/**
 *
 * @author roshan
 */
public class MusicBrainz {

    public static void search_for_albums(String artist_search_string) {
        ReleaseGroup release_group = new ReleaseGroup();
        String str = new String("creditname:" + artist_search_string);

        release_group.search(str);
        //release_group.search("date:1990-??-?? AND creditname:pink floyd");
        List<ReleaseGroupResultWs2> list_of_albums = release_group.getFirstSearchResultPage();

        int i = 0;
        for (ReleaseGroupResultWs2 album_result : list_of_albums) {
            ReleaseGroupWs2 album = album_result.getReleaseGroup();

            System.out.println(i + ": " + album.getTitle() + ", " + album.getYear());
            i++;
        }
    }

    public static String search_for_artistID(String artist_search_string) throws MBWS2Exception {
        String UniqueName = null;
        Artist search = new Artist();
        search.getSearchFilter().setLimit((long) 1);
        search.getSearchFilter().setMinScore((long) 50);
        search.search(artist_search_string);

        List<ArtistResultWs2> list_of_artist = search.getFirstSearchResultPage();

      //String[] possible_Artist_List= null;
        int i = 0;
        for (ArtistResultWs2 artist_result : list_of_artist) {
            ArtistWs2 artist = artist_result.getArtist();
            System.out.print("\n" + artist.getUniqueName());
            UniqueName = artist.getId();
            System.out.print(artist.getId());
            i++;

        }
        return UniqueName;
    }

    public static void search_for_recordings(String search_string) {
        Recording song = new Recording();
        song.getSearchFilter().setLimit((long) 30);
        song.search(search_string);
        List<RecordingResultWs2> list_of_recording_results = song.getFirstSearchResultPage();
        int i = 0;
        for (RecordingResultWs2 recording_result : list_of_recording_results) {
            RecordingWs2 recording = recording_result.getRecording();
            System.out.println(i + ": " + recording.getArtistCreditString() + ":");
            i++;
            List<ReleaseWs2> list_of_releases = recording.getReleases();
            int j = 0;
            for (ReleaseWs2 release : list_of_releases) {
                System.out.println("\t: " + release.getDateStr());
            }
        }
    }

    public static void search_for_Release(String TrackName, String Artist) {

        Release release = new Release();
        release.search(TrackName);
        List<ReleaseResultWs2> ListOfReleases = release.getFirstSearchResultPage();

        int i = 0;
        for (ReleaseResultWs2 releases : ListOfReleases) {
            ReleaseWs2 ReleaseListResult = releases.getRelease();
            String a = ReleaseListResult.getArtistCredit().toString();
            ReleaseListResult.getYear();

            if (a.equals(Artist)) {
                System.out.print(a);
                System.out.print(a);
                ReleaseListResult.getReleaseGroup().getRelations(Artist, Artist, null, Artist);
            }
        }
    }

    public static void search_for_Album(String artistName, String albumName) throws MBWS2Exception {

        String album_id = null;
        Artist artistsearch = new Artist();
        artistsearch.search(artistName);

        List<ArtistResultWs2> result = artistsearch.getFullSearchResultList();
        ArtistWs2 artist = new ArtistWs2();
        for (ArtistResultWs2 x : result) {
            if (x.getArtist().toString().equals(artistName)) {
                artist = x.getArtist();
                break;
            }
        }
        artistsearch = new Artist();
        artistsearch.lookUp(artist);
        List<ReleaseGroupWs2> release_groups = artistsearch.getFullReleaseGroupList();
        ReleaseGroupWs2 releasegroup = null;

        for (ReleaseGroupWs2 x : release_groups) {
            if (x.getTitle().equals(albumName)) {
                releasegroup = x;
            }
        }
        ReleaseGroup releasegroupsearch = new ReleaseGroup();
        releasegroupsearch.lookUp(releasegroup);
        List<ReleaseWs2> releases = releasegroupsearch.getFullReleaseList();
        ReleaseWs2 album = releases.get(0);
        Release releaselist = new Release();
        releaselist.lookUp(album);
        MediumListWs2 releaselist1 = releaselist.getComplete(album).getMediumList();
        List<TrackWs2> tracklist = releaselist1.getCompleteTrackList();
        System.out.println("artist: " + artist);
        System.out.println("album: " + album);
        System.out.println("title: " + tracklist.get(0).getRecording().getTitle());
        System.out.println("genre: " + tracklist.get(0).getRecording().getTags().get(0).getName());
        System.out.println("track: " + tracklist.get(0).getPosition());
        System.out.println("year: " + album.getYear());
        System.out.println("disc no.: " + releaselist1.getMedia().get(0));
        System.out.println("label: " + album.getLabelInfoString());
        System.out.println("artist sort : " + tracklist.get(0).getRecording().getArtistCreditString());
        System.out.println("comment: " + tracklist.get(0).getRecording().getDisambiguation());

    }
}
