/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrappers;

import java.net.MalformedURLException;
import java.net.URL;
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
public class SearchTest {
    
    public SearchTest() {
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
     * Test of YoutubeSearcher method, of class Search.
     * @throws java.net.MalformedURLException
     */
    @Test
    public void testYoutubeSearcher() throws MalformedURLException {
        System.out.println("YoutubeSearcher");
        String searchTerm = "The Temptations - My Girl";
        int i = 0;
        String expResult = "https://i.ytimg.com/vi/6IUG-9jZD-g/default.jpg";
        String result = Search.YoutubeSearcher(searchTerm, i);
        assertEquals(expResult, result);  
    }
    
}
