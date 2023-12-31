package serhii.ost.coder.constants;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    public static final ArrayList<Character> CHARS_UA = new ArrayList<>(
            Arrays.asList(
                    'А', 'а', 'Б', 'б', 'В', 'в', 'Г', 'г',
                    'Е', 'е', 'Є', 'є', 'Ж', 'ж', 'З', 'з', 'И', 'и',
                    'І', 'і', 'Ї', 'ї', 'Й', 'й', 'К', 'к', 'Л', 'л',
                    'М', 'м', 'Н', 'н', 'О', 'о', 'П', 'п', 'Р', 'р',
                    'С', 'с', 'Т', 'т', 'У', 'у', 'Ф', 'ф', 'Х', 'х', 'Ц', 'ц',
                    'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ', 'Ь', 'ь', 'Ю', 'ю', 'Я', 'я',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'
            )
    );
    public static final ArrayList<Character> CHARS_EN = new ArrayList<>(
            Arrays.asList(
                    'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e',
                    'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j',
                    'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
                    'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
                    'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'
            )
    );
    public static final String ENCRYPT_MARK = "[ENCRYPTED]";
    public static final String DECRYPT_MARK = "[DECRYPTED]";
    public static final String ENCRYPT = "ENCRYPT";
    public static final String DECRYPT = "DECRYPT";
    public static final String BRUTE = "BRUTE_FORCE";
}
