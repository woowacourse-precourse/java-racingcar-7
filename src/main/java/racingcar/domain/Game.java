package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MAX_NAME_LENGTH = 5;

    private final List<Car> cars;
    private final String rounds;

    public Game(String carNames, String rounds) {
        this.cars = readyCars(carNames);
        this.rounds = rounds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getRounds() {
        return rounds;
    }

    private List<Car> readyCars(String carNames) {
        List<String> carNameList = separateNames(carNames);
        List<Car> cars = new ArrayList<>();

        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private List<String> separateNames(String input) {
        List<String> names = List.of(input.split(","));
        validateName(names);

        return names;
    }

    void validateName(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int max = 0;

        for (Car car : cars) {
            if (car.getCurrentLocation() > max) {
                max = car.getCurrentLocation();
                winner.clear();
                winner.add(car.getName());
            } else if (car.getCurrentLocation() == max) {
                winner.add(car.getName());
            }
        }

        return winner;
    }
}
