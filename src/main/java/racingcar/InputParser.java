package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputParser {
    public ArrayList<String> parseCarNames(String inputCarNames) {
        ArrayList<String> carNames = new ArrayList<>();
        StringTokenizer carTokenizer = new StringTokenizer(inputCarNames, ",");
        while (carTokenizer.hasMoreTokens()) {
            carNames.add(carTokenizer.nextToken());
        }
        return carNames;
    }

    public int parseTryCount(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
