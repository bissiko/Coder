package serhii.ost.coder.languages;

import java.util.ArrayList;

import static serhii.ost.coder.constants.Constants.CHARS_EN;
import static serhii.ost.coder.constants.Constants.CHARS_UA;

public class LangDetect {
    public boolean isCyrillic(String text) {
        for (char c : text.toCharArray()) {
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.CYRILLIC) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Character> charsPackGet (String text) {
        if (isCyrillic(text)) {
            return CHARS_UA;
        } else {
            return CHARS_EN;
        }

    }
}
