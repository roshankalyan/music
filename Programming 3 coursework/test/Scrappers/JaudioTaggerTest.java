/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roshan
 */
public class JaudioTaggerTest {
    
    public JaudioTaggerTest() {
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

    /**
     * Test of returnArtistName method, of class JaudioTagger.
     */
    @Test
    public void testReturnArtistName() {
        System.out.println("returnArtistName");
        Path DirectPath = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Anshlavs - Second Trip.mp3");
        String expResult = "Anshlavs";
        String result = JaudioTagger.returnArtistName(DirectPath);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setArtistName method, of class JaudioTagger.
     */
    @Test
    public void testSetArtistName() {
        System.out.println("setArtistName");
        String Artist = "After Many Days";
        File file = new File("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\After Many Days\\Cannibal Eyes.mp3");
        JaudioTagger.setArtistName(Artist, file);
         String result = JaudioTagger.returnArtistName(file.toPath());
         assertEquals(Artist, result);
    }

    
}
