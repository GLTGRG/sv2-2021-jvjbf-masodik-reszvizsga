package algorithms;

import java.util.ArrayList;
import java.util.List;


public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word){
        if (word.contains(" ")){
            throw new IllegalArgumentException("It should be one word!");
        } else if (!word.toLowerCase().equals(word)){
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (String s : words) {
            if (!words.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
