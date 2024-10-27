package controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;

public class RacingController {
    private final List<Car> cars;
    private final int raceRounds;

    public RacingController(List<String> carsList, int raceRounds) {
        this.cars = new ArrayList<>();
        for (String car : carsList) {
            cars.add(new Car(car));
        }
        this.raceRounds = raceRounds;
    }

    public void startRace() {
        for (int round = 0; round < raceRounds; round++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private List<Car> Winners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}

