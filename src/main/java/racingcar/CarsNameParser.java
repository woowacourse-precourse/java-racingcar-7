package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarsNameParser {


    static Set<String> parse(String carNamesInput) {
        Set<String> carNames = new HashSet<>();
        for (String carName : carNamesInput.split(",", -1)) {
            InputValidator.validateNameInput(carName);
            carNames.add(carName);
        }
        return carNames;
    }


}
