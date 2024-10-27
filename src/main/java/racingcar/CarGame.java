package racingcar;

import racingcar.car.Car;

import java.util.List;

public class CarGame {
    private final int numberOfTurn;
    private List<Car> entryCars;

    public CarGame(int numberOfTurn, List<Car> entryCars) {
        this.numberOfTurn = numberOfTurn;
        this.entryCars = entryCars;
    }
    private void moveCars() {
        this.entryCars.forEach(Car::forward);
    }

    private List<String> getWinners() {
        int maxPosition = entryCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return entryCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> play() {
        for (int i = 0 ; i < numberOfTurn; i++) {
            moveCars();
        }
        return getWinners();
    }
}
