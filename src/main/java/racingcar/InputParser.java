package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputParser {
    public ArrayList<Car> parseCarNames(String inputCarNames) {
        ArrayList<Car> carNames = new ArrayList<>();
        StringTokenizer carTokenizer = new StringTokenizer(inputCarNames, ",");
        while (carTokenizer.hasMoreTokens()) {
            carNames.add(new Car(carTokenizer.nextToken(), 0));
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
