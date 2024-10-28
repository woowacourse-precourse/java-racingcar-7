package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class CarsNameParser {


    public static Set<String> parse(String carNamesInput) {
        Set<String> carNames = new HashSet<>();
        for (String carName : carNamesInput.split(",", -1)) {
            addAfterValidated(carName, carNames);
        }
        return carNames;
    }

    private static void addAfterValidated(String carName, Set<String> carNames) {
        InputValidator.validateNameInput(carName);
        carNames.add(carName);
    }
}
