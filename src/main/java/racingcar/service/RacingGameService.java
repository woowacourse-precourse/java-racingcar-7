package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final List<Car> cars = new ArrayList<>();
    private int rounds;

    public void createCars(String input) {
        String[] carNames = input.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public void setRounds(String input) {
        this.rounds = Integer.parseInt(input);
    }

    public List<Car> getCars() {
        return cars;
    }
}
