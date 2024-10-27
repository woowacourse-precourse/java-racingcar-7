package racingcar.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Utils {

    public static ArrayList<String> splitNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static StringBuilder getTotalMoveDistance(int moveDistance) {
        StringBuilder total = new StringBuilder();
        IntStream.range(0, moveDistance).forEach(i -> total.append("-"));
        return total;
    }
}
