package racingcar.controller;

public class WordsController {
    public static boolean isValid(String words) {
        if (words.startsWith(" ") | words.startsWith(",") | words.endsWith(" ") | words.endsWith(",")) {
            return false;
        }
        return true;
    }

    public static boolean moreThanOne(String words) {
        if (!words.contains(",")) {
            return false;
        }
        return true;
    }
}
