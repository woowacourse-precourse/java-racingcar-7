package racingcar;

import racingcar.domain.Car;
import racingcar.factory.RaceFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Race race = RaceFactory.createRace();
        List<Car> cars = race.startRace();
        race.endRace(cars);
    }
}
