package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarController {
    public static void saveCarNames() {
        List<String> carNameList = List.of(readLine().split(","));
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                Car car = new Car(name);
                CarRepository.carList.add(car);
            }
        }
    }
}
