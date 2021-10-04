package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {


    public static void isEnglishWord(String letters) throws IOException {
        String newLetters = letters.toLowerCase();
        Map<Character, Integer> lettersCountMAp = getCharacterCountMap(newLetters);

        // read dictionary file using buffer reader by passing the path inside the constructor
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/EnglishWords"));
        //go every line of the english word using a loop the line using a bufferReader

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);

            boolean canMakeCurrentWord = true;
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharaCount = lettersCountMAp.containsKey(character) ? lettersCountMAp.get(character) : 0;

                if (currentWordCharCount > lettersCharaCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }

            if (canMakeCurrentWord) {
                System.out.println(currentWord);
            }

        }
        reader.close();
    }

    // //get each of the character and count how many of them is build the string
    public static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();
        //loop through the string of the letter and count how many of the character are available
        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);
            //set the right count of that letter already have count or not
            int count = lettersCountMap.containsKey(currentChar) ? lettersCountMap.get(currentChar) : 0;
            //then we make our count one more than the count before we have in the current char
            lettersCountMap.put(currentChar, count + 1);
        }

        return lettersCountMap;
    }

}
