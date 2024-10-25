package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.view.InputView;

public class CarService {

    public static List<Car> setParticipants() {
        String[] carNames = InputView.getCarNames();
        return convertToCarList(carNames);
    }

    private static List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
