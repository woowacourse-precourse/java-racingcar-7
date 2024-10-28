package racingcar.service;

import java.util.ArrayList;
import java.util.List;
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

    public void updateRacingCarStatus(Race race) {
        for (Car car : race.getCars()) {
            moveCarPosition(car);
        }
    }

    private void moveCarPosition(Car car) {
        int randomNumber = (int)(Math.random() * 10);
        if (randomNumber >= 4) {
            car.move();
        }
    }

    public String getRaceWinner(Race race) {
        List<Car> cars = race.getCars();
        int maxDistance = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
