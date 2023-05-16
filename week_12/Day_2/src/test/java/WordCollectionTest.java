import Arrays.WordCollection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class WordCollectionTest {

    private WordCollection myWords;

    @Before
    public void before(){
        myWords = new WordCollection();
    }

    @Test
    public void canGetWordCount(){
        assertEquals(5, myWords.getWordCount());
    }
}