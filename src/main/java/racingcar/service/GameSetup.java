package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import racingcar.validation.CarValidation;
import racingcar.validation.InputValidation;

public class GameSetup {

    private static final String CAR_NAME_DELIMITER = ",";

    public Set<String> splitCarName(String carNameList) {
        Set<String> carNames = new HashSet<>();
        String[] carNameArray = carNameList.split(CAR_NAME_DELIMITER);

        for(String name: carNameArray){
            name = name.trim();

            CarValidation.validateCarName(name, carNames);
        }

        return carNames;
    }

    public int parseAttemptCount(String input) {
        InputValidation.validateNotEmpty(input, InputValidation.EMPTY_INPUT_ERROR);

        return InputValidation.parsePositiveInteger(input);
    }
}
