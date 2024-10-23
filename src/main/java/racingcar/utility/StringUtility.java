package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public class StringUtility {
    private final static String CONTAIN_SPECIAL_CHARACTER_REGEX = ".*[^가-힣a-zA-Z0-9].*";

    public static List<String> splitStringToList(String input){
        String[] names = input.split(",");
        return Arrays.asList(names);
    }

    public static boolean containsSpecialCharacter(String input) {
        return input.matches(CONTAIN_SPECIAL_CHARACTER_REGEX);
    }
}
