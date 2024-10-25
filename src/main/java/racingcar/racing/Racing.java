package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.view.Request;


public class Racing {

    final String CAR_NAME_DELIMITER = ",";

    public List<Car> createCar() {
        String carNames = Request.inputCar();
        List<String> carNameList = List.of(carNames.split(CAR_NAME_DELIMITER));

        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
