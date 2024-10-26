package racingcar.domain;

import racingcar.validator.NumberValidator;
import java.util.ArrayList;

public class ValueExtractor{

    public static String[] getDelimitedValue(String input){
        return input.split(",", -1);
    }

    public static int getNumericValue(String input){
        return Integer.parseInt(input);
    }
}
