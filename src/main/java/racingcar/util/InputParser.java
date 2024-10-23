package racingcar.util;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Car> getCarList(UserInputDTO userInputDTO) {
        List<String> carNames = getCarNames(userInputDTO.names());
        return carNames.stream()
                .map(carName -> new Car(carName, userInputDTO.numOfStages()))
                .collect(Collectors.toList());
    }

    private static List<String> getCarNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }
}

