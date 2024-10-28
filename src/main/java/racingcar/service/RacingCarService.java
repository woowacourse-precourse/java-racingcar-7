package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingCarService {
    public void createRace(Race race, String[] carNames) {
        for (String carName : carNames) {
            addCarToRace(race, createCar(carName));
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    private void addCarToRace(Race race, Car car) {
        race.addCar(car);
    }
}
