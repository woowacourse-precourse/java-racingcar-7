package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;

public class CarController {
    private static CarService carService = new CarService();

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
