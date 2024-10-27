package racingcar.race.racer.car;

import racingcar.io.CarInputHandler;
import racingcar.race.racer.RacerFactory;

import java.util.ArrayList;
import java.util.List;

public class CarFactory implements RacerFactory<Car> {

    @Override
    public List<Car> createRacers(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
