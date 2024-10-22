package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final String DELIMITER = ",";
    public static List<String> stringToList(String input){
        return Arrays.stream(splitStringToArray(input)).toList();
    }

    private static String[] splitStringToArray(String input){
        return input.split(DELIMITER);
    }
}
