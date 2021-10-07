import org.junit.jupiter.api.Test;
import utilities.Dictionary;
import java.io.IOException;

public class wordTest {


    @Test
    public void test() throws IOException {
        String letters = "working";
        System.out.println("Word possible to form using the given letter");
        Dictionary.isEnglishWord(letters);

    }
}

