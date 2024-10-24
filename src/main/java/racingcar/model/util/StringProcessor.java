package racingcar.model.util;

import java.util.Arrays;

public class StringProcessor {

    private final static String COMMA = ",";

    public String[] process(String input){

        String[] tokens = split(input);

        return Arrays.stream(tokens)
            .map(this::trim)
            .toArray(String[]::new);
    }
    private String trim(String input){
        return input.trim();
    }

    private static String[] split(String input){
        return input.split(COMMA);
    }
}
