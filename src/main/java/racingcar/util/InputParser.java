package racingcar.util;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.exception.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Car> getCarList(UserInputDTO userInputDTO) {
        List<String> carNames = getCarNames(userInputDTO.names());
        return carNames.stream()
                .map(carName -> {
                    Validator.checkNameLen(carName);
                    return new Car(carName, userInputDTO.numOfStages());
                })
                .collect(Collectors.toList());
    }

    private static List<String> getCarNames(String names) {
        List<String> carNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        Validator.checkCarCount(carNames);
        return carNames;
    }
}

