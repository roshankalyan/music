package FileMangement;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Finder
        extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;
    private int numMatches = 0;
    private int iteratorforFileArray = 0;
    private int finalTotal;
    private Path[] listOfPaths = new Path[99999999];
    private int iteratorIfLoop = 0;

    Finder(String pattern) {
        matcher = FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern);
    }

    // Compares the glob pattern against
    // the file or directory name.
    Path find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            listOfPaths[numMatches] = file;
            numMatches++;
       //    System.out.println(file);

            return file;
        } else {
            return null;
        }

    }

    // Prints the total number of
    // matches to standard out.
    int done(int finalTotal) {
        //System.out.println("Matched: "+ numMatches);
        finalTotal = finalTotal + numMatches;
        return finalTotal;
    }

    public Path[] returnArray() {
        return listOfPaths;

    }

    // Invoke the pattern matching
    // method on each file.
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) {
        find(file);
        return CONTINUE;
    }

    // Invoke the pattern matching
    // method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
        //            System.err.println(exc);
        return CONTINUE;
    }
}
