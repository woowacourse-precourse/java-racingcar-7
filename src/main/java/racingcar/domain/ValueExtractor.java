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

    public static void getWinner(String[] cars, int[] forwardDistance, List<String> winner, int max) {
        for (int index = 0; index < cars.length; index++) {
            if (forwardDistance[index] == max) {
                winner.add(cars[index]);
            }
        }
    }
}
