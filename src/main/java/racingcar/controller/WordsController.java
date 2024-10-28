package racingcar.controller;

public class WordsController {
    public static boolean isValid(String words) {
        return !(words.startsWith(" ") | words.startsWith(",") | words.endsWith(" ") | words.endsWith(","));
    }

    public static boolean moreThanOne(String words) {
        return words.contains(",");
    }
}
