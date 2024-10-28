package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputParser {
    Validator validator;

    public InputParser(Validator validator) {
        this.validator = validator;
    }

    public ArrayList<Car> parseCarNames(String inputCarNames) {
        ArrayList<Car> carNames = new ArrayList<>();
        StringTokenizer carTokenizer = new StringTokenizer(inputCarNames, ",");
        while (carTokenizer.hasMoreTokens()) {
            String carName = carTokenizer.nextToken();
            validator.validateCarName(carName);
            carNames.add(new Car(carName, 0));
        }
        return carNames;
    }

    public int parseTryCount(String inputTryCount) {
        try {
            int tryCount = Integer.parseInt(inputTryCount);
            validator.validateTryCount(tryCount);
            return tryCount;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
