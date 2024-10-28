package racingcar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import racingcar.validation.CarValidation;
import racingcar.validation.InputValidation;

public class GameSetup {

    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> splitCarName(String carNameList) {
        List<String> carNames = new ArrayList<>();
        String[] carNameArray = carNameList.split(CAR_NAME_DELIMITER);

        for(String name: carNameArray){
            name = name.trim();
            CarValidation.validateCarName(name, new HashSet<>(carNames));
            carNames.add(name);
        }

        return carNames;
    }

    public int parseAttemptCount(String input) {
        InputValidation.validateNotEmpty(input, InputValidation.EMPTY_INPUT_ERROR);
        return InputValidation.parsePositiveInteger(input);
    }
}
