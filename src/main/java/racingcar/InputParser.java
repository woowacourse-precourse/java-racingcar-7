package racingcar;

import java.util.LinkedHashMap;

public class InputParser {
    private final String carNames;

    public InputParser(String carNames) {
        this.carNames = carNames;
    }

    public LinkedHashMap<Car, Integer> splitByComma() {
        LinkedHashMap<Car, Integer> result = new LinkedHashMap<>();
        for (String carName : carNames.split(",")) {
            result.put(new Car(carName), 0);
        }
        return result;
    }
}
