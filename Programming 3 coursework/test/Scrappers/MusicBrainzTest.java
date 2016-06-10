/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import static Scrappers.MusicBrainz.search_for_artistID;
import java.net.MalformedURLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.musicbrainz.MBWS2Exception;

/**
 *
 * @author roshan
 */
public class MusicBrainzTest {
        public MusicBrainzTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
      @Test
    public void testsearch_for_artistID() throws MBWS2Exception{
        System.out.println("earch for artist unique id");
        String searchTerm = "The weekend";
        String expResult = "ea3c48bd-6d3c-4039-89eb-fd839f6f98cd";
        String result = search_for_artistID(searchTerm);
        assertEquals(expResult, result);  
        
        
        System.out.println("earch for artist unique id");
         searchTerm = "The Weeknd (R&B singer)";
         expResult = "c8b03190-306c-4120-bb0b-6f2ebfc06ea9";
        result = search_for_artistID(searchTerm);
        assertEquals(expResult, result);  
        
        
        
    }
}
