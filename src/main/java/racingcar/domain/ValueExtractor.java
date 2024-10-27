package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class ValueExtractor{

    public static String[] getDelimitedValue(String input) {
        return input.split(",", -1);
    }

    public static int getNumericValue(String input) {
        return Integer.parseInt(input);
    }

    public static int getMaxValue(int[] input) {
        return Arrays.stream(input).max().getAsInt();
    }

}
