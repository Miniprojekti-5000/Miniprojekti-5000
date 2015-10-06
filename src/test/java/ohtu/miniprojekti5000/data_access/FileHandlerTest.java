package ohtu.miniprojekti5000.data_access;

import ohtu.miniprojekti5000.domain.BookReference;
import ohtu.miniprojekti5000.domain.ReferenceInterface;
import org.junit.*;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

public class FileHandlerTest {
    private URL url;
    private static String filename;
    private static File file;
    private static FileHandler fileHandler;

    @BeforeClass
    public static void setUp() {
        filename = "doesnt_exist.bib";
        file = new File(filename);
        fileHandler = new FileHandler();
    }

    @Before
    public void deleteFileIfExists() {
        if(file.exists())
            file.delete();
    }

    @AfterClass
    public static void cleanUp() {
        if(file.exists())
            file.delete();
    }

    @Test
    public void loadingFileWithoutPathReturnsFalse() {
        assertFalse(fileHandler.loadFile(""));
    }

    @Test
    public void loadingFileThatDoesntExistsReturnsFalse() {
        assertFalse(fileHandler.loadFile(filename));
    }

    @Test
    public void gettingContentOfFileThatIsNotDefinedReturnsNull() {
        assertNull(fileHandler.getContent());
    }

    @Test
    public void writingToFileThatDoesntExistReturnsTrue() {
        ReferenceInterface book = new BookReference("heading", "author", "title", "publisher", "year");

        assertTrue(fileHandler.appendFile(filename, book));
    }

    @Test
    public void writingToFileThatDoesntExistReallyWritesToFile() {
        ReferenceInterface book = new BookReference("heading", "author", "title", "publisher", "year");

        fileHandler.appendFile(filename, book);

        assertNotNull(fileHandler.getContent());
    }
}
