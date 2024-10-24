package racingcar.util;

import java.util.Arrays;

public class StringProcessor {

    private final static String COMMA = ",";

    public static String[] process(String input){

        String[] tokens = split(input);

        return Arrays.stream(tokens)
            .map(StringProcessor::trim)
            .toArray(String[]::new);
    }
    private static String trim(String input){
        return input.trim();
    }

    private static String[] split(String input){
        return input.split(COMMA);
    }
}
