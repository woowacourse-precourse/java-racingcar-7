package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class RacingCarService {

    public Race createRace(String carNamesInput) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        return new Race(cars);
    }
}
