package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    private StringConvertor(){
    }

    public static int toInt(String input){
        return Integer.parseInt(input);
    }

    public static List<String> toList(String input) {
        return Arrays.asList(input.split(","));
    }
}

