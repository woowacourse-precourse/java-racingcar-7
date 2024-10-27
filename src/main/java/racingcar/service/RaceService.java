package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.exception.InputValidator;
import racingcar.utils.RandNumGenerator;

public class RaceService {
    public List<String> startRacing(String carsNames, String repeatTimes) {
        validateInputs(carsNames, repeatTimes);

        Cars cars = new Cars(carsNames);
        RandNumGenerator randNumGenerator = new RandNumGenerator();

        for (int i = 0; i < Integer.parseInt(repeatTimes); i++) {
            cars.roundProcess(randNumGenerator);
            cars.roundStatus();
        }

        return cars.findWinners();
    }

    private static void validateInputs(String carsNames, String repeatTimes) {
        InputValidator inputValidator = InputValidator.getInstance();

        inputValidator.validateWhiteSpaces(carsNames, repeatTimes);
        inputValidator.validateRepeatTimesNotDigit(repeatTimes);
        inputValidator.validateOutOfRangeRepeatTimes(repeatTimes);
    }
}
