package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class RacingCarService {

    public Race createRace(String carNamesInput) {
        List<Car> cars = separateCarNames(carNamesInput);

        return new Race(cars);
    }

    private List<Car> separateCarNames(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
