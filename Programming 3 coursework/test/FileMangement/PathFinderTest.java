/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileMangement;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
public class PathFinderTest {

    public PathFinderTest() {
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
     * Test of FileCreator method, of class PathFinder.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFileCreator() throws Exception {
        System.out.println("FileCreator");
        String filename = "K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A";
        boolean m3uCheck = false;
        PathFinder instance = new PathFinder();
        Path[] expResult = new Path[9];
        expResult[0] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\After Many Days\\Cannibal Eyes.mp3");
        expResult[1] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Anshlavs - Second Trip.mp3");
        expResult[2] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\DARKPOP BAND ANGELIQUE - PERFECT WORLD (AMBIENT).mp3");
        expResult[3] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Freak Fandango Orchestra\\Freak Fandango Orchestra - No means no.mp3");
        expResult[4] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Gem Reflection - Tubeman.mp3");
        expResult[5] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\IX - la chichonera.mp3");
        expResult[6] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Omnibrain - Neverending.mp3");
        expResult[7] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Orxata Sound System\\als nous amos.mp3");
        expResult[8] = Paths.get("K:\\Teaching Materials\\CI\\CI6110\\test-data\\collection-A\\Orxata Sound System\\fuster meets guevara.mp3");
       

        Path[] result = instance.FileCreator(filename, m3uCheck);
        System.out.print(Arrays.toString(result));
        assertArrayEquals(expResult, result);

    }

}
