package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private final static String COMMA = ",";
    private final static String SPACE = " ";
    private final static int ONE = 1;

    public static String[] process(String input){

        String[] tokens = split(input);

        return Arrays.stream(tokens)
            .map(StringProcessor::trim)
            .toArray(String[]::new);
    }

    public static String formatWinner(List<String> winners){
        return String.join(",",winners);
    }
    
    private static String trim(String input){
        return input.trim();
    }

    private static String[] split(String input){
        return input.split(COMMA);
    }
}
