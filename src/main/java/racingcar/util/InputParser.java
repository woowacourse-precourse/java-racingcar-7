package racingcar.util;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.exception.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String DELIMITER = ",";

    public static List<Car> getCarList(final UserInputDTO userInputDTO) {
        List<String> carNames = getCarNames(userInputDTO.names());
        return carNames.stream()
                .map(carName -> new Car(carName, userInputDTO.numOfStages()))
                .collect(Collectors.toList());
    }

    public static List<String> getCarNames(final String names) {
        List<String> carNames = Arrays.stream(names.split(DELIMITER))
                .map(carName -> {
                    InputValidator.checkNameLen(carName);
                    return carName.trim();
                })
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        InputValidator.checkCarCount(carNames);
        return carNames;
    }
}

